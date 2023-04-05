import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HiddenImage
{
    public static void readPoints(List<Point> points, String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            String [] data = scanner.nextLine().split(",");
            double x = Double.parseDouble(data[0]);
            double y = Double.parseDouble(data[1]);
            double z = Double.parseDouble(data[2]);
            points.add(new Point(x,y,z));
        }
        scanner.close();
    }

    public static void writePoints(List<Point> points, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for(Point p : points)
        {
            writer.write(p.getX() + ", " + p.getY() + ", "+ p.getZ());
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException
    {
        List<Point> points = new ArrayList<>();
        readPoints(points, "positions.txt");

        double scale = 0.5;
        Point translate = new Point(-150, -37, 0);

        List<Point> hiddenPoints = points.stream()
                .filter(p -> p.getZ() <= 2.0)
                .map(p -> new Point(p.getX() * scale, p.getY() * scale, p.getZ() * scale))
                .map(p -> new Point(p.translate(translate)))
                .collect(Collectors.toList());

        writePoints(hiddenPoints, "drawMe.txt");
    }
}