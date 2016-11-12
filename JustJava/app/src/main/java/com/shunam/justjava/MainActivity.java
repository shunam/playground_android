package com.shunam.justjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mMainTextViewName;
    private TextView mMainTextViewAddress;
    private TextView mMainTextViewSex;
    private Button mMainButtonOk;
    private Button mMainButtonCancel;
    private Button mMainButtonIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mMainTextViewName = (TextView) findViewById(R.id.main_name);
        mMainTextViewAddress = (TextView) findViewById(R.id.main_address);
        mMainTextViewSex = (TextView) findViewById(R.id.main_sex);

        mMainButtonOk = (Button) findViewById(R.id.main_button_ok);
        mMainButtonCancel = (Button) findViewById(R.id.main_button_cancel);
        mMainButtonIntent = (Button) findViewById(R.id.main_button_intent);

        mMainButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mMessageName = mMainTextViewName.getText().toString();
                String mMessageAddress = mMainTextViewAddress.getText().toString();
                String mMessageSex = mMainTextViewSex. getText().toString();

                Toast.makeText(MainActivity.this, "Halo " + mMessageName + "\nAlamat: " + mMessageAddress + "\nJenis Kelamin: " + mMessageSex, Toast.LENGTH_SHORT).show();
            }
        });

        mMainButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder mAlert = new AlertDialog.Builder((MainActivity.this));
//
//                mAlert.setTitle("Hello ini alert PERTAMA SAYA");
//                mAlert.setMessage("haiiiii.......");
//
//                mAlert.show();

                final AlertDialog.Builder mAlert = new AlertDialog.Builder(MainActivity.this);
                mAlert.setMessage("Hai");
                mAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Welcome to my application", Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.activity_layout2);
                    }
                });

                mAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bubye", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                mAlert.show();
            }
        });

        mMainButtonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, DuaActivity.class);
                mIntent.putExtra("name", mMainTextViewName.getText().toString());
                startActivity(mIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
