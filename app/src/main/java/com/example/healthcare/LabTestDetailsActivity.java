package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
TextView tvPackageName,tvTotalCost;
EditText edDetails;
Button btnAddToCart,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackageName=findViewById(R.id.textViewLDPackageName);
        btnAddToCart=findViewById(R.id.buttonLDAddToCart);
        btnBack=findViewById(R.id.buttonLDBack);
        tvTotalCost=findViewById(R.id.textViewLDTotalCost);
        edDetails=findViewById(R.id.editTextLDTextMultiLine);
        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost :"+intent.getStringExtra("text3"+"/-"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext() , "healthcare" , null , 1);

                if(db.checkCart(username , product)==1)
                {
                    Toast.makeText(getApplicationContext() , "product already added " , Toast.LENGTH_SHORT).show();

                }
                else
                {
                    db.addCart(username , product , price, "lab");
                    Toast.makeText(getApplicationContext() , "records inserted to a cart " , Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this , LabTestActivity.class));
                }
            }
        });







    }
}