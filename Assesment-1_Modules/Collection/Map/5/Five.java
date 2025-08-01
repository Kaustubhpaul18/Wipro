import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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

public class Five {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("B", "Banana");
        map.put("A", "Apple");
        map.put("C", "Cherry");

        System.out.println("Contains key 'A'? " + map.containsKey("A"));
        System.out.println("Contains value 'Apple'? " + map.containsValue("Apple"));

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}