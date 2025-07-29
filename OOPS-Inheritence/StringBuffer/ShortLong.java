public class ShortLong {
    public static void main(String[] args) {
        String a = "hi";
        String b = "hello";
        
        String result;
        if (a.length() < b.length()) {
            result = a + b + a;
        } else {
            result = b + a + b;
        }
        System.out.println(result);
    }
}
