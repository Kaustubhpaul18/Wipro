import java.util.ArrayList;
import java.util.HashMap;

class CountryCapitalProcessor {

    public HashMap<String, String> M1 = new HashMap<>();

    public HashMap<String, String> addCountryCapital(String countryName, String capital) {
        M1.put(countryName, capital);
        return M1;
    }

    public String findCapitalByCountry(String countryName) {
        return M1.get(countryName);
    }

    public String findCountryByCapital(String capitalName) {

        for (String country : M1.keySet()) {

            if (M1.get(country).equals(capitalName)) {
                return country;
            }
        }
        return null;
    }

    public HashMap<String, String> createCapitalToCountryMap() {
        HashMap<String, String> M2 = new HashMap<>();

        for (String country : M1.keySet()) {
            String capital = M1.get(country);
            M2.put(capital, country);
        }
        return M2;
    }

    public ArrayList<String> getListOfCountries() {
        ArrayList<String> countryList = new ArrayList<>();
        countryList.addAll(M1.keySet());
        return countryList;
    }
}

public class Maps {
public static void main(String[] args) {
    	
       CountryCapitalProcessor processor = new CountryCapitalProcessor();

      
       System.out.println("--- 1. Saving Country Capitals ---");
       System.out.println("M1 after adding India-Delhi: " + processor.addCountryCapital("India", "Delhi"));
       System.out.println("M1 after adding Japan-Tokyo: " + processor.addCountryCapital("Japan", "Tokyo"));
       System.out.println("M1 after adding USA-Washington D.C.: " + processor.addCountryCapital("USA", "Washington D.C."));
       System.out.println("M1 after adding UK-London: " + processor.addCountryCapital("UK", "London"));
       System.out.println("Current M1: " + processor.M1);

       
       System.out.println("\n--- 2. Getting Capital for Country ---");
       System.out.println("Capital of India: " + processor.findCapitalByCountry("India"));
       System.out.println("Capital of Japan: " + processor.findCapitalByCountry("Japan"));
       System.out.println("Capital of France: " + processor.findCapitalByCountry("France"));

       
       System.out.println("\n--- 3. Getting Country for Capital ---");
       System.out.println("Country for capital Delhi: " + processor.findCountryByCapital("Delhi"));
       System.out.println("Country for capital London: " + processor.findCountryByCapital("London"));
       System.out.println("Country for capital Berlin: " + processor.findCountryByCapital("Berlin"));

      
       System.out.println("\n--- 4. Creating Capital-Country Map (M2) ---");
       HashMap<String, String> M2 = processor.createCapitalToCountryMap();
       System.out.println("M2 (Capital -> Country): " + M2);

       
       System.out.println("\n--- 5. Creating List of Countries ---");
       ArrayList<String> countryList = processor.getListOfCountries();
       System.out.println("List of Countries: " + countryList);
}

}
