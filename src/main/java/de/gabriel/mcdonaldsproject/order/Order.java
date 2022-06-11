package de.gabriel.mcdonaldsproject.order;

import de.gabriel.mcdonaldsproject.subItem.SubItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq")
    Long id;

    private double count;
    private double  price;
    private double orderNum;

    @ElementCollection
    private List<String> grill;

    @ManyToMany
    @JoinTable(
            name="orders_subitems",
            joinColumns = @JoinColumn(name = "subItem_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<SubItem> subItems = new HashSet<>();


//  private List<SubItem> subItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(Set<SubItem> subItems) {
        this.subItems = subItems;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(double orderNum) {
        this.orderNum = orderNum;
    }

    public List<String> getGrill() {
        return grill;
    }

    public void setGrill(List<String> grill) {
        this.grill = grill;
    }

    public void subItem(SubItem subItem) {
        subItems.add(subItem);
    }
}