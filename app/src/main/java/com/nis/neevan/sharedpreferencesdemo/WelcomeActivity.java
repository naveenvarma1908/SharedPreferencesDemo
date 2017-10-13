package com.nis.neevan.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Loginstate","0");
        editor.commit();
        
        
          button_clear = (Button)findViewById(R.id.bn_Clear);

        details = (TextView)findViewById(R.id.details_textView);

        StringBuilder stringBuilder = new StringBuilder();

        // "" is the default value that is already saved in file or shared Preference.

        stringBuilder.append("Welcome " +sharedPreferences.getString("Username","")).append("\n");
        stringBuilder.append("Entered Email ID is " +sharedPreferences.getString("Email","")).append("\n");
        stringBuilder.append("Given Number Is " +sharedPreferences.getString("phone","")).append("\n");


        //Below we are passing values to TEXTVIEW in WELCOME ACTIVITY.

        details.setText(String.valueOf(stringBuilder));


        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                editor.clear();
                editor.commit();

            }
        });


    }
}
