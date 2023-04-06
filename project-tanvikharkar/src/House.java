import java.util.*;
import processing.core.PImage;

public class House extends Entity {
    public House(String id,
                 Point position,
                 List<PImage> images,
                 int imageIndex)
    {
        super(id, position, images, imageIndex);
    }

//    @Override
//    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
//    }
}
