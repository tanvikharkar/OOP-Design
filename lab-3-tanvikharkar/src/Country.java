//package part2;
import java.util.List;
import java.util.Map;

public class Country implements GreenhouseGasEmitter {
    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, Emission> getEmissions() {
        return this.emissions;
    }

    public int getYearWithHighestEmissions() {
        double currEmission = 0;
        int year = 0;
        for (Map.Entry<Integer, Emission> entry : this.emissions.entrySet()) {
            double emissionSum = entry.getValue().getCO2() + entry.getValue().getN2O() + entry.getValue().getCH4();
            if (emissionSum > currEmission) {
                currEmission = emissionSum;
                year = entry.getKey();
            }
        }
        return year;
    }

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year) {
        double currCH4 = 0;
        Country topEmitter = null;
        for(Country country : countries) {
            if (currCH4 < country.getEmissions().get(year).getCH4()){
                currCH4 = country.getEmissions().get(year).getCH4();
                topEmitter = country;
            }
        }
        return topEmitter;
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear) {
        double currCH4 = 0;
        Country topEmitter = null;
        for (Country country : countries) {
            double year1 = country.getEmissions().get(startYear).getCH4() + country.getEmissions().get(startYear).getN2O() + country.getEmissions().get(startYear).getCO2();
            double year2 = country.getEmissions().get(endYear).getCH4() + country.getEmissions().get(endYear).getN2O() + country.getEmissions().get(endYear).getCO2();
            double diff = year2 - year1;
            if (diff > currCH4) {
                currCH4 = diff;
                topEmitter = country;
            }
        }
        if (topEmitter != null) {
            System.out.println(topEmitter.getName() + ", Change in emissions: " + currCH4);
        }
        return topEmitter;
    }

    public double getEmissionsInYear(int year) {
        return this.emissions.get(year).getCH4() + this.emissions.get(year).getCO2() + this.emissions.get(year).getN2O();
    }

    public double getTotalEmissionsInYear(int year) {
        return this.getEmissionsInYear(year);
    }
}
