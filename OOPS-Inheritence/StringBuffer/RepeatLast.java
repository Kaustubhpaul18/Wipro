public class RepeatLast {
    public static void main(String[] args) {
        String str = "Wipro";
        int n = 3;

        String lastN = str.substring(str.length() - n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(lastN);
        }
        System.out.println(result);
    }
}
