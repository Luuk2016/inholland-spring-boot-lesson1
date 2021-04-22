package nl.luukkenselaar.booksrestapi.model;
import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private double price;
    private int year;

    @ManyToOne
    private Shop shop;

    public Book(String name, String author, double price, int year) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}