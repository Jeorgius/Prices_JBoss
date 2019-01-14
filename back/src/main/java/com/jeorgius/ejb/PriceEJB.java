package com.jeorgius.ejb;

import com.jeorgius.entities.Price;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PriceEJB {

    @PersistenceContext(unitName = "userUnit")
    private EntityManager em;

    public void importPrice(List<Price> imPrice){
        em.persist(imPrice);
    }

    public List<Price> exportPrices(String product_code){
        TypedQuery<Price> query = em.createQuery("Select p from Price p",Price.class);
        return query.getResultList();
    }
}
