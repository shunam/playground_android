package com.shunam.finalprojectcoffee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shuna on 11/16/2016.
 */

public class CustomAdapter extends SimpleAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String, String>> arrayList;
    Button mButtonMinus;
    Button mButtonPlus;
    TextView mTextViewQuantity;

    public CustomAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        inflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View mView = super.getView(position, convertView, parent);
        ImageView imageView = (ImageView) mView.findViewById(R.id.imageViewProduct);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, arrayList.get(position).get("name"), Toast.LENGTH_SHORT).show();
            }
        });

        mButtonMinus = (Button) mView.findViewById(R.id.buttonMinus);
        mButtonPlus = (Button) mView.findViewById(R.id.buttonPlus);

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCost("minus", mView);
            }
        });

        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCost("plus", mView);
            }
        });
        return mView;
    }

    public void calculateCost(String cal, View view){
        mTextViewQuantity = (TextView) view.findViewById(R.id.textViewQuantity);
        int mCurrentCount = Integer.parseInt(mTextViewQuantity.getText().toString());
        if(cal == "plus"){
            int tempCount = mCurrentCount + 1;
            mTextViewQuantity.setText(Integer.toString(tempCount));
        } else {
            int tempCount = mCurrentCount - 1;
            if (tempCount < 0) {
                mTextViewQuantity.setText(Integer.toString(0));
            } else {
                mTextViewQuantity.setText(Integer.toString(tempCount));
            }
        }
    }
}
