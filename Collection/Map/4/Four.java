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

public class Four {
    public static void main(String[] args) {
        HashMap<String, Integer> contactList = new HashMap<>();
        contactList.put("ALu", 987654321);
        contactList.put("Vani", 987123456);
        contactList.put("Rahul", 912345678);

        System.out.println("Contains key 'Aman'? " + contactList.containsKey("Aman"));
        System.out.println("Contains value 912345678? " + contactList.containsValue(912345678));

        for (Map.Entry<String, Integer> entry : contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
