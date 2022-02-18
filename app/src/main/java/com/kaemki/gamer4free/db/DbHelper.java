package com.kaemki.gamer4free.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "favgames.db";
    public static final String TABLE_GAMES = "t_games";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_GAMES + "(" +
                "id INTEGER ," +
                "title TEXT , " +
                "img TEXT , " +
                "platform TEXT , " +
                "genre TEXT , " +
                "CONSTRAINT games_pk PRIMARY KEY (id)"+
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_GAMES);
        onCreate(sqLiteDatabase);

    }

    public void dropDB(){
        getWritableDatabase().execSQL("DROP TABLE "+TABLE_GAMES);
    }
}
