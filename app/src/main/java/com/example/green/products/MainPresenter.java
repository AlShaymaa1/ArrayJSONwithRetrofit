package com.example.green.products;


public interface MainPresenter<V> {

    void attachedView(V view);

    void detachView();

    void getItems();
}
