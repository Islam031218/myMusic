package com.example.mymusic;

import android.widget.EditText;
import android.widget.ImageView;

public class Order {
    private  int image;
    private String  name ;
    private String productName ;
    private int  quentity ;
    private  int price ;

    public Order(String name, String productName, int quentity, int price, int image) {
        this.name = name;
        this.productName = productName;
        this.quentity = quentity;
        this.price = price;
        this.image = image;
    }

    public int getImage(){
        return image;
    }
    public String getName() {
        return name;
    }


    public String getProductName() {
        return productName;
    }


    public int getQuentity() {
        return quentity;
    }


    public int getPrice() {
        return price;
    }

}
