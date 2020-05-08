package app.controller;

import app.model.buyermodel.Buyer;
import app.model.buyermodel.BuyerRegion;
import app.model.buyermodel.BuyerSurnameAndDiscount;
import app.model.buyermodel.BuyerWithSurnameRegionDate;
import app.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    //1
    @GetMapping("/find/all")
    public List<Buyer> findAll() {
        return buyerService.findAllBuyers();
    }

    //ex.1
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createdBuyer(@RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
    }

    //ex.1
    @GetMapping("/find")
    public ResponseEntity<Buyer> findById(@RequestParam int id){
        Buyer buyer = buyerService.findById(id);
        return buyer != null? ResponseEntity.ok(buyer) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //ex.1
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBuyerById(@PathVariable int id) {
        buyerService.removeBuyerById(id);
    }

    //ex.1
    @PatchMapping("/patch/{id}")
    public void editBuyerById(@PathVariable int id, @RequestParam String name) {
        buyerService.patchBuyerById(id,name);
    }

    //ex.1
    @PutMapping("/replace/{id}")
    public void replaceBuyerById(@PathVariable int id, @RequestBody Buyer buyer) {
        buyerService.replaceBuyer(id, buyer);
    }

    //ex.2.b
    @GetMapping("/all/region")
    public List<BuyerRegion> findAllRegion() {
        return buyerService.findAllRegion();
    }

    //ex.3.a
    @GetMapping("/all/surnameAndDiscount")
    public List<BuyerSurnameAndDiscount> findAllBuyerSurnameAndDiscount(){
        return buyerService.findAllSurnameAndDiscount("Нижегородский");
    }

    @GetMapping("/all/find/findBuyerWithSurnameRegionDate")
    public List<BuyerWithSurnameRegionDate> findBuyerWithSurnameRegionDate() {
        return buyerService.findBuyerWithSurnameRegionDate(3);
    }
}
