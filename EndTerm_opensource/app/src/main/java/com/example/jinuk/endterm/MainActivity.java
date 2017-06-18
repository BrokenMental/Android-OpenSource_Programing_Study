package com.example.jinuk.endterm;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer Cro;
    Switch Swit;
    Button Go,Back,Bresult1, Bresult2;
    FrameLayout Fra;
    LinearLayout Lin1, Lin2;
    TimePicker Time;
    CalendarView Caln;
    RadioGroup RG,RGD;
    RadioButton R1,R2,RD1,RD2,RD3;
    EditText E1,E2,E3;
    TextView T1, T2, T3;
    ImageView IV;
    int n1 = 0, n2 = 0, n3 = 0;
    double result1 = 0.0, result2 = 0.0, Discount = 0.0;
    int num1 = 15000;
    int num2 = 12000;
    int num3 = 8000;
    String save1="", save2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fra = (FrameLayout)findViewById(R.id.Frame);
        Lin1 = (LinearLayout)findViewById(R.id.Linear1);
        Lin2 = (LinearLayout)findViewById(R.id.Linear2);
        Cro = (Chronometer)findViewById(R.id.chronometer1);
        Swit = (Switch)findViewById(R.id.switch1);
        Go = (Button)findViewById(R.id.Go);
        Back = (Button)findViewById(R.id.Back);
        Time = (TimePicker)findViewById(R.id.timeP);
        Caln = (CalendarView)findViewById(R.id.Caln) ;
        RG = (RadioGroup) findViewById(R.id.RG);
        RGD = (RadioGroup)findViewById(R.id.RGD);
        RD1 = (RadioButton)findViewById(R.id.radioB1);
        RD2 = (RadioButton)findViewById(R.id.radioB2);
        RD3 = (RadioButton)findViewById(R.id.radioB3);
        R1 = (RadioButton)findViewById(R.id.Rdate);
        R2 = (RadioButton)findViewById(R.id.Rtime);
        E1 = (EditText)findViewById(R.id.edit1);
        E2 = (EditText)findViewById(R.id.edit2);
        E3 = (EditText)findViewById(R.id.edit3);
        T1 = (TextView)findViewById(R.id.textResult1);
        T2 = (TextView)findViewById(R.id.textResult2);
        T3 = (TextView)findViewById(R.id.textResult3);
        Bresult1 = (Button)findViewById(R.id.buttonResult1);
        Bresult2 = (Button)findViewById(R.id.buttonResult2);
        IV = (ImageView)findViewById(R.id.imageView);

        Lin1.setVisibility(View.GONE);
        Swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Cro.setBase(SystemClock.elapsedRealtime());
                    Cro.start();
                    Fra.setVisibility(View.VISIBLE);
                }else{
                    Fra.setVisibility(View.INVISIBLE);
                    Cro.setBase(SystemClock.elapsedRealtime());
                    Cro.stop();
                }
            }
        });

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lin2.setVisibility(View.GONE);
                Lin1.setVisibility(View.VISIBLE);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lin1.setVisibility(View.GONE);
                Lin2.setVisibility(View.VISIBLE);
            }
        });

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R1.isChecked()){
                    Time.setVisibility(View.GONE);
                    Caln.setVisibility(View.VISIBLE);
                }else{
                    Time.setVisibility(View.VISIBLE);
                    Caln.setVisibility(View.GONE);
                }
            }
        });


        Bresult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(E1.getText().toString().length() == 0){
                    n1 = 0;
                }else{
                    n1 = Integer.parseInt(E1.getText().toString());
                }
                if(E2.getText().toString().length() == 0){
                    n2 = 0;
                }else{
                    n2 = Integer.parseInt(E2.getText().toString());
                }
                if(E3.getText().toString().length() == 0){
                    n3 = 0;
                }else{
                    n3 = Integer.parseInt(E3.getText().toString());
                }

                result1 = n1 + n2 + n3;
                result2 = (num1 * n1) + (num2 * n2) + (num3 * n3);

                if(RD1.isChecked()){
                    Discount = result2 * 0.05;
                    result2 = result2 - (result2 * 0.05);

                }else if (RD2.isChecked()){
                    Discount = result2 * 0.10;
                    result2 = result2 - (result2 * 0.10);
                }else{
                    Discount = result2 * 0.20;
                    result2 = result2 - (result2 * 0.20);
                }

                T1.setText(String.valueOf(result1));
                T2.setText(String.valueOf(Discount));
                T3.setText(String.valueOf(result2));
            }
        });

        RGD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(RD1.isChecked()){
                    IV.setImageResource(R.drawable.park1);
                }else if(RD2.isChecked()){
                    IV.setImageResource(R.drawable.cash);
                }else{
                    IV.setImageResource(R.drawable.card);
                }
            }
        });

        Caln.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                save1 = year + "년" + month + "월" + dayOfMonth + "일 ";
            }
        });

        Time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(save2.equals("")){
                    save2 = hourOfDay + "시" + minute + "분에 예약 되었습니다.";
                }else{
                    save2 = hourOfDay + "시" + minute + "분에 예약 되었습니다.";
                }
            }
        });

        Bresult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result2 != 0){
                    if(save1.equals("") || save2.equals("")){
                        Toast.makeText(getApplicationContext(), "날짜/시간을 선택해주세요.",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), save1+save2,Toast.LENGTH_SHORT).show();
                        Cro.setTextColor(Color.GRAY);
                        Cro.stop();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "인원예약을 먼저 해주세요.",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
