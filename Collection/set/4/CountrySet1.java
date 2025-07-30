import java.util.TreeSet;

public class CountrySet1 {
    private TreeSet<String> H1 = new TreeSet<>();

    // Method to save country names
    public TreeSet<String> saveCountryNames(String countryName) {
        H1.add(countryName);
        return H1;
    }

    // Method to get a country by name
    public String getCountry(String countryName) {
        for (String country : H1) {
            if (country.equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        return null;
    }

    // Main method to test the methods
    public static void main(String[] args) {
        CountrySet1 obj = new CountrySet1();

        obj.saveCountryNames("India");
        obj.saveCountryNames("USA");
        obj.saveCountryNames("Germany");
        obj.saveCountryNames("Australia");

        System.out.println("TreeSet after adding countries: " + obj.H1);
        System.out.println("Get Country 'USA': " + obj.getCountry("USA"));
        System.out.println("Get Country 'Japan': " + obj.getCountry("Japan"));  // will return null
    }
}
