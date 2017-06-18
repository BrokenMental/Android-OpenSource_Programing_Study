package com.example.jinuk.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button B1 = (Button)findViewById(R.id.button1);
        B1.setOnClickListener(new View.OnClickListener(){

            // 변수 혹은 객체를 onCreate 밖에다 선언하면 final 혹은 배열로 선언되야한다.
            CheckBox C1 = (CheckBox)findViewById(R.id.checkBox);
            RadioButton R1 = (RadioButton)findViewById(R.id.radioButton1);
            RadioButton R2 = (RadioButton)findViewById(R.id.radioButton2);
            EditText E1 = (EditText)findViewById(R.id.EditText10);
            EditText E2 = (EditText)findViewById(R.id.EditText11);
            EditText E3 = (EditText)findViewById(R.id.EditText12);
            TextView T1 = (TextView)findViewById(R.id.result1);
            TextView T2 = (TextView)findViewById(R.id.result2);
            TextView T3 = (TextView)findViewById(R.id.result3);
            ImageView IV = (ImageView)findViewById(R.id.imageView);

            int n1,n2,n3;
            double result1 = 0;
            double result2 = 0;
            int num1 = 16000;
            int num2 = 11000;
            int num3 = 4000;
            // 변수 혹은 객체를 onCreate 밖에다 선언하면 final 혹은 배열로 선언되야한다.
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

                if(C1.isChecked()){
                    result2 = result2 - (result2 * 0.07);
                }

                if(R1.isChecked()){
                    IV.setImageResource(R.drawable.pickle);
                    T1.setText(String.valueOf(result1));
                    T2.setText(String.valueOf(result2));
                    T3.setText("피클을 선택하셨습니다.");
                }else if(R2.isChecked()){
                    IV.setImageResource(R.drawable.sauce);
                    T1.setText(String.valueOf(result1));
                    T2.setText(String.valueOf(result2));
                    T3.setText("소스를 선택하셨습니다.");
                }else {
                    T1.setText(String.valueOf("0.0"));
                    T2.setText(String.valueOf("0.0"));
                    Toast.makeText(getApplicationContext(), "피클/소스를 선택해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    // 메뉴생성 메서드, 이게 없으면 메뉴가 나타나지 않는다.
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 100, 0, "사진고르기1");
        menu.add(0, 101, 0, "사진고르기2");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    // 페이지 이동 메서드, 각 페이지마다 있어야 한다.
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 100) { // 사진고르기1
            Intent intent = new Intent(
                    Main2Activity.this,
                    MainActivity.class);

            startActivity(intent);
            finish(); // 현재 떠있는 엑티비티 종료
        }
        return super.onOptionsItemSelected(item);
    }
}
