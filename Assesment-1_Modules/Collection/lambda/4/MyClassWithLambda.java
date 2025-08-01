public class MyClassWithLambda {
    public static void main(String[] args) {
        WordCount wc = (str) -> {
            if (str == null || str.trim().isEmpty()) return 0;
            return str.trim().split("\\s+").length;
        };

        String test = "Java is awesome with lambdas!";
        System.out.println("Total words: " + wc.count(test));
    }
}
