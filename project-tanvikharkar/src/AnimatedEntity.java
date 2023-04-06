import processing.core.PImage;
import java.util.List;

abstract class AnimatedEntity extends ActiveEntity{
    private int animationPeriod;

    public AnimatedEntity(String id,
                          Point position,
                          List<PImage> images,
                          int imageIndex,
                          int actionPeriod,
                          int animationPeriod)
    {
        super(id, position, images, imageIndex, actionPeriod);
        this.animationPeriod = animationPeriod;
    }

    public int getAnimationPeriod(){
        return this.animationPeriod;
    }

    public void nextImage(){
        this.imageIndex = (this.imageIndex + 1) % this.images.size();
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
    {
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this, Functions.createAnimationAction(this, 0), this.getAnimationPeriod());
    }
}