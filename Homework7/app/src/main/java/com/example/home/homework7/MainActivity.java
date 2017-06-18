package com.example.home.homework7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double num1,num2,num3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Addbtn = (Button)findViewById(R.id.Addbtn);
        Button Subbtn = (Button)findViewById(R.id.Subbtn);
        Button Mulbtn = (Button)findViewById(R.id.Mulbtn);
        Button Divbtn = (Button)findViewById(R.id.Divbtn);
        Button Rembtn = (Button)findViewById(R.id.Rembtn);
        Button Clear = (Button)findViewById(R.id.Clear);
        final EditText text1 = (EditText) findViewById(R.id.editText1);
        final EditText text2 = (EditText) findViewById(R.id.editText2);
        final TextView Result = (TextView)findViewById(R.id.Result);

        View.OnClickListener calc = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(text1.getText().toString().length() == 0 && text2.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else {
                    num1 = Double.parseDouble(text1.getText().toString());
                    num2 = Double.parseDouble(text2.getText().toString());
                    switch (v.getId()) {
                        case R.id.Addbtn:
                            num3 = num1 + num2;
                            break;

                        case R.id.Subbtn:
                            num3 = num1 - num2;
                            break;

                        case R.id.Mulbtn:
                            num3 = num1 * num2;
                            break;

                        case R.id.Divbtn:
                            num3 = num1 / num2;
                            break;

                        case R.id.Rembtn:
                            num3 = num1 % num2;
                            break;

                    }
                    if (num2 == 0) {
                        Toast.makeText(getApplicationContext(), "나누는 값이 0입니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Result.setText(String.valueOf(num3));
                    }
                }
            }
        };

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("0");
                text2.setText("0");
                Result.setText("0.0");
            }
        });

        Addbtn.setOnClickListener(calc);
        Subbtn.setOnClickListener(calc);
        Mulbtn.setOnClickListener(calc);
        Divbtn.setOnClickListener(calc);
        Rembtn.setOnClickListener(calc);
    }

}
