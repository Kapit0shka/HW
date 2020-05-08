package app.controller;

import app.model.buymodel.*;
import app.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    //ex.1
    @GetMapping("/find/all")
    public List<Buy> findAll() {
        return buyService.findAllBuys();
    }

    //ex.1
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createdBuy(@RequestBody Buy buy) {
        buyService.addBuy(buy);
    }

    //ex.1
    @GetMapping("/find")
    public ResponseEntity<Buy> findById(@RequestParam int id){
        Buy buy = buyService.findById(id);
        return buy != null? ResponseEntity.ok(buy) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //ex.1
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBuyById(@PathVariable int id) {
        buyService.removeBuyById(id);
    }

    //ex.1
    @PatchMapping("/patch/{id}")
    public void editBuyById(@PathVariable int id, @RequestParam double price) {
        buyService.patchBuyById(id,price);
    }

    //ex.1
    @PutMapping("/replace/{id}")
    public void replaceBuyById(@PathVariable int id, @RequestBody Buy buy) {
        buyService.replaceBuy(id, buy);
    }

    //ex.2.c
    @GetMapping("/find/all/MonthBuy")
    public List<BuyMonth> findMonthBuy() {
        return buyService.findMonthBuy();
    }

    //ex.4.a
    @GetMapping("/find/all/SurnameBuyerAndNameShopBuy")
    public List<SurnameBuyNameShop> findAllBuyerAndShop() {
        return buyService.getSurnameNameShop();
    }

    //ex.4.b
    @GetMapping("/find/all/buyerWithDateSurnameDiscountNameBookQuantity")
    public List<BuyWithDateSurnameDiscountNameBookQuantity> findAllBuyWithDateSurnameDiscountNameBookQuantity() {
        return buyService.getBuyWithDateSurnameDiscountNameBookQuantity();
    }

    //ex5.b
    @GetMapping("/find/all/buyWithIdBuyerDate")
    public List<BuyWithIdBuyerDate> findBuyWithIdBuyerDate() {
        return buyService.getBuyWithIdBuyerDate(600000.0);
    }

    //ex5.d
    @GetMapping("/find/all/BuyWithBookWarehouseQuantityPrice")
    public List<BuyWithBookWarehouseQuantityPrice> findBuyWithBookWarehouseQuantityPrice() {
        return buyService.findBuyWithBookWarehouseQuantityPrice(1);
    }
}
