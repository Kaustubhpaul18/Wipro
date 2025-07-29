// Book.java
public class Book {
    private String name;
    private Author author;  // Association with Author class
    private double price;
    private int qtyInStock;

    // Parameterized Constructor
    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    // Print all details
    public void printDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + qtyInStock);
        System.out.println("Author Details: " + author.toString());
    }

    // Main method to test
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling", "jkrowling@example.com", 'F');
        Book book = new Book("Harry Potter and the Philosopher's Stone", author, 499.99, 100);

        book.printDetails();  // Displaying book + author details
    }
}
