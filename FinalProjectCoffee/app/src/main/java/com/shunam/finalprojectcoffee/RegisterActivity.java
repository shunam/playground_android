package com.shunam.finalprojectcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mButtonRegister = (Button) findViewById(R.id.buttonStart);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(RegisterActivity.this, RegisterActivity.class);
                mIntent.putExtra("name", mEditTextName.getText().toString());
                mIntent.putExtra("email", mEditTextEmail.getText().toString());
                startActivity(mIntent);
            }
        });
    }
}
