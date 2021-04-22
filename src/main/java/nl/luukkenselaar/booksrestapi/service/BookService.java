package nl.luukkenselaar.booksrestapi.service;

import nl.luukkenselaar.booksrestapi.model.Book;
import nl.luukkenselaar.booksrestapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get all books by year
    public Iterable<Book> getBooksByYear(int year) {
        return bookRepository.findBookByYear(year);
    }

    // Add a new Book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get a book by its ID
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    // Delete a book
    public void deleteBook(int id) { bookRepository.deleteById(id); }
}