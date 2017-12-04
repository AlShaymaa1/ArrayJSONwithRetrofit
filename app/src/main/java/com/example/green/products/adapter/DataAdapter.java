package com.example.green.products.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.green.products.R;
import com.example.green.products.model.Image;
import com.example.green.products.model.productModel;;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<productModel> products;
    private Context context;


    public DataAdapter(ArrayList<productModel> products, Context context  ) {
        this.context=context;
        this.products = products;

    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
////////////////////////////////




        viewHolder.description.setText(products.get(i).getProductDescription());

        String path = products.get(i).getImage().getUrl();
        Log.e("bejbce", path);
        try {
            ViewGroup.LayoutParams params = viewHolder.img.getLayoutParams();
            params.height = products.get(i).getImage().getHeight();
            viewHolder.img.setLayoutParams(params);
            Picasso.with(context).load(products.get(i).getImage().getUrl()).into(viewHolder.img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.price.setText("$"+products.get(i).getPrice());

    }


    @Override
    public int getItemCount() {
        return products.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.prod_desc_txt)
    TextView description;
    @Bind(R.id.image_id)
    ImageView img;
        @Bind(R.id.price_txt)
        TextView price;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

