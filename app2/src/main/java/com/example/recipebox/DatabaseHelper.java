package com.example.recipebox;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="contactsManager";
    private static final String TABLE_CONTACTS ="Contacts";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE="phone";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = " CREATE TABLE" + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +KEY_NAME + " TEXT,"+KEY_PHONE + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db , int i , int il){
           db.exexSQl("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);

           onCreate(db);
    }

    void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

    }


}
