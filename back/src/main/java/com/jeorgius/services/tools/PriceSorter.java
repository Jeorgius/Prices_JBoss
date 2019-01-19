package com.jeorgius.services.tools;

import com.jeorgius.ejb.PriceEJB;
import com.jeorgius.entities.Price;
import com.jeorgius.entities.Product;
import com.jeorgius.states.ImportPriceStates;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class PriceSorter {

    @EJB
    private PriceEJB priceEJB;

    //Merge prices into list for same products that are
    // not yet compared to the ones that are already in DB
    public List<Product> sortPricesInNewProducts(List<String> values, List<Date> dates_begin, List<Date> dates_end, List<String> product_codes){
        List<Product> products = new ArrayList<>();
        for(int i=0;i<product_codes.size();i++){
            boolean addNew = true;
            for (Product product: products) {
                if(product_codes.get(i).equals(product.getId())){
                    product.getPrices().add(new Price(product, 1, dates_begin.get(i), dates_end.get(i), Long.parseLong(values.get(i))));
                    addNew=false;
                }
            }

            if(addNew){
                Price price = new Price(new Product(),1,dates_begin.get(i),dates_end.get(i),Long.parseLong(values.get(i)));
                addProductToNewPack(products,price,product_codes.get(i));
            }
        }
        return products;
    }

    private List<Product> addProductToNewPack(List<Product> products, Price price, String product_code){
        List<Price> prices= new ArrayList<>();
        Product p = new Product();
        p.setId(product_code);
        price.setProduct(p);
        prices.add(price);
        p.setPrices(prices);
        products.add(p);
        return products;
    }

    public List<Product> mergeProducts(List<Product> newProducts){
        for (Product newProduct: newProducts) {
            List<Price> oldPrices = priceEJB.findProductPrices(newProduct.getId());
            List<Price> newPrices = newProduct.getPrices();
            mergeDates(newPrices,oldPrices);
        }
        return newProducts;
    }

    private List<Price> mergeDates(List<Price> newPrices, List<Price> oldPrices){
        List<Price> mergedPrices = new ArrayList<>();
        for (Price newPrice: newPrices) {
            for (Price oldPrice:oldPrices) {
                if(ImportPriceStates.Condition_N_o_N_o(newPrice,oldPrice)){
                    oldPrice.setP_begin(new Date(newPrice.getP_end().getTime()+1000));
                    updatePrices(mergedPrices,newPrice,oldPrice);
                }

                else if(ImportPriceStates.Condition_N_o_o_N(newPrice,oldPrice)){
                    oldPrice.setP_begin(newPrice.getP_begin());
                    oldPrice.setP_end(newPrice.getP_begin());
                    oldPrice.setValue(newPrice.getValue());
                    updatePrices(mergedPrices,oldPrice,oldPrice);
                }

                else if(ImportPriceStates.Condition_o_N_N_o(newPrice,oldPrice)){
                    Price splittedRightPrice = new Price(oldPrice.getProduct(),1,
                            new Date(newPrice.getP_end().getTime()+1000),
                            new Date(oldPrice.getP_end().getTime()),
                            oldPrice.getValue());
                    oldPrice.setP_end(new Date(newPrice.getP_begin().getTime()-1000));
                    updatePrices(mergedPrices,oldPrice,newPrice);
                    updatePrices(mergedPrices,splittedRightPrice,oldPrice);
                }
                else if(ImportPriceStates.Condition_o_N_o_N(newPrice,oldPrice)){
                    oldPrice.setP_end(new Date(newPrice.getP_begin().getTime()-1000));
                    updatePrices(mergedPrices,newPrice,oldPrice);
                }
                else {
                    mergedPrices.add(oldPrice);
                    mergedPrices.add(newPrice);
                }
            }
        }
        return mergedPrices;
    }

    private List<Price> updatePrices(List<Price> prices, Price newPrice, Price oldPrice){
        if(!prices.contains(oldPrice)) prices.add(oldPrice);//?
        if(!prices.contains(newPrice)) prices.add(newPrice);
        prices.replaceAll(price -> {
            if(oldPrice.getId() == price.getId()) return oldPrice;
            else if(newPrice.getId() == price.getId()) return newPrice;
            else return price;
        });
        return prices;
    }
}
