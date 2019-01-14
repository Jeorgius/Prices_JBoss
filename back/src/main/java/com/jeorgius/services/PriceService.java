package com.jeorgius.services;

import com.jeorgius.ejb.PriceEJB;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class PriceService implements IPrices  {

    @EJB
    private PriceEJB priceEJB;

    @Override
    public List<String> exportPrices(String product_code) {

        return null;
    }

    @Override
    public void importPrices(List<Long> priceValues) {

    }
}
