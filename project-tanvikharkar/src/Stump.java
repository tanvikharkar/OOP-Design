import processing.core.PImage;

import java.util.List;

public class Stump extends ActiveEntity{
    public Stump(String id,
                 Point position,
                 List<PImage> images,
                 int imageIndex,
                 int actionPeriod)
    {
        super(id, position, images, imageIndex, actionPeriod);
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
    }
}
