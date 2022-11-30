package com.example.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button SignOut;
    SharedPreferences Preference;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SignOut=findViewById(R.id.button);
        Preference=this.getSharedPreferences("sessions",Context.MODE_PRIVATE);
        editor=Preference.edit();

    SignOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editor.putBoolean("session", false);
            editor.apply();
            Toast.makeText(MainActivity2.this, "You've sign out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    });
    }
}