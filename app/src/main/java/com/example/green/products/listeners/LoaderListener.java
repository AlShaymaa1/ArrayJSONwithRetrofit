package com.example.green.products.listeners;



import com.example.green.products.model.productModel;

import java.util.ArrayList;


public interface LoaderListener {

    void onItemsRetrived(ArrayList<productModel> items);
}
