package de.gabriel.mcdonaldsproject.extraItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.gabriel.mcdonaldsproject.subItem.SubItem;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "extraItems", schema = "public")
public class ExtraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "extraItem_generator")
    @SequenceGenerator(name = "extraItem_generator", sequenceName = "extraItem_seq")
    Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "extraItems")
    private Set<SubItem> subItems = new HashSet<>();
    private double count;
    private String name;
    private double price;

    @ElementCollection
    private List<String> grill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<SubItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(Set<SubItem> subItems) {
        this.subItems = subItems;
    }
}
