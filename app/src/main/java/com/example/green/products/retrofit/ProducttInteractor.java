package com.example.green.products.retrofit;

import android.util.Log;

import com.example.green.products.listeners.LoaderListener;
import com.example.green.products.model.JSONResponse;
import com.example.green.products.model.productModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProducttInteractor implements Interactor {

    ArrayList<productModel> items = new ArrayList<>();

    public void loadItems(final LoaderListener loaderListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://grapesnberries.getsandbox.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<productModel>> call = request.getJSON();
        call.enqueue(new Callback<List<productModel>>() {
            @Override
            public void onResponse(Call<List<productModel>> call, Response<List<productModel>> response) {
                List<productModel> jsonResponse = response.body();
                Log.e("products", jsonResponse.toString());
                items = new ArrayList<>(jsonResponse);
                Log.e("pitems", items.get(1).getProductDescription());
                loaderListener.onItemsRetrived(items);

            }

            @Override
            public void onFailure(Call<List<productModel>> call, Throwable t) {
                //Log.e("products", t.getMessage().toString());
                Log.e("error",t.getMessage().toString());
            }
        });
    }

}




