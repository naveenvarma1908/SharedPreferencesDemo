package com.nis.neevan.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterationActivity extends AppCompatActivity {


    private EditText username,pass,cpass,email,phone;
    private Button create,clear;
    String name,pwd,cpwd,mail,ph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        getSupportActionBar().hide();

        initView();



        name = username.getText().toString();
        pwd = pass.getText().toString();
        cpwd = cpass.getText().toString();
        mail = email.getText().toString();
        ph = phone.getText().toString();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(!pwd.equals(cpwd)){
                        cpass.setError("Password Mismatch");
                    }else {
                        //Actions

                        SharedPreferences sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Username",name);
                        editor.putString("Password",pwd);
                        editor.putString("Email",mail);
                        editor.putString("phone",ph);
                        editor.commit();

                        Intent intent = new Intent(RegisterationActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                username.setText("");
                pass.setText("");
                cpass.setText("");
                email.setText("");
                phone.setText("");

                Toast.makeText(RegisterationActivity.this, "Fields Cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void initView(){


        username = (EditText)findViewById(R.id.edit_username);
        pass = (EditText)findViewById(R.id.edit_pass);
        cpass = (EditText)findViewById(R.id.edit_reenterPass);
        email = (EditText)findViewById(R.id.edit_email);
        phone= (EditText)findViewById(R.id.edit_ph);

        create = (Button)findViewById(R.id.bn_rCreate);
        clear = (Button)findViewById(R.id.bn_rClear);
    }

}
