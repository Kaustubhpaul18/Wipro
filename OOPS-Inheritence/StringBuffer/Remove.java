public class Remove {
    public static void main(String[] args) {
        String str = "Suman";
        
        if (str.length() <= 2) {
            System.out.println("");
        } else {
            System.out.println(str.substring(1, str.length() - 1));
        }
    }
}
