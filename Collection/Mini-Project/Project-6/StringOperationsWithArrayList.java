import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringOperationsWithArrayList {

    public static List<String> performOperations(String s1, String s2) {
        List<String> results = new ArrayList<>();

        StringBuilder op1Result = new StringBuilder();
        int s2Index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) { // Alternate index (0, 2, 4...)
                op1Result.append(s2);
            } else {
                op1Result.append(s1.charAt(i));
            }
        }
        results.add(op1Result.toString());


    
        String op2Result;
        int firstOccurrence = s1.indexOf(s2);
        int lastOccurrence = s1.lastIndexOf(s2);

        if (firstOccurrence != -1 && firstOccurrence != lastOccurrence) { // S2 appears more than once
            String reversedS2 = new StringBuilder(s2).reverse().toString();
            op2Result = s1.substring(0, lastOccurrence) + reversedS2 + s1.substring(lastOccurrence + s2.length());
        } else { // S2 appears once or not at all
            op2Result = s1 + s2;
        }
        results.add(op2Result);


        // Operation 3: If S2 appears more than once in S1, delete the first occurrence of S2 in S1, else return S1
        String op3Result;
        firstOccurrence = s1.indexOf(s2);
        lastOccurrence = s1.lastIndexOf(s2);

        if (firstOccurrence != -1 && firstOccurrence != lastOccurrence) { // S2 appears more than once
            op3Result = s1.substring(0, firstOccurrence) + s1.substring(firstOccurrence + s2.length());
        } else { // S2 appears once or not at all
            op3Result = s1;
        }
        results.add(op3Result);

        String op4Result;
        int n = s2.length();
        String firstHalfS2;
        String secondHalfS2;

        if (n % 2 != 0) { // Odd number of letters in S2
            firstHalfS2 = s2.substring(0, (n / 2) + 1);
            secondHalfS2 = s2.substring((n / 2) + 1);
        } else { // Even number of letters in S2
            firstHalfS2 = s2.substring(0, n / 2);
            secondHalfS2 = s2.substring(n / 2);
        }
        op4Result = firstHalfS2 + s1 + secondHalfS2;
        results.add(op4Result);


        // Operation 5: If S1 contains characters that is in S2 change all such characters to *
        StringBuilder op5Result = new StringBuilder(s1);
        for (int i = 0; i < s1.length(); i++) {
            char charS1 = s1.charAt(i);
            if (s2.indexOf(charS1) != -1) { // If charS1 is present in S2
                op5Result.setCharAt(i, '*');
            }
        }
        results.add(op5Result.toString());

        return results;
    }

    public static void main(String[] args) {
        String s1 = "JAVAVAVA";
        String s2 = "VA";

        List<String> output = performOperations(s1, s2);

        System.out.println("S1=\"" + s1 + "\"");
        System.out.println("S2=\"" + s2 + "\"");

        for (int i = 0; i < output.size(); i++) {
            System.out.println((i + 1) + ". " + output.get(i));
        }

        // To match the exact sample output format:
        System.out.print("Output:{");
        for (int i = 0; i < output.size(); i++) {
            System.out.print("\"" + output.get(i) + "\"");
            if (i < output.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}