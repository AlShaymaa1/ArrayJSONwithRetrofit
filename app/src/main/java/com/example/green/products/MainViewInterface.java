package com.example.green.products;



import com.example.green.products.model.productModel;

import java.util.ArrayList;


public interface MainViewInterface {
    void setItems(ArrayList<productModel> items);

    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
