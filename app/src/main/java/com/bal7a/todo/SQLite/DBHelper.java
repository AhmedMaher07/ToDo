package com.bal7a.todo.SQLite;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bal7a.todo.Model;
import com.bal7a.todo.SQLite.Contract.ItemEntry;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance;

    final static String DATABASE_NAME = "todo.db";

    private static int DATABASE_VERSION = 1;

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context);
        }

        return instance;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_ITEM_TABLE = "CREATE TABLE " + ItemEntry.TABLE_NAME + " (" +

                ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ItemEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ItemEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL" +
                 ")";

        db.execSQL(SQL_CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ItemEntry.TABLE_NAME);
        onCreate(db);
    }

    public long createToDo(Model todo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemEntry.COLUMN_NAME, todo.getNote());
        values.put(ItemEntry.COLUMN_DESCRIPTION, todo.getCreated_at());
        // insert row

        // assigning tags to todo

        return db.insert(ItemEntry.TABLE_NAME, null, values);
    }

    public List<Model> getAllToDos() {
        List<Model> todos = new ArrayList<Model>();
        String selectQuery = "SELECT  * FROM " + ItemEntry.TABLE_NAME;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Model td = new Model();
                td.setId(c.getInt((c.getColumnIndex(ItemEntry._ID))));
                td.setNote((c.getString(c.getColumnIndex(ItemEntry.COLUMN_NAME))));
                td.setCreated_at(c.getString(c.getColumnIndex(ItemEntry.COLUMN_DESCRIPTION)));

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }

    public void deleteToDo(long tado_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ItemEntry.TABLE_NAME, ItemEntry._ID + " = ?",
                new String[] { String.valueOf(tado_id) });
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}