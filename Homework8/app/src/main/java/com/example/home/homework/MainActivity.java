package com.example.home.homework;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button B1,B2;
    Chronometer Cro;
    RadioButton R1,R2;
    RadioGroup RG;
    CalendarView CV;
    TimePicker TP;
    TextView T1;
    String save1 = "";
    String save2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = (Button) findViewById(R.id.btnStart);
        B2 = (Button) findViewById(R.id.btnFinish);
        Cro = (Chronometer) findViewById(R.id.chronometer);
        R1 = (RadioButton) findViewById(R.id.radioButton1);
        R2 = (RadioButton) findViewById(R.id.radioButton2);
        RG = (RadioGroup) findViewById(R.id.radioGroup);
        CV = (CalendarView) findViewById(R.id.calendarView);
        TP = (TimePicker) findViewById(R.id.timePicker);
        T1 = (TextView) findViewById(R.id.textFinish);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cro.setFormat("예약에 걸린 시간 - %s");
                Cro.setTextColor(Color.RED);
                Cro.setBase(SystemClock.elapsedRealtime());
                Cro.start();
                B2.setEnabled(true);
            }
        });

        CV.setVisibility(View.GONE);
        TP.setVisibility(View.GONE);
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R1.isChecked()){
                    TP.setVisibility(View.GONE);
                    CV.setVisibility(View.VISIBLE);
                }else{
                    CV.setVisibility(View.GONE);
                    TP.setVisibility(View.VISIBLE);
                }
            }
        });

        CV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                save1 = year+"년"+month+"월"+dayOfMonth+"일";
            }
        });

        TP.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(save2.equals("")) {
                    save2 = hourOfDay + "시" + minute + "분에 예약됨";
                }else{
                    save2 = hourOfDay + "시" + minute + "분에 예약됨";
                }
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(save1.equals("") || save2.equals("")){
                    Toast.makeText(getApplicationContext(), "날짜/시간을 선택해주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    T1.setText(save1 + save2);
                    Cro.setTextColor(Color.BLUE);
                    Cro.stop();
                }
            }
        });
    }
}
