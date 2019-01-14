package com.jeorgius.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "pricecat", name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String product_code;
    private int number;
    private int depart;
    private Date p_begin;
    private Date p_end;
    private long value;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getProduct_code() {
        return product_code;
    }
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getDepart() {
        return depart;
    }
    public void setDepart(int depart) {
        this.depart = depart;
    }
    public long getValue() {
        return value;
    }
    public void setValue(long value) {
        this.value = value;
    }
    public Date getP_begin() {
        return p_begin;
    }
    public void setP_begin(Date p_begin) {
        this.p_begin = p_begin;
    }
    public Date getP_end() {
        return p_end;
    }
    public void setP_end(Date p_end) {
        this.p_end = p_end;
    }
}
