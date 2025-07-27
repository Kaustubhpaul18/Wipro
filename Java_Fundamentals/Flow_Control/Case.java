public class Case {
    public static void main(String[] args) {
        char alphabet = 'z';
        char r_alphabet = alphabet;

        if (Character.isUpperCase(alphabet)) {
            r_alphabet = Character.toLowerCase(alphabet);
        } else if (Character.isLowerCase(alphabet)) {
            r_alphabet = Character.toUpperCase(alphabet);
        }
        System.out.println(alphabet + "->" + r_alphabet);
    }
}