import java.util.HashSet;

public class CountrySet {
    private HashSet<String> H1 = new HashSet<>();

    public String saveCountryNames(String countryName) {
        H1.add(countryName);
        return countryName;
    }

    public String getCountry(String countryName) {
        for (String country : H1) {
            if (country.equals(countryName)) {
                return country;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CountrySet obj = new CountrySet();
        obj.saveCountryNames("India");
        obj.saveCountryNames("USA");
        obj.saveCountryNames("Japan");

        System.out.println("Get Country (India): " + obj.getCountry("India"));
        System.out.println("Get Country (Germany): " + obj.getCountry("Germany"));
    }
}
