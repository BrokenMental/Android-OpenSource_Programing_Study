package com.example.jinuk.checkbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox C1 = (CheckBox) findViewById(R.id.checkBox1);
        final LinearLayout L1 = (LinearLayout) findViewById(R.id.Layout);
        final ImageView IV = (ImageView) findViewById(R.id.imageView);
        Button B1 = (Button) findViewById(R.id.button);
        // RadioGroup RG = (RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton R1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton R2 = (RadioButton) findViewById(R.id.radioButton2);
        // RadioButton R3 = (RadioButton)findViewById(R.id.radioButton3);

        L1.setVisibility(View.GONE);
        C1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getId() == R.id.checkBox1) {
                    if (isChecked) {
                        L1.setVisibility(View.VISIBLE);
                    } else {
                        L1.setVisibility(View.GONE);
                    }
                }
            }
        });

        /* 버튼선택없음
        IV.setVisibility(View.GONE);
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                IV.setVisibility(View.VISIBLE);
                switch(checkedId){
                    case R.id.radioButton1:
                        IV.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioButton2:
                        IV.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioButton3:
                        IV.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });
        */

        /*사진이 따로 안나옴
        IV.setVisibility(View.GONE);
        View.OnClickListener ImageV = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IV.setVisibility(View.VISIBLE);
                switch(v.getId()){
                    case R.id.radioButton1:
                        IV.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioButton2:
                        IV.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioButton3:
                        IV.setImageResource(R.drawable.rabbit);
                        break;
                }

            }
        };
        B1.setOnClickListener(ImageV);
        */

        IV.setVisibility(View.GONE);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IV.setVisibility(View.VISIBLE);
                if (R1.isChecked()) {
                    IV.setImageResource(R.drawable.dog);
                } else if (R2.isChecked()) {
                    IV.setImageResource(R.drawable.cat);
                } else {
                    IV.setImageResource(R.drawable.rabbit);
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 100, 0, "사진고르기1");
        menu.add(0, 101, 0, "사진고르기2");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 101) { // 사진고르기1
            Intent intent = new Intent(
                    MainActivity.this,
                    Main2Activity.class);

            startActivity(intent);
            finish(); // 현재 떠있는 엑티비티 종료
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
