package com.example.loginshared;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button LoginU;
    CheckBox RmmbrU;
    SharedPreferences Preference;
    SharedPreferences.Editor editor;
    String key = "session";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginU=findViewById(R.id.LoginS);
        RmmbrU=findViewById(R.id.RememberS);
        Preference=this.getSharedPreferences("sessions",Context.MODE_PRIVATE);
        editor=Preference.edit();

        if(CheckSession()) {
            startActivity(new Intent(this, MainActivity2.class));
        }else {
            Toast.makeText(this, "Please Sign in", Toast.LENGTH_SHORT).show();
        }

        LoginU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveSession(RmmbrU.isChecked());
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });
    }
    public boolean CheckSession()
    {
        //boolean session=this.Preference.getBoolean(key,false);
        return this.Preference.getBoolean(key,false);

    }
    public void SaveSession(boolean bear)
    {
        editor.putBoolean(key,bear);
        editor.apply();
    }
}