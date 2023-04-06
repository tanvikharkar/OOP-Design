import processing.core.PImage;
import java.util.List;

abstract class ActiveEntity extends Entity {
    private final int actionPeriod;

    public ActiveEntity(String id,
                        Point position,
                        List<PImage> images,
                        int imageIndex,
                        int actionPeriod)
    {
        super(id, position, images, imageIndex);
        this.actionPeriod = actionPeriod;
    }

    public int getActionPeriod(){
        return this.actionPeriod;
    }

    abstract void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler);

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        scheduler.scheduleEvent(this, Functions.createActivityAction(this, world, imageStore), this.getActionPeriod());
    }
}