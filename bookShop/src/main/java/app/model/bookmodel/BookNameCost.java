package app.model.bookmodel;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookNameCost {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private double cost;
}
