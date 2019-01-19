package com.jeorgius.services;

import com.jeorgius.entities.Price;

import java.util.List;

public interface IPrices {
    void importPrices(List<String> priceValues, List<String> date_begin, List<String> date_end, List<String> product_code) throws Exception;
}
