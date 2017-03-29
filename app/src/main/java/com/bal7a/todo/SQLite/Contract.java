package com.bal7a.todo.SQLite;

/**
 * Created by root on 4/20/16.
 */
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {

    public static final String CONTENT_AUTHORITY = "com.bal7a.ToDo";
    public static final Uri BASE_CONTENT = Uri.parse("content://"+ CONTENT_AUTHORITY);
    public static final String PATH_ITEMS = "items";



    public static final class ItemEntry implements BaseColumns {
        public static Uri CONTENT_URI = BASE_CONTENT.buildUpon().appendPath(PATH_ITEMS).build();
        public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ITEMS;
        public static String TABLE_NAME = "items";
        public static String COLUMN_NAME = "name";
        public static String COLUMN_DESCRIPTION = "description";

        public static Uri BuildItemUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static Uri BuildItemShopwUri(String shop){
            return CONTENT_URI.buildUpon().appendPath(shop).build();
        }

    }
}
