package com.aslanbolurov.fibonacci.appolympussportclub.data;

import static android.provider.BaseColumns._ID;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.DATABASE_NAME;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.DATABASE_VERSION;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry.COLUMN_GENDER;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry.COLUMN_SPORT;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry.TABLE_NAME;
import static com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry._id;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OlympusDbOpenHelper extends SQLiteOpenHelper {
    public OlympusDbOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_MEMBERS_TABLE="CREATE TABLE "+TABLE_NAME + "("
                +_ID+" INTEGER PRIMARY KEY,"
                +COLUMN_FIRST_NAME+" TEXT,"
                +COLUMN_LAST_NAME+" TEXT,"
                +COLUMN_GENDER+" INTEGER NOT NULL,"
                +COLUMN_SPORT+" TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_MEMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
