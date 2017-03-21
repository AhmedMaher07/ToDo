package com.bal7a.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bal7a on 3/22/2017.
 */

public class Frame4Activity extends AppCompatActivity {
    TextView textView;
    String item,passData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame4);

        textView = (TextView) findViewById(R.id.show_textview);
        item = getIntent().getStringExtra("item");
        passData = getIntent().getStringExtra("date");
        textView.setText(item + "\t " +passData);
        Toast.makeText(this, item + "\t \t \t \t " +passData, Toast.LENGTH_SHORT).show();

    }
    }
