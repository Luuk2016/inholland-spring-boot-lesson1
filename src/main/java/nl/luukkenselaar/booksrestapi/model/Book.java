package nl.luukkenselaar.booksrestapi.model;

public class Book {

    private int id;
    private String name;
    private String author;
    private double price;
    private int year;

    public Book(int id, String name, String author, double price, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}