package app.model.buyermodel;

import lombok.Data;

import java.util.Date;

@Data
public class BuyerWithSurnameRegionDate {

    private String surname;
    private String region;
    private Date date;
}
