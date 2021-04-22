package nl.luukkenselaar.booksrestapi.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int openedIn;

    @OneToMany(mappedBy = "shop")
    private List<Book> books;

    public Shop(String name, int openedIn) {
        this.name = name;
        this.openedIn = openedIn;
    }

    public Shop() {
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

    public void setOpenedIn(int openedIn) {
        this.openedIn = openedIn;
    }

    public int getOpenedIn() {
        return openedIn;
    }
}