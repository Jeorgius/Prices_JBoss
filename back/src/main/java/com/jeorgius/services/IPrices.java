package com.jeorgius.services;

import java.util.List;

public interface IPrices {
    List<String> exportPrices(String product_code);
    void importPrices(List<Long> priceValues);
}
