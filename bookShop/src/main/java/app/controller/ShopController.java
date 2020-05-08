package app.controller;

import app.model.shopmodel.Shop;
import app.model.shopmodel.ShopName;
import app.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    //ex.1
    @GetMapping("/find/all")
    public List<Shop> findAll() {
        return shopService.findAllShops();
    }

    //ex.1
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createdShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
    }

    //ex.1
    @GetMapping("/find")
    public ResponseEntity<Shop> findById(@RequestParam int id){
        Shop shop = shopService.findById(id);
        return shop != null? ResponseEntity.ok(shop) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //ex.1
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteShopById(@PathVariable int id) {
        shopService.removeShopById(id);
    }

    //ex.1
    @PatchMapping("/patch/{id}")
    public void editShopById(@PathVariable int id, @RequestParam String name) {
        shopService.patchShopById(id,name);
    }

    //ex.1
    @PutMapping("/replace/{id}")
    public void replaceShopById(@PathVariable int id, @RequestBody Shop shop) {
        shopService.replaceShop(id, shop);
    }

    //ex.3.b
    @GetMapping("/all/name")
    public List<ShopName> findAllShopName() {
        List<ShopName> result;
        result = shopService.findAllShopName("Сормовский");
        List<ShopName> tempList = shopService.findAllShopName("Советский");
        tempList.forEach(result::add);
        return result;
    }

    //ex.5.c
    @GetMapping("/all/shopNoRegionAndDiscountBetween")
    public List<ShopName> findShopNoRegionAndDiscountBetween() {
        return shopService.getShopNoRegionAndDiscountBetween("Автозаводский",10,15);
    }
}
