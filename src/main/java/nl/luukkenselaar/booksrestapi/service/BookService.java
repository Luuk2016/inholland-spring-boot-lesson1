package nl.luukkenselaar.booksrestapi.service;

import nl.luukkenselaar.booksrestapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {

    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();

        books.add(new Book(0, "The Brothers Karamazov", "Fyodor Dostoevsky", 15.00, 1879));
        books.add(new Book(1, "War and Peace", "Leo Tolstoy", 15.00, 1869));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, Book book) {
        books.set(id, book);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }
}