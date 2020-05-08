package app.service;

import app.model.buyermodel.Buyer;
import app.model.buyermodel.BuyerRegion;
import app.model.buyermodel.BuyerSurnameAndDiscount;
import app.model.buyermodel.BuyerWithSurnameRegionDate;
import app.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {


    @Autowired
    private BuyerRepository buyerRepository;

    //ex.1
    public List<Buyer> findAllBuyers() {
        return buyerRepository.findAll();
    }

    public void addBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    public Buyer findById(int id) {
        return buyerRepository.findById(id).orElse(null);
    }

    public void removeBuyerById(int id) {
        buyerRepository.deleteById(id);
    }

    public void patchBuyerById(int id,String surname ) {
        Buyer buyer = buyerRepository.getOne(id);
        buyer.setSurname(surname);
        buyerRepository.save(buyer);
    }

    public void replaceBuyer(int id, Buyer buyer) {
        buyer.setId(id);
        buyerRepository.save(buyer);
    }

    //ex.2
    public List<BuyerRegion> findAllRegion(){ return buyerRepository.findAllRegion(); }

    //ex.3
    public List<BuyerSurnameAndDiscount> findAllSurnameAndDiscount(String region) {
        return buyerRepository.findAllSurnameAndDiscount(region);
    }

    //ex.5.b
    public List<BuyerWithSurnameRegionDate> findBuyerWithSurnameRegionDate(int month) {
        return buyerRepository.findBuyerWithSurnameRegionDate(month);
    }

}
