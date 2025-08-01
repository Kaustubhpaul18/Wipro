public class Palindrome {
    public static void main(String[] args) {
        String input = "madam"; 
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        StringBuffer sb = new StringBuffer(str);
        String reversed = sb.reverse().toString();
        return str.equals(reversed);
    }
}