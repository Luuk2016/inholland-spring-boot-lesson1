package nl.luukkenselaar.booksrestapi.controller;

import nl.luukkenselaar.booksrestapi.model.Shop;
import nl.luukkenselaar.booksrestapi.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // GET ALL SHOPS
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return ResponseEntity.status(200).body(shops);
    }

    // GET SHOPS BY YEAR
    @RequestMapping(value = "/year/{year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getShopsByYear(@PathVariable int year) {
        try {
            Iterable<Shop> shops = shopService.getShopsByYear(year);
            return ResponseEntity.status(HttpStatus.OK).body(shops);
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GET A SPECIFIC SHOP
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getShopById(@PathVariable int id) {
        try {
            Optional<Shop> shop = shopService.getShopById(id);
            return ResponseEntity.status(HttpStatus.OK).body(shop);
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // ADD A NEW SHOP
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addShop(@RequestBody Shop shop) {
        try {
            Shop result = shopService.addShop(shop);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // DELETE A SHOP
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteShopById(@PathVariable int id) {
        try {
            shopService.deleteShop(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
