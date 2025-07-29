public class RemoveX {
    public static void main(String[] args) {
        String str = "xHix";

        if (str.length() > 0 && str.charAt(0) == 'x') {
            str = str.substring(1);
        }
        if (str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
            str = str.substring(0, str.length() - 1);
        }
        System.out.println(str);
    }
}
