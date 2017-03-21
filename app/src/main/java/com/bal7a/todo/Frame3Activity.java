package com.bal7a.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.bal7a.todo.Adapter.MyCustomAdapter;

import static com.bal7a.todo.Frame2Activity.arrayList;
import static com.bal7a.todo.Frame2Activity.arrayListDate;

/**
 * Created by Bal7a on 3/22/2017.
 */

public class Frame3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame3);

        MyCustomAdapter adapter =
                new MyCustomAdapter(this, R.layout.item_listview, arrayList,arrayListDate);


        ListView lv = (ListView) findViewById(R.id.list_view);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Frame3Activity.this,Frame4Activity.class).putExtra("item",arrayList.get(position)).putExtra("date",arrayListDate.get(position)));

            }
        });

    }
}
