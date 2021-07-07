package com.android.bankpal.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.android.bankpal.Database.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(123456,'Bheem', 'bheem@gmail.com','UCB50000','9632587412', 150000)");
        db.execSQL("insert into " + TABLE_NAME + " values(567878,'Tom', 'tom@gmail.com','UCB40000','1478965231', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(910110,'Jerry', 'jerry@gmail.com','UCB30000','8963254712', 31000)");
        db.execSQL("insert into " + TABLE_NAME + " values(121312,'Chutki', 'chutki@gmail.com','UCB20000','9687412563', 48000)");
        db.execSQL("insert into " + TABLE_NAME + " values(141513,'Jaggu', 'jaggu@gmail.com','UCB10000','7896541204', 57500)");
        db.execSQL("insert into " + TABLE_NAME + " values(161714,'Kalia', 'kalia@gmail.com','UCB10000','9876521304', 66500)");
        db.execSQL("insert into " + TABLE_NAME + " values(181915,'Dholu', 'dholu@gmail.com','UCB20000','9876523154', 74500)");
        db.execSQL("insert into " + TABLE_NAME + " values(202116,'Bholu', 'bholu@gmail.com','UCB30000','8976541254', 82500)");
        db.execSQL("insert into " + TABLE_NAME + " values(222317,'Tuntun', 'tuntun@gmail.com','UCB40000','63214658795', 910500)");
        db.execSQL("insert into " + TABLE_NAME + " values(242518,'Masi', 'masi@gmail.com','UCB50000','6354789541', 29900)");
        db.execSQL("insert into " + TABLE_NAME + " values(262719,'Indumati', 'indumati@gmail.com','UCB40000','6987652146', 39800)");
        db.execSQL("insert into " + TABLE_NAME + " values(282920,'Kichak', 'kichak@gmail.com','UCB30000','9875421504', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(303121,'Doraemon', 'doraemon@gmail.com','UCB45000','9687652143', 55800)");
        db.execSQL("insert into " + TABLE_NAME + " values(323322,'Nobita', 'nobita@gmail.com','UCB30000','9875632147', 63500)");
        db.execSQL("insert into " + TABLE_NAME + " values(343523,'Dora', 'dora@gmail.com','UCB650000','3245601254', 71010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData(int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }

}