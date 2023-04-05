//package part2;
import java.util.List;
import java.util.Map;

public class Sector implements GreenhouseGasEmitter {
    private String name;
    private Map<Integer, Double> emissions;

    public Sector(String name, Map<Integer, Double> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, Double> getEmissions() {
        return this.emissions;
    }

    public int getYearWithHighestEmissions() {
        double currEmission = 0;
        int year = 0;
        for (Map.Entry<Integer, Double> entry : this.emissions.entrySet()) {
            double emissionTotal = entry.getValue();
            if (emissionTotal > currEmission) {
                currEmission = emissionTotal;
                year = entry.getKey();
            }
        }
        return year;
    }

    public static Sector sectorWithHighestAverageEmissions(List<Sector> sectors, int startYear, int endYear) {
        double highestAvg = 0;
        Sector topSector = null;

        for (Sector sector : sectors) {
            // Add up all emissions
            double avg = 0;
            for (int i = startYear; i < endYear; i++) {
                avg += sector.getEmissions().get(i); // Get double value of specific year and add to total
            }
            avg /= endYear - startYear;
            if (avg > highestAvg) {
                highestAvg = avg;
                topSector = sector;
            }
        }
        if (topSector != null)
            System.out.println("Sector: " + topSector.getName() + ", Average emissions: " + highestAvg);
        return topSector;
    }

    public double getEmissionsInYear(int year) {
        return this.emissions.get(year);
    }

    public double getTotalEmissionsInYear(int year) {
        return this.getEmissionsInYear(year);
    }
}

