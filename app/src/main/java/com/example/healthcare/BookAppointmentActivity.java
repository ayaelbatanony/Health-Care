package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    TextView tv;
private Button dateButton , btnBack;
    private  Button timeButton,btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.ednName);
        ed2 = findViewById(R.id.edAddress);
        ed3 = findViewById(R.id.edPinCode);
        ed4 = findViewById(R.id.edContact);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppTime);
        btnBack = findViewById(R.id.buttonAppBack);
        btnBook = findViewById(R.id.btnBooking);
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees:" + fees + "/-");
        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctorActivity.class));
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
        private void initDatePicker(){
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    i1 = i1 + 1;
                    dateButton.setText(i2+"/"+i1+"/"+i);
                }
            };
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int style = AlertDialog.BUTTON_NEGATIVE;
            datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);

        }

        private void initTimePicker(){
            TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                    //timeButton=setText(i+":"+i1);
                }
            };
            Calendar cal = Calendar.getInstance();
            int hrs= cal.get(Calendar.HOUR);
            int mins = cal.get(Calendar.MINUTE);
            int style = AlertDialog.BUTTON_NEGATIVE;
            timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
        }
    }
