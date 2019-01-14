package com.jeorgius.services;

import com.jeorgius.ejb.PriceEJB;
import com.jeorgius.entities.Price;
import com.jeorgius.services.tools.DateValidator;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class PriceService implements IPrices  {
    private Logger log = Logger.getLogger(PriceService.class.getName());

    @EJB
    private PriceEJB priceEJB;

    @Inject
    private DateValidator dateValidator;

    @Override
    public List<Price> exportPrices(String product_code) {
       return priceEJB.exportPrices(product_code);
    }

    @Override
    public void importPrices(List<Long> priceValues, List<String> date_begin, List<String> date_end, List<String> product_code) throws ParseException {
        List<Date> dates_begin=dateValidator.reParseDates(date_begin);
        List<Date> dates_end=dateValidator.reParseDates(date_end);
    }
}
