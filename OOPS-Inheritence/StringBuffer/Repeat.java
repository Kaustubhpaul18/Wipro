public class Repeat {
    public static void main(String[] args) {
        String str = "Wipro";
        int n = str.length();

        String firstTwo = str.length() >= 2 ? str.substring(0, 2) : str;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(firstTwo);
        }

        System.out.println(result);
    }
}
