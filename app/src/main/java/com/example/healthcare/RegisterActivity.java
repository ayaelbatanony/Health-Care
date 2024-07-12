package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edPassword,edEmail,edCofirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.ednName);
        edPassword = findViewById(R.id.edPinCode);
        edEmail = findViewById(R.id.edAddress);
        edCofirm = findViewById(R.id.edContact);
        tv = findViewById(R.id.textViewExistingUser);
        btn = findViewById(R.id.btnBooking);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String conform = edCofirm.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if (username.length() == 0 ||email.length() == 0 || password.length() == 0 ||conform.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please enter all data", Toast.LENGTH_SHORT).show();
                } else {
                //to ensure pass = confirm
                    if(password.compareTo(conform)==0){
                        db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "password and cofirm didnot match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}