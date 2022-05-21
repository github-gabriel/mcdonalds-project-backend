package de.gabriel.mcdonaldsproject;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "orders", schema = "public")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq")
    private long id;
    private String product;

    public Order() {
    }

    public Order(String product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}