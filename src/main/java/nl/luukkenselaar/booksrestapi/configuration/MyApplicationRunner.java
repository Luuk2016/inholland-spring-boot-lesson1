package nl.luukkenselaar.booksrestapi.configuration;

import nl.luukkenselaar.booksrestapi.model.Book;
import nl.luukkenselaar.booksrestapi.model.Shop;
import nl.luukkenselaar.booksrestapi.service.BookService;
import nl.luukkenselaar.booksrestapi.service.ShopService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private BookService bookService;
    private ShopService shopService;

    public MyApplicationRunner(BookService bookService, ShopService shopService) {
        this.bookService = bookService;
        this.shopService = shopService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create two new shops
        Shop shop1 = new Shop("Bol.com", 1999);
        Shop shop2 = new Shop("Amazon.com", 1994);

        // Add the shops
        shopService.addShop(shop1);
        shopService.addShop(shop2);

        // Create a new book and set the shop
        Book book1 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 15.00, 1879);
        book1.setShop(shop1);

        // Create a new book and set the shop
        Book book2 = new Book("War and Peace", "Leo Tolstoy", 15.00, 1869);
        book2.setShop(shop2);

        // Add the books
        bookService.addBook(book1);
        bookService.addBook(book2);
    }
}
