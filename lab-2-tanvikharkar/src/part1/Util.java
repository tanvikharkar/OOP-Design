package part1;
import java.util.*;
import java.util.Map;

public class Util {
    // returns the year with the highest total emissions in its Map of years to CO2, N20, and CH4 emissions
    public static int getYearWithHighestEmissions(Country country) {
        double currEmission = 0;
        int year = 0;
        for (Map.Entry<Integer, Emission> entry : country.getEmissions().entrySet()) {  // iterating through map of years to its emissions
            double emissionSum = entry.getValue().getCO2() + entry.getValue().getN2O() + entry.getValue().getCH4();
            if (emissionSum > currEmission) {
                currEmission = emissionSum;
                year = entry.getKey();
            }
        }
        return year;
    }

    // returns the year with the highest emissions in its Map of years to emissions
    public static int getYearWithHighestEmissions(Sector sector) {
        double currEmission = 0;
        int year = 0;
        for (Map.Entry<Integer, Double> entry : sector.getEmissions().entrySet()) {
            double emissionTotal = entry.getValue();
            if (emissionTotal > currEmission) {
                currEmission = emissionTotal;
                year = entry.getKey();
            }
        }
        return year;
    }
}
