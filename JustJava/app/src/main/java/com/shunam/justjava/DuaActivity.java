package com.shunam.justjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        Intent mIntent = getIntent();
        String suburb = mIntent.getStringExtra("name");

        final AlertDialog.Builder mAlert = new AlertDialog.Builder(DuaActivity.this);
        mAlert.setMessage("Hai " + suburb);
        mAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DuaActivity.this, "Welcome to DuaActiity", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_layout2);
            }
        });

        mAlert.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DuaActivity.this, "DuaACtivity is close", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mAlert.show();
    }
}
