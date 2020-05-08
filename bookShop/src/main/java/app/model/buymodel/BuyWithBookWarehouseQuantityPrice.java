package app.model.buymodel;

import lombok.Data;

@Data
public class BuyWithBookWarehouseQuantityPrice {

    private String bookName;
    private String warehouse;
    private int quantity;
    private double price;
}
