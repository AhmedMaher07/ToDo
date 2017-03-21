package com.bal7a.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button frame2Caller,frame3Caller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame2Caller = (Button) findViewById(R.id.frame2_btn);
        frame3Caller = (Button) findViewById(R.id.frame3_btn);
        frame2Caller.setOnClickListener(this);
        frame3Caller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame2_btn:
                startActivity(new Intent(MainActivity.this,Frame2Activity.class));
                break;
            case R.id.frame3_btn:
                startActivity(new Intent(MainActivity.this,Frame3Activity.class));
        }
    }
}
