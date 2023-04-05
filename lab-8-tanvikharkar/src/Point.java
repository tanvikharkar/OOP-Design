public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Point translate(Point translatingPoint){
        return new Point(x + translatingPoint.x, y + translatingPoint.y, z + translatingPoint.z);
    }
}
