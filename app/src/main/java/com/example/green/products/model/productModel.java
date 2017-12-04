package com.example.green.products.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Green on 03/12/2017.
 */

public class productModel implements Parcelable {
    private String id;
    private String productDescription;
    private Image image;
    private String price;

    public productModel(String id, String productDescription, Image image, String price) {
        this.id = id;
        this.productDescription = productDescription;
        this.image = image;
        this.price = price;

    }
    protected productModel(Parcel in) {
        productDescription = in.readString();
        image = (Image) in.readParcelable(Image.class.getClassLoader());
        price = in.readString();
    }

    public static final Creator<productModel> CREATOR = new Creator<productModel>() {
        @Override
        public productModel createFromParcel(Parcel in) {
            return new productModel(in);
        }

        @Override
        public productModel[] newArray(int size) {
            return new productModel[size];
        }
    };

    public String getId() {
        return id;
    }



    public String getProductDescription() {
        return productDescription;
    }





    public Image getImage() {
        return image;
    }



    public String getPrice() {
        return price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productDescription);
        parcel.writeValue(image);
        parcel.writeString(price);

    }
}


