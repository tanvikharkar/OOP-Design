import java.util.*;
import processing.core.PImage;

abstract class Entity
{
    private String id;
    private Point position;
    protected List<PImage> images;
    protected int imageIndex;

    public Entity(String id,
                  Point position,
                  List<PImage> images,
                  int imageIndex) {
        this.id = id;
        this.position = position;
        this.images = images;
        this.imageIndex = imageIndex;
    }

    public String getId() {
        return this.id;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public List<PImage> getImages() {
        return this.images;
    }

    public int getImageIndex() {
        return this.imageIndex;
    }
}