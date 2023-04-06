import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import processing.core.PImage;

public class Cat extends MoveableEntity {
    public Cat(
            String id,
            Point position,
            List<PImage> images,
            int imageIndex,
            int actionPeriod,
            int animationPeriod)
    {
        super(id, position, images, imageIndex, actionPeriod, animationPeriod);
    }

    public boolean moveTo(
            WorldModel world,
            Entity target,
            EventScheduler scheduler)
    {
        if (Point.adjacent(this.getPosition(), target.getPosition())) {
            world.removeEntity(target);
            scheduler.unscheduleAllEvents(target);
            return true;
        }
        else {
            Point nextPos = this.nextPosition(world, target.getPosition());

            if (!this.getPosition().equals(nextPos)) {
                Optional<Entity> occupant = world.getOccupant(nextPos);
                occupant.ifPresent(scheduler::unscheduleAllEvents);
                world.moveEntity(this, nextPos);
            }
            return false;
        }
    }

    public Point nextPosition(WorldModel world, Point destPos) {
        PathingStrategy path = new AStarPathingStrategy();
        Predicate<Point> canPass = x -> !world.isOccupied(x) && world.withinBounds(x);
        BiPredicate<Point, Point> inReach = Point::adjacent;

        List<Point> points = path.computePath(this.getPosition(), destPos, canPass, inReach, PathingStrategy.CARDINAL_NEIGHBORS);

        if (points.size() == 0){
            return this.getPosition();
        }
        return points.get(0);
    }

    public void executeActivity(
            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        Optional<Entity> catTarget =
                world.findNearest(this.getPosition(), new ArrayList<>(Arrays.asList(Fairy.class)));

        if (catTarget.isPresent()) {
            Point tgtPos = catTarget.get().getPosition();

            if (this.moveTo(world, catTarget.get(), scheduler)) {
                Entity rat = Functions.createRat("rat_" + this.getId(), tgtPos,
                        Functions.RAT_ACTION_PERIOD, Functions.RAT_ANIMATION_PERIOD,
                        imageStore.getImageList(Functions.RAT_KEY));

                world.addEntity(rat);
                ((ActiveEntity)rat).scheduleActions(scheduler, world, imageStore);
            }
        }

        scheduler.scheduleEvent(this,
                Functions.createActivityAction(this, world, imageStore),
                this.getActionPeriod());
    }
}
