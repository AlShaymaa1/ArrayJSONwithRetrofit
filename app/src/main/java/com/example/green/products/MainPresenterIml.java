package com.example.green.products;

import com.example.green.products.listeners.LoaderListener;
import com.example.green.products.model.productModel;
import com.example.green.products.retrofit.ProducttInteractor;

import java.util.ArrayList;



public class MainPresenterIml implements MainPresenter<MainViewInterface>, LoaderListener {

    private MainViewInterface mvPview;
    private ProducttInteractor productInteractor;

    @Override
    public void attachedView(MainViewInterface view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        mvPview = view;
    }

    @Override
    public void detachView() {
        mvPview = null;
    }

    @Override
    public void getItems() {
        mvPview.showProgress();
        productInteractor = new ProducttInteractor();
        productInteractor.loadItems(this);
    }


    @Override
    public void onItemsRetrived(ArrayList<productModel> items) {
        mvPview.setItems(items);
        mvPview.hideProgress();

    }
}
