package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {
    EditText edAmont;
    Button btn;
    Spinner spn1,spn2;
    TextView txtvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        edAmont=findViewById(R.id.edittemp);
        spn1=findViewById(R.id.spinnertemp);
        spn2=findViewById(R.id.spinnertemp2);
        btn=findViewById(R.id.buttontemp);
        txtvalue=findViewById(R.id.valuetemp);

        String[] from={"Degree Celsius","Fahrenheit","Kelvin"};
        ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        spn1.setAdapter(adapter);

        String[] to={"Degree Celsius","Fahrenheit","Kelvin"};
        ArrayAdapter adapter2=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        spn2.setAdapter(adapter2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edAmont.getText())){
                    edAmont.setError("Please Enter Amount");
                } else {
                    cal2();
                }

            }
        });
    }
    public void cal2(){
        Double total;
        Double amount=Double.parseDouble(edAmont.getText().toString());


        if (spn1.getSelectedItem().toString() == "Degree Celsius" && spn2.getSelectedItem().toString() == "Fahrenheit"){
            total=amount*33.8;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Degree Celsius" && spn2.getSelectedItem().toString() == "Kelvin"){
            total=amount*274.15;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Degree Celsius" && spn2.getSelectedItem().toString() == "Degree Celsius"){
            Toast.makeText(TemperatureActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Fahrenheit" && spn2.getSelectedItem().toString() == "Fahrenheit"){

            Toast.makeText(TemperatureActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Fahrenheit" && spn2.getSelectedItem().toString() == "Degree Celsius"){
            total=amount*(-17.2222);
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Fahrenheit" && spn2.getSelectedItem().toString() == "Kelvin"){
            total=amount*255.928;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Kelvin" && spn2.getSelectedItem().toString() == "Kelvin"){

            Toast.makeText(TemperatureActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Kelvin" && spn2.getSelectedItem().toString() == "Degree Celsius"){
            total=amount*(-272.15);
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Kelvin" && spn2.getSelectedItem().toString() == "Fahrenheit"){
            total=amount*(-457.87);
            txtvalue.setText(total.toString());
        }
    }
}