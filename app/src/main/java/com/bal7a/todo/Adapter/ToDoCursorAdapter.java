package com.bal7a.todo.Adapter;


import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bal7a.todo.Frame3Activity;
import com.bal7a.todo.Frame4Activity;
import com.bal7a.todo.R;
import com.bal7a.todo.SQLite.Contract;
import com.bal7a.todo.SQLite.DBHelper;

public class ToDoCursorAdapter extends CursorAdapter  {
    private DBHelper handler;

    public ToDoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        // Find fields to populate in inflated template
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.click);
        TextView note = (TextView) view.findViewById(R.id.item_list);
        final TextView date = (TextView) view.findViewById(R.id.item_date);
        Button delete = (Button) view.findViewById(R.id.delete);
        // Extract properties from cursor
        String body = cursor.getString(cursor.getColumnIndexOrThrow(Contract.ItemEntry.COLUMN_NAME));
        String time = cursor.getString(cursor.getColumnIndexOrThrow(Contract.ItemEntry.COLUMN_DESCRIPTION));
        // Populate fields with extracted properties
        note.setText(body);
        date.setText(time);
        final int position = cursor.getPosition();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor.moveToPosition(position);
                String note = cursor.getString(cursor.getColumnIndexOrThrow(Contract.ItemEntry.COLUMN_NAME));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(Contract.ItemEntry.COLUMN_DESCRIPTION));

                Intent intent = new Intent(context, Frame4Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString ("item", note);
                bundle.putString ("date", date);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor.moveToPosition(position);
                handler = new DBHelper(context);
                handler.deleteToDo(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.ItemEntry._ID)));
                SQLiteDatabase db = handler.getWritableDatabase();
                Cursor todoCursor = db.rawQuery("SELECT  * FROM " +Contract.ItemEntry.TABLE_NAME , null);
                swapCursor(todoCursor);
                notifyDataSetChanged();
                handler.closeDB();

            }
        });

    }
}