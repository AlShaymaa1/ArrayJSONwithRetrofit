package com.example.green.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.green.products.adapter.DataAdapter;
import com.example.green.products.model.productModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainViewInterface{

    @Bind(R.id.card_recycler_view)
    RecyclerView recyclerView;

    private DataAdapter adapter;
    private MainPresenterIml prodPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prodPresenter = new MainPresenterIml();
        prodPresenter.attachedView(this);
    }

    @Override
    public void setItems(final ArrayList<productModel> Athdata) {

        adapter = new DataAdapter(Athdata, getApplicationContext());

        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
        prodPresenter.getItems();
    }


    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgress() {
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void showMessage(String message) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        prodPresenter.detachView();
    }
}
