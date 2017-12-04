package com.example.green.products.retrofit;



import com.example.green.products.model.JSONResponse;
import com.example.green.products.model.productModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("products?count=10&from=1")
    Call<List<productModel>> getJSON();
}