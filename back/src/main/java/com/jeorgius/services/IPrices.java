package com.jeorgius.services;

import com.jeorgius.entities.Price;

import java.text.ParseException;
import java.util.List;

public interface IPrices {
    List<Price> exportPrices(String product_code);
    void importPrices(List<Long> priceValues, List<String> date_begin, List<String> date_end, List<String> product_code) throws ParseException;
}
