package com.example.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class goodAdapter extends ArrayAdapter<Order> {


    Context context;
     int resource;

    public goodAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Order> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int goodImage = getItem(position).getImage();
        String goodTitle = getItem(position).getProductName();
        int goodPrice = getItem(position).getPrice();
        int quantity = getItem(position).getQuentity();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView= layoutInflater.inflate(R.layout.list_item,parent, false);

        ImageView image_tv = convertView.findViewById(R.id.goodImage);
        TextView title_tv = convertView.findViewById(R.id.goodName);
        TextView quantity_tv = convertView.findViewById(R.id.goodQuantity);
        TextView price_tv = convertView.findViewById(R.id.goodPrice);
        Button delete = convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDB l = new  LocalDB();
                l.removeGood(position);
                notifyDataSetChanged();
            }
        });

        image_tv.setImageResource(goodImage);
        title_tv.setText(goodTitle);
        quantity_tv.setText(String.valueOf(quantity));
        price_tv.setText(String.valueOf(goodPrice));


        return convertView;
    }
}
