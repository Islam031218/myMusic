package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView nameGood;
    TextView quantityGood;
    TextView priceGood;
    Button deleteGoodList;
    ImageView imageGood;
    private ListView listView2;
    TextView textView;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameGood = (TextView) findViewById(R.id.goodName);
        quantityGood = (TextView) findViewById(R.id.goodQuantity);
        priceGood = (TextView) findViewById(R.id.goodPrice);
        deleteGoodList = (Button) findViewById(R.id.delete);
        imageGood = (ImageView) findViewById(R.id.goodImage);
        listView2 = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.text);



        goodAdapter goodAdapter = new goodAdapter(MainActivity2.this, R.layout.list_item, LocalDB.arrayList);
        listView2.setAdapter(goodAdapter);

        if (LocalDB.arrayList.size() <= 0){
            textView.setText("ПУСТОЙ");
        }



    }

}