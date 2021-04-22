package nl.luukkenselaar.booksrestapi.service;

import nl.luukkenselaar.booksrestapi.model.Book;
import nl.luukkenselaar.booksrestapi.model.Shop;
import nl.luukkenselaar.booksrestapi.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Iterable<Shop> getShopsByYear(int year) {
        return shopRepository.getShopByYear(year);
    }

    // Add a new shop
    public Shop addShop(Shop shop) { return shopRepository.save(shop); }

    // Get a shop by its ID
    public Optional<Shop> getShopById(int id) {
        return shopRepository.findById(id);
    }

    // Delete a shop
    public void deleteShop(int id) { shopRepository.deleteById(id); }
}
