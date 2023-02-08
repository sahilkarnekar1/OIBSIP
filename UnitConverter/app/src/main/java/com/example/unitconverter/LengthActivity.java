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

public class LengthActivity extends AppCompatActivity {
    EditText edAmont;
    Button btn;
    Spinner spn1,spn2;
    TextView txtvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

      edAmont=findViewById(R.id.ed1212);
      spn1=findViewById(R.id.spinner3);
      spn2=findViewById(R.id.spinner4);
      btn=findViewById(R.id.button4);
      txtvalue=findViewById(R.id.textView8);

        String[] from={"CM","M","KM"};
        ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        spn1.setAdapter(adapter);

        String[] to={"CM","M","KM"};
        ArrayAdapter adapter2=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        spn2.setAdapter(adapter2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aa=edAmont.getText().toString();

                if (TextUtils.isEmpty(edAmont.getText())){
                    edAmont.setError("Please Enter Amount");
                }else {
                    cal1();
                }
            }
        });

    }
    public void cal1(){
        Double total;
        Double amount=Double.parseDouble(edAmont.getText().toString());

        if (spn1.getSelectedItem().toString() == "CM" && spn2.getSelectedItem().toString() == "M"){
            total=amount*0.01;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "CM" && spn2.getSelectedItem().toString() == "KM"){
            total=amount*0.00001;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "CM" && spn2.getSelectedItem().toString() == "CM"){
            Toast.makeText(LengthActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "M" && spn2.getSelectedItem().toString() == "M"){

            Toast.makeText(LengthActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "M" && spn2.getSelectedItem().toString() == "KM"){
            total=amount*0.001;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "M" && spn2.getSelectedItem().toString() == "CM"){
            total=amount*100;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "KM" && spn2.getSelectedItem().toString() == "KM"){

            Toast.makeText(LengthActivity.this, "Please Select Different Attributes", Toast.LENGTH_LONG).show();
        }
        else if (spn1.getSelectedItem().toString() == "KM" && spn2.getSelectedItem().toString() == "CM"){
            total=amount*100000;
            txtvalue.setText(total.toString());
        }
        else if (spn1.getSelectedItem().toString() == "KM" && spn2.getSelectedItem().toString() == "M"){
            total=amount*1000;
            txtvalue.setText(total.toString());
        }
    }
}