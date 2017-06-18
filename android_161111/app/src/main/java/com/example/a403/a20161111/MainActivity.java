package com.example.a403.a20161111;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    TextView t1;
    CheckBox c1;
    LinearLayout L1;
    RatingBar R1;
    CalendarView Ca1;
    RadioGroup RG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 =(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"안녕",Toast.LENGTH_SHORT).show();
            }
        });

        b2 =(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"하진욱입니다!",Toast.LENGTH_SHORT).show();
            }
        });

        t1 = (TextView)findViewById((R.id.text1));
        t1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World",Toast.LENGTH_SHORT).show();
            }
        });

        c1 = (CheckBox)findViewById(R.id.checkBox);
        L1 = (LinearLayout)findViewById(R.id.activity_main);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.getId() == R.id.checkBox){
                    if(isChecked){
                        L1.setBackgroundColor(Color.BLUE);
                    }else{
                        L1.setBackgroundColor(Color.WHITE);
                    }
                }
            }
        });

        R1 = (RatingBar)findViewById(R.id.ratingBar);
        R1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();
            }
        });

        Ca1 = (CalendarView)findViewById(R.id.calendarView);
        Ca1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "Click : " + year +"-" + (month+1)+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        });

        RG = (RadioGroup)findViewById(R.id.radioGroup);
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton1:
                        Toast.makeText(MainActivity.this, "남성입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this, "여성입니다.",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
