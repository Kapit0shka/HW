package app.model.buyermodel;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class BuyerSurnameAndDiscount {
    private String surname;
    private double discount;
}
