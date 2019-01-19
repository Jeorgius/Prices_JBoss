package com.jeorgius.states;

import com.jeorgius.entities.Price;

public class ImportPriceStates {
    // First example of below: New_begin---New_end---old_begin---old_end
    // Possible states: N_N_o_o, N_o_N_o, N_o_o_N, o_N_N_o, o_N_o_N, o_o_N_N
    public static boolean Condition_N_o_N_o(Price newPrice, Price oldPrice){
        return newPrice.getP_begin().getTime() < oldPrice.getP_begin().getTime()
                && newPrice.getP_end().getTime() > oldPrice.getP_begin().getTime()
                && newPrice.getP_end().getTime() < oldPrice.getP_end().getTime();
    }
    public static boolean Condition_N_o_o_N(Price newPrice, Price oldPrice){
        return newPrice.getP_begin().getTime() < oldPrice.getP_begin().getTime()
                && newPrice.getP_end().getTime() > oldPrice.getP_end().getTime();
    }

    public static boolean Condition_o_N_N_o(Price newPrice, Price oldPrice){
        return newPrice.getP_begin().getTime() > oldPrice.getP_begin().getTime()
                && newPrice.getP_end().getTime() < oldPrice.getP_end().getTime();
    }

    public static boolean Condition_o_N_o_N(Price newPrice, Price oldPrice){
        return newPrice.getP_begin().getTime() > oldPrice.getP_begin().getTime()
                && newPrice.getP_end().getTime() > oldPrice.getP_end().getTime();
    }

}
