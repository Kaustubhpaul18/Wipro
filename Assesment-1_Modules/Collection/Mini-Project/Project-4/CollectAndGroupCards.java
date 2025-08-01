import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

// Card class to represent a playing card
class Card {
    private char symbol;
    private int number;

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }

    // It's good practice to override equals and hashCode if objects are used in collections
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return symbol == card.symbol && number == card.number;
    }

    @Override
    public int hashCode() {
        int result = (int) symbol;
        result = 31 * result + number;
        return result;
    }
}

public class CollectAndGroupCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Cards: ");
        int numberOfCards = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Using TreeMap to automatically sort keys (symbols) in alphabetical order
        // The value is a List of Card objects for that symbol
        Map<Character, List<Card>> cardMap = new TreeMap<>();

        for (int i = 1; i <= numberOfCards; i++) {
            System.out.println("Enter card " + i + ":");
            char symbol = scanner.nextLine().charAt(0);
            int number = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            Card card = new Card(symbol, number);

            // Add the card to the list corresponding to its symbol
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }

        System.out.println("Distinct Symbols are:");
        for (Character symbol : cardMap.keySet()) {
            System.out.println(symbol);
        }

        System.out.println("Cards in Set are:");
        // Iterate through the map, which is already sorted by symbol (due to TreeMap)
        for (Map.Entry<Character, List<Card>> entry : cardMap.entrySet()) {
            char symbol = entry.getKey();
            List<Card> cards = entry.getValue();

            // Sort cards within each symbol group by their number for consistent output
            Collections.sort(cards, Comparator.comparingInt(Card::getNumber));

            System.out.println("Symbol: " + symbol);
            int sumOfNumbers = 0;
            for (Card card : cards) {
                System.out.println(card);
                sumOfNumbers += card.getNumber();
            }
            System.out.println("Number of cards: " + cards.size());
            System.out.println("Sum of numbers: " + sumOfNumbers);
            System.out.println(); // Newline for readability between symbols
        }

        scanner.close();
    }
}