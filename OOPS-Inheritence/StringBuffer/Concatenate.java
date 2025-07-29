public class Concatenate {
    public static void main(String[] args) {
        String str1 = "Sachin";
        String str2 = "Tendulkar";
      
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
      
        if (str1.charAt(str1.length() - 1) == str2.charAt(0)) {
            System.out.println(str1 + str2.substring(1));
        } else {
            System.out.println(str1 + str2);
        }
    }
}
