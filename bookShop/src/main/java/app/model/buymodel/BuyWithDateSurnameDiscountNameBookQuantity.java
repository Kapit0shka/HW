package app.model.buymodel;

import lombok.Data;

import java.util.Date;

@Data
public class BuyWithDateSurnameDiscountNameBookQuantity {
    private Date date;
    private String surname;
    private double discount;
    private String nameBook;
    private int quantity;
}
