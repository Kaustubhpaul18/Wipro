import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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

public class CollectUniqueSymbolsFromSetOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Character> uniqueSymbolsFound = new LinkedHashSet<>(); // To keep track of unique symbols encountered
        Set<Card> cardsWithUniqueSymbols = new TreeSet<>(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                // Sort by symbol first, then by number
                int symbolComparison = Character.compare(c1.getSymbol(), c2.getSymbol());
                if (symbolComparison == 0) {
                    return Integer.compare(c1.getNumber(), c2.getNumber());
                }
                return symbolComparison;
            }
        });

        int cardsGathered = 0;

        while (uniqueSymbolsFound.size() < 4) { // Continue until 4 unique symbols are collected
            System.out.println("Enter a card:");
            char symbol = scanner.nextLine().charAt(0);
            int number = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            cardsGathered++;
            
            // If this is a new unique symbol, add the card to our set of unique symbol cards
            if (!uniqueSymbolsFound.contains(symbol)) {
                uniqueSymbolsFound.add(symbol);
                cardsWithUniqueSymbols.add(new Card(symbol, number));
            }
        }

        System.out.println("Four symbols gathered in " + cardsGathered + " cards.");
        System.out.println("Cards in Set are :");

        // cardsWithUniqueSymbols is already sorted due to TreeSet with custom Comparator
        for (Card card : cardsWithUniqueSymbols) {
            System.out.println(card);
        }

        scanner.close();
    }
}