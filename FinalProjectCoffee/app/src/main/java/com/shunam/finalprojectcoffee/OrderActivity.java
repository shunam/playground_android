package com.shunam.finalprojectcoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {

    private ListView mListViewProduct;

    // String of array products
    String[] productNames = {"Coffee (57k)", "Cookie (20k)", "Ice Coffee (50k)", "Ice Tea (30k)", "Sausage (70k)"};

    // Price of products
    int[] productPrices = {57000, 20000, 50000, 30000, 70000};

    // Array of product images
    int[] productImages = {R.drawable.coffee_cup, R.drawable.cookie, R.drawable.ice_coffee, R.drawable.ice_tea, R.drawable.sausage};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mListViewProduct = (ListView) findViewById(R.id.listViewProduct);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < productNames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name", productNames[i]);
            hashMap.put("image", productImages[i] + "");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from = {"name", "image"};//string array
        int[] to = {R.id.textViewProduct, R.id.imageViewProduct};//int array of views id's


        CustomAdapter simpleAdapter = new CustomAdapter(this, arrayList, R.layout.list_product_row, from, to);//Create object and set the parameters for simpleAdapter


        mListViewProduct.setAdapter(simpleAdapter);//sets the adapter for listView
    }
}
