package com.shunam.finalprojectcoffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {

    private ListView mListViewProduct;
    private Button mButtonOrder;

    // String of array products
    String[] productNames = {"Coffee (57k)", "Cookie (20k)", "Ice Coffee (50k)", "Ice Tea (30k)", "Sausage (70k)"};

    // Price of products
    int[] productPrices = {57000, 20000, 50000, 30000, 70000};

    int[] orderQuantities = {0,0,0,0,0};

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

        mButtonOrder = (Button) findViewById(R.id.buttonOrder);

        mButtonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail("shunam85gmail.com");
            }
        });
    }

    private void sendEmail(String email){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Coffee Order");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Cobain ah");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(OrderActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
