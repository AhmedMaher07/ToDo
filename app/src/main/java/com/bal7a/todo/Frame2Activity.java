package com.bal7a.todo;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import com.bal7a.todo.SQLite.Contract.ItemEntry;
import com.bal7a.todo.SQLite.DBHelper;

/**
 * Created by Bal7a on 3/22/2017.
 */

public class Frame2Activity extends AppCompatActivity implements View.OnClickListener {
    Button Add;
    EditText editText;
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static ArrayList<String>arrayListDate = new ArrayList<>();
    private Calendar c;
    private String strDate;
    private SimpleDateFormat sdf;
    private DBHelper db;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame2);
        db = new DBHelper(getApplicationContext());
        Add = (Button) findViewById(R.id.add_btn);
        Add.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.edt_text);
        c = Calendar.getInstance();
        sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:a");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
//                arrayList.add(editText.getText().toString().trim());
                strDate = sdf.format(c.getTime());
//                arrayListDate.add(strDate);
                data = editText.getText().toString().trim();
                if (!data.isEmpty()) {
                    Model todo = new Model(data, strDate);
                    Log.d("DATA", data);
                    db.createToDo(todo);
                    db.closeDB();
                    editText.setText(" ");
                    Toast.makeText(this, "Item Added ;D", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
