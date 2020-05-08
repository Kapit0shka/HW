package app.service;

import app.model.shopmodel.Shop;
import app.model.shopmodel.ShopName;
import app.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    public Shop findById(int id) {
        return shopRepository.findById(id).orElse(null);
    }

    public void removeShopById(int id) {
        shopRepository.deleteById(id);
    }

    public void patchShopById(int id,String name ) {
        Shop shop = shopRepository.getOne(id);
        shop.setName(name);
        shopRepository.save(shop);
    }

    public void replaceShop(int id, Shop shop) {
        shop.setId(id);
        shopRepository.save(shop);
    }

    //ex.3.b
    public List<ShopName> findAllShopName(String region) {
        return shopRepository.findAllNameShop(region);
    }

    //ex5.c
    public List<ShopName> getShopNoRegionAndDiscountBetween(String region, double minDiscount, double maxDiscount) {
        return shopRepository.getShopNoRegionAndDiscountBetween(region,minDiscount,maxDiscount);
    }

}
