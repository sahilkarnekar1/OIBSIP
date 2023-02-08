package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_currency,btn_length,btn_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_currency = findViewById(R.id.button);
        btn_length = findViewById(R.id.button3);
        btn_temp = findViewById(R.id.button5);
        btn_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CurrencyActivity.class);
                startActivity(intent);
            }
        });

        btn_length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LengthActivity.class);
                startActivity(intent);
            }
        });

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TemperatureActivity.class);
                startActivity(intent);
            }
        });
    }
}