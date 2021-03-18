package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Spinner spinner;
    ArrayAdapter<String > adapter;

    Button butPlus;
    Button butMinus;
    int count = 0 ;

    String priceAll = "300";
    String pricePiano;
    String priceScrip;
    int priceCount = 0;


    TextView quintity;
    TextView price ;
    String counter = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butPlus = (Button) findViewById(R.id.butPlus);
        butMinus = (Button) findViewById(R.id.butMinus);
        quintity = (TextView) findViewById(R.id.quantity);
        price = (TextView) findViewById(R.id.price);

        pricePiano = "430";
        priceScrip = "130";

        butMinus.setOnClickListener(this);
        butPlus.setOnClickListener(this);



        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList  < String > goods =new ArrayList<>();
        goods.add("gitara");
        goods.add("pianino");
        goods.add("scripka");

        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,goods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = parent.getSelectedItem().toString();
                    count = 0;
                    quintity.setText(String.valueOf(count));
                    priceCount = 0;
                    price.setText(String.valueOf(priceCount));

                    if (selected.equals("gitara")){
                        priceAll = "300";
                    }else if (selected.equals("pianino")){
                        priceAll = pricePiano;
                    }else if (selected.equals("scripka")){
                        priceAll = priceScrip;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            }); {

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mune,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.butPlus :
                count++;
                counter = String.valueOf(count);
                quintity.setText(counter);
                priceCount= count * Integer.parseInt(priceAll);
                price.setText(String.valueOf(priceCount));
                break;
            case R.id.butMinus :
                String  st = String.valueOf(quintity.getText());
                int a = Integer.parseInt(st);
                if (a > 0){
                    count -- ;
                    counter = String.valueOf(count);
                    quintity.setText(counter);
                }
                break;
        }
    }
}