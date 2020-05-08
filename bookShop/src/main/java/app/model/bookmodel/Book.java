package app.model.bookmodel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    @Column(name = "warehouse")
    private String wareHouse;
    private int quantity;
}
