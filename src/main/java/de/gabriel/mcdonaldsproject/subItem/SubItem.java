package de.gabriel.mcdonaldsproject.subItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.gabriel.mcdonaldsproject.extraItem.ExtraItem;
import de.gabriel.mcdonaldsproject.order.Order;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subItems", schema = "public")
public class SubItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subItem_generator")
    @SequenceGenerator(name = "subItem_generator", sequenceName = "subItem_seq")
    Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "subItems")
    private Set<Order> orders = new HashSet<>();

    private double count;
    private String name;
    private double price;

    @ElementCollection
    private List<String> grill;

    @ManyToMany
    @JoinTable(
            name = "subItems_extraItems",
            joinColumns = @JoinColumn(name = "subItem_id"),
            inverseJoinColumns = @JoinColumn(name = "extraItem_id")
    )
    private Set<ExtraItem> extraItems = new HashSet<>();

//   private List<ExtraItem> extraItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getGrill() {
        return grill;
    }

    public void setGrill(List<String> grill) {
        this.grill = grill;
    }

    public Set<ExtraItem> getExtraItems() {
        return extraItems;
    }

    public void setExtraItems(Set<ExtraItem> extraItems) {
        this.extraItems = extraItems;
    }

    public void extraItem(ExtraItem extraItem) {
        extraItems.add(extraItem);
    }
}
