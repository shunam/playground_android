package com.shunam.justjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DuaActivity extends AppCompatActivity {

    private Button mButtonMinus;
    private Button mButtonPlus;
    private TextView mCount;
    private TextView mTotal;
    private int price = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);

        Intent mIntent = getIntent();
        String suburb = mIntent.getStringExtra("name");

        mButtonMinus = (Button) findViewById(R.id.order_button_minus);
        mButtonPlus = (Button) findViewById(R.id.order_button_plus);
        mCount = (TextView) findViewById(R.id.order_coffee_count);
        mTotal = (TextView) findViewById(R.id.order_coffee_total_order);

//        final AlertDialog.Builder mAlert = new AlertDialog.Builder(DuaActivity.this);
//        mAlert.setMessage("Hai " + suburb);
//        mAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(DuaActivity.this, "Welcome to DuaActiity", Toast.LENGTH_SHORT).show();
//                setContentView(R.layout.activity_layout2);
//            }
//        });
//
//        mAlert.setNegativeButton("Back", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(DuaActivity.this, "DuaACtivity is close", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        });
//
//        mAlert.show();

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCost("minus");
            }
        });

        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCost("plus");
            }
        });
    }

    public void calculateCost(String cal){
        int mCurrentCount = Integer.parseInt(mCount.getText().toString());
        if(cal == "plus"){
            int tempCount = mCurrentCount + 1;
            mCount.setText(Integer.toString(tempCount));
            setPrice(Integer.toString(tempCount*price));
        } else {
            int tempCount = mCurrentCount - 1;
            if (tempCount < 0) {
                mCount.setText(Integer.toString(0));
                setPrice("0");
            } else {
                mCount.setText(Integer.toString(tempCount));
                setPrice(Integer.toString(tempCount*price));
            }
        }
    }

    public void setPrice(String price) {
        mTotal.setText(price);
    }
}
