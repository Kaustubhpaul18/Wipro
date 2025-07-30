import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class Three {
    public static void main(String[] args) {
        Properties states = new Properties();
        states.put("West Bengal", "Kolkata");
        states.put("Maharashtra", "Mumbai");
        states.put("Karnataka", "Bengaluru");

        Set<Object> keys = states.keySet();
        Iterator<Object> iterator = keys.iterator();

        while(iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + " => " + states.getProperty((String) key));
        }
    }
}