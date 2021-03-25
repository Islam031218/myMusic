package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spinner;

    private ArrayAdapter<String> adapter;
    public static ArrayList<Order> orderArrayList;
    private HashMap<String, Integer> database;

    LocalDB  localDB;

    private int counterPrice = 0;
    private int countquatity = 0;
   private int priceCount = 0;


    private String selected;
    private String priceGuitara = "300";
    private String pricePiano = "400";
    private String priceScrip = "500";


    private EditText name;
    private ImageView image;
    private TextView quintity;
    private TextView price;
    Button butPlus;
    Button butMinus;
    Button addToCard;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new HashMap<>();
        database.put("gitara", 700);
        database.put("pianino", 500);
        database.put("scripka", 300);

        butPlus = (Button) findViewById(R.id.butPlus);
        butMinus = (Button) findViewById(R.id.butMinus);
        quintity = (TextView) findViewById(R.id.quantity);
        addToCard = (Button) findViewById(R.id.addToCard);
        price = (TextView) findViewById(R.id.price);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);


        butMinus.setOnClickListener(this);
        butPlus.setOnClickListener(this);
        addToCard.setOnClickListener(this);

        orderArrayList = new ArrayList<>();


        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> goods = new ArrayList<>();
        goods.add("gitara");
        goods.add("pianino");
        goods.add("scripka");

        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, goods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    //Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mune, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // onClickListener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butPlus:
                if (selected.equals("gitara")) {
                    countquatity ++;
                    quintity.setText(String.valueOf(countquatity));

                    counterPrice = countquatity * Integer.parseInt(priceGuitara);
                    price.setText(String.valueOf(counterPrice));
                } else if (selected.equals("pianino")){
                    countquatity ++;
                    quintity.setText(String.valueOf(countquatity));

                    counterPrice = countquatity * Integer.parseInt(pricePiano);
                    price.setText(String.valueOf(counterPrice));
                }else  if (selected.equals("scripka")){
                    countquatity ++;
                    quintity.setText(String.valueOf(countquatity));

                    counterPrice = countquatity * Integer.parseInt(priceScrip);
                    price.setText(String.valueOf(counterPrice));
                }
                break;
            case R.id.butMinus:
                String st = String.valueOf(quintity.getText());

                if (Integer.parseInt(st) > 0) {
                    if (selected.equals("gitara")) {
                        countquatity --;
                        quintity.setText(String.valueOf(countquatity));

                        counterPrice = countquatity * Integer.parseInt(priceGuitara);
                        price.setText(String.valueOf(counterPrice));
                    } else if (selected.equals("pianino")){
                        countquatity --;
                        quintity.setText(String.valueOf(countquatity));

                        counterPrice = countquatity * Integer.parseInt(pricePiano);
                        price.setText(String.valueOf(counterPrice));
                    }else  if (selected.equals("scripka")){
                        countquatity --;
                        quintity.setText(String.valueOf(countquatity));

                        counterPrice = countquatity * Integer.parseInt(priceScrip);
                        price.setText(String.valueOf(counterPrice));
                    }
                }
                break;
            case R.id.addToCard:
                String string = name.getText().toString();
                int index = 0;
                if (selected.equals("gitara")){
                    index = R.drawable.brand;
                }else if (selected.equals("pianino")){
                    index = R.drawable.pionino;
                }
                else  if (selected.equals("scripka")){
                    index = R.drawable.scripca;
                }


                if (string.equals("") || string.equals(" ")) {
                    Toast.makeText(MainActivity.this, "пожалуйсто введите ваш имя", Toast.LENGTH_SHORT).show();
                } else {

                    orderArrayList.add(new Order(string, selected, countquatity, counterPrice,index));
                    LocalDB localDB = new LocalDB();
                    localDB.addGood(new Order(string, selected, countquatity, counterPrice, index));
                    Toast.makeText(MainActivity.this, "arrayList " + orderArrayList.size(), Toast.LENGTH_SHORT).show();

                }
        }
    }


    // onSelectedListener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected = parent.getSelectedItem().toString();

        if (selected.equals("gitara")) {
            image.setImageResource(R.drawable.brand);
            price.setText("300");
            countquatity = 1;
            quintity.setText(String.valueOf(countquatity));
        } else if (selected.equals("pianino")) {
            image.setImageResource(R.drawable.pionino);
            price.setText("400");
            countquatity = 1;
            quintity.setText(String.valueOf(countquatity));
        } else if (selected.equals("scripka")) {
            image.setImageResource(R.drawable.scripca);
            price.setText("500");
            countquatity = 1;
            quintity.setText(String.valueOf(countquatity));        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.basket:
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
        return super.onOptionsItemSelected(item);
    }
}