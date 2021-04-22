package nl.luukkenselaar.booksrestapi.repository;

import nl.luukkenselaar.booksrestapi.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Iterable<Book> findBookByYear(int minimumYear);
}
