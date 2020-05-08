package app.service;

import app.model.buymodel.*;
import app.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {

    @Autowired
    private BuyRepository buyRepository;

    public List<Buy> findAllBuys() {
        return buyRepository.findAll();
    }

    public void addBuy(Buy buy) {
        buyRepository.save(buy);
    }

    public Buy findById(int id) {
        return buyRepository.findById(id).orElse(null);
    }

    public void removeBuyById(int id) {
        buyRepository.deleteById(id);
    }

    public void patchBuyById(int id,double price ) {
        Buy buy = buyRepository.getOne(id);
        buy.setPrice(price);
        buyRepository.save(buy);
    }

    public void replaceBuy(int id, Buy buy) {
        buy.setId(id);
        buyRepository.save(buy);
    }

    //2.c
    public List<BuyMonth> findMonthBuy() {
        return buyRepository.findMonthBuy();
    }

    //ex.4.a
    public List <SurnameBuyNameShop> getSurnameNameShop(){
        return buyRepository.getSurnameNameShop();
    }

    //ex.4.b
    public List<BuyWithDateSurnameDiscountNameBookQuantity> getBuyWithDateSurnameDiscountNameBookQuantity() {
        return buyRepository.getBuyWithDateSurnameDiscountNameBookQuantity();
    }

    //ex5.a
    public List<BuyWithIdBuyerDate> getBuyWithIdBuyerDate(double cost) {
        return buyRepository.getBuyWithIdBuyerDate(cost);
    }

    //ex5.d
    public List<BuyWithBookWarehouseQuantityPrice> findBuyWithBookWarehouseQuantityPrice(int quantity) {
        return buyRepository.getBuyWithBookWarehouseQuantityPrice(quantity);
    }
}
