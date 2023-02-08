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

public class CurrencyActivity extends AppCompatActivity {
    EditText edAmont;
    Button btn;
    Spinner spn1,spn2;
    TextView txtvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        btn=findViewById(R.id.button2);
        edAmont=findViewById(R.id.editTextPersonName);
        spn1=findViewById(R.id.spinner);
        spn2=findViewById(R.id.spinner2);
        txtvalue=findViewById(R.id.textView4);

        String[] from={"USD","Indian RS","Srilankan RS"};
        ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        spn1.setAdapter(adapter);

        String[] to={"USD","Indian RS","Srilankan RS"};
        ArrayAdapter adapter2=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        spn2.setAdapter(adapter2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(edAmont.getText())){
                    edAmont.setError("Please Enter Amount");
                }else {
                    cal();
                }



            }
        });


    }
    public void cal(){
        Double total;
        Double amount=Double.parseDouble(edAmont.getText().toString());


        if (spn1.getSelectedItem().toString() == "USD" && spn2.getSelectedItem().toString() == "Indian RS"){
            total=amount*81.6525;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "USD" && spn2.getSelectedItem().toString() == "Srilankan RS"){
            total=amount*367.5;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "USD" && spn2.getSelectedItem().toString() == "USD"){
            Toast.makeText(CurrencyActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Indian RS" && spn2.getSelectedItem().toString() == "Indian RS"){

            Toast.makeText(CurrencyActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Indian RS" && spn2.getSelectedItem().toString() == "Srilankan RS"){
            total=amount*4.4828;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Indian RS" && spn2.getSelectedItem().toString() == "USD"){
            total=amount*0.0122;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Srilankan RS" && spn2.getSelectedItem().toString() == "Srilankan RS"){

            Toast.makeText(CurrencyActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "Srilankan RS" && spn2.getSelectedItem().toString() == "USD"){
            total=amount*0.0027;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "Srilankan RS" && spn2.getSelectedItem().toString() == "Indian RS"){
            total=amount*0.2231;
            txtvalue.setText(total.toString());
        }
    }
}