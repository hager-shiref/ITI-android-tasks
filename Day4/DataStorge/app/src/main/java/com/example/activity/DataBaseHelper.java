package com.example.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper {
    private Helper helper;
    private Context context;

    public DataBaseHelper(Context context) {
        this.context = context;
        helper = new Helper(context);
    }

    public long insertData(User user){
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Helper.PHONE,user.getPhone());
        values.put(Helper.MESSAGE,user.getMessage());
        long id =database.insert(Helper.DATABASE_TABLE,null,values);
        return id;
    }

    public  User[] getAllUser(){
        User[]users = null;
        SQLiteDatabase database = helper.getReadableDatabase();
        int i = 0;
        Cursor cursor;
        String [] columns = {Helper.ID,Helper.PHONE,Helper.MESSAGE};
        cursor=database.query(Helper.DATABASE_TABLE,columns,null,null,null,null,null);
        users = new User[cursor.getCount()];
        while (cursor.moveToNext()){
            users[i]=new User(cursor.getString(1),cursor.getString(2));
            i++;
        }
        return users;
    }

    private static class Helper extends SQLiteOpenHelper {
        public static final String DATA_BASE_NAME = "dp";
        public static final int VERSION = 1;
        public static final String DATABASE_TABLE = "TABLE_NAME";

        public static final String ID = "_id";
        public static final String MESSAGE = "message";
        public static final String PHONE = "phone";
        public static final String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE +
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PHONE+" VARCHAR(225),"+MESSAGE+ " VARCHAR(225));";

        public Helper(@Nullable Context context) {
            super(context,DATA_BASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
