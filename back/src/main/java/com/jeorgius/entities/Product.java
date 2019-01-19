package com.jeorgius.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product", schema = "pricecat")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Price> prices;

    public Product(List<Price> prices, String id) {
        this.prices = prices;
        this.id = id;
    }

    public Product(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
