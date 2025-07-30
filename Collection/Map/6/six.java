import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

public class six {
    public static void main(String[] args) {
        // Use CountryCapitalProcessor to avoid "never used" warning
        CountryCapitalProcessor processor = new CountryCapitalProcessor();
        processor.addCountryCapital("India", "New Delhi");
        processor.addCountryCapital("USA", "Washington D.C.");

        HashMap<String, String> map = new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");

        System.out.println("Contains key 'C'? " + map.containsKey("C"));
        System.out.println("Contains value 'Cherry'? " + map.containsValue("Cherry"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}