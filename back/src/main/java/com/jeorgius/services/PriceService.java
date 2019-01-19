package com.jeorgius.services;

import com.jeorgius.ejb.PriceEJB;
import com.jeorgius.entities.Price;
import com.jeorgius.entities.Product;
import com.jeorgius.services.tools.DateValidator;
import com.jeorgius.services.tools.PriceSorter;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class PriceService implements IPrices  {
    private Logger log = Logger.getLogger(PriceService.class.getName());

    @Inject
    private DateValidator dateValidator;

    @Inject
    private PriceSorter priceSorter;

    @Override
    public void importPrices(List<String> priceValues, List<String> date_begin, List<String> date_end, List<String> product_code) throws Exception {
        List<Date> dates_begin = dateValidator.reParseDates(date_begin);
        List<Date> dates_end = dateValidator.reParseDates(date_end);

        dateValidator.ValidateBeginEnd(dates_begin,dates_end);
        log.info(dates_begin.toString());
        log.info(dates_end.toString());

        List<Product> newProducts = priceSorter.sortPricesInNewProducts(priceValues,dates_begin,dates_end,product_code);

    }
}
