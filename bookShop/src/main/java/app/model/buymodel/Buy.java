package app.model.buymodel;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "timepurchase")
    private Date timePurchase;
    private int seller;
    private int buyer;
    private int book;
    private int quantity;
    private double price;
}
