package app.model.buymodel;

import lombok.Data;

import java.util.Date;

@Data
public class BuyWithIdBuyerDate {

    private int id;
    private String buyer;
    private Date date;
}
