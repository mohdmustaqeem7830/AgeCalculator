package com.example.agecalculatorr;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.time.Period;

public class MainActivity extends AppCompatActivity {
     EditText edtday, edtmonth,edtyear ;
     Button btncalc,btnrefresh;
     TextView txt ;
     Date d ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncalc =findViewById(R.id.btncalc);
        txt = findViewById(R.id.txt);
        edtday = findViewById(R.id.edtday);
        edtmonth = findViewById(R.id.edtmonth);
        edtyear = findViewById(R.id.edtyear);
        btnrefresh= findViewById(R.id.btnref);

        //fixed the orientaiton
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



//        edtdate = findViewById(R.id.edtdate);
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    LocalDate dcurrent = LocalDate.now();
                    int day = Integer.parseInt(edtday.getText().toString());
                    int month = Integer.parseInt(edtmonth.getText().toString());
                    int year = Integer.parseInt(edtyear.getText().toString());
                    LocalDate dob = LocalDate.of(year,month,day);
                    Period period = Period.between(dob,dcurrent);
                    int tmonth = (period.getYears()*12 )+ (period.getMonths());
                    int leapyear = period.getYears()/4;
                   int tdays = (int)(tmonth*(30.436806));
                   int thours = tdays*24;
                   int tminute = thours*60;
                   int tsecond = tminute*60;
                   int tweeks = tdays/7 ;

                   int lowest =0;
                   if(dob.getYear()<dcurrent.getYear() && dob.getYear()>0) {


                       txt.setText(period.getYears() + " year " + period.getMonths() + " month " + period.getDays() + " Days" +
                               " \n" + tmonth + " month " + period.getDays() + " days \n" + tweeks + "weeks " + tdays % 7 + " days \n"
                               + tdays + " days \n" + thours + " hours \n " + tminute + " minutes \n " + tsecond + " seconds"
                       );
                   }
                   else{
                       Toast.makeText(MainActivity.this, "Enter the valid DOB", Toast.LENGTH_SHORT).show();
                   }

                    btnrefresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt.setText("Result");
                            edtday.setText("");
                            edtmonth.setText("");
                            edtyear.setText("");
                        }
                    });

                }


            }
        });

        }


}
