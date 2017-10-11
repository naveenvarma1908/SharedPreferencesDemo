package com.nis.neevan.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login,cancel,reg;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initView();

        final SharedPreferences sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Loginstate","1");
        editor.commit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = username.getText().toString();
                pass = password.getText().toString();

                if(name.equals("")){
                    username.setError("Enter Username");
                }else  if(pass.equals("")){
                    password.setError("Enter Password");
                }else{
                    //Actions

                    String spname = sharedPreferences.getString("Username","");
                    String sppass = sharedPreferences.getString("Password","");

                    if (spname.equals(name) && sppass.equals(pass)){

                        Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
                        startActivity(intent);
                        finish();

                    }else {

                        Toast.makeText(LoginActivity.this, "Invalid Username & Password", Toast.LENGTH_SHORT).show();
                    }




                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initView(){

        username = (EditText)findViewById(R.id.edit_LUsername);
        password = (EditText)findViewById(R.id.editText_Lpass);


        login = (Button)findViewById(R.id.button_Login);
        cancel= (Button)findViewById(R.id.button_Lcancel);
        reg = (Button)findViewById(R.id.button_LRegister);





    }
}
