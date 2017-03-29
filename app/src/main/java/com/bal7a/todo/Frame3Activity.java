package com.bal7a.todo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.bal7a.todo.Adapter.ToDoCursorAdapter;
import com.bal7a.todo.SQLite.Contract;
import com.bal7a.todo.SQLite.DBHelper;

import static com.bal7a.todo.Frame2Activity.arrayList;
import static com.bal7a.todo.Frame2Activity.arrayListDate;

/**
 * Created by Bal7a on 3/22/2017.
 */

public class Frame3Activity extends AppCompatActivity {


    private String note,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame3);

        // TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
        DBHelper handler = new DBHelper(this);
        // Get access to the underlying writeable database
        SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor todoCursor = db.rawQuery("SELECT  * FROM " +Contract.ItemEntry.TABLE_NAME , null);

        ListView lvItems = (ListView) findViewById(R.id.list_view);
        // Setup cursor adapter using cursor from last step
        final ToDoCursorAdapter todoAdapter = new ToDoCursorAdapter(this, todoCursor);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(todoAdapter);

        handler.closeDB();

    }
}
