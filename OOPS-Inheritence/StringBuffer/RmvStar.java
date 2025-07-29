public class RmvStar {
    public static void main(String[] args) {
        String str = "ab*cd"; 
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || (i > 0 && str.charAt(i - 1) == '*') || (i < str.length() - 1 && str.charAt(i + 1) == '*')) {
                continue;
            }
            result.append(str.charAt(i));
        }
        System.out.println(result);
    }
}
