package nl.luukkenselaar.booksrestapi.repository;

import nl.luukkenselaar.booksrestapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query("select s from Shop s where s.openedIn = ?1")
    Iterable<Shop> getShopByYear(int year);
}
