package com.kaemki.gamer4free.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


import com.kaemki.gamer4free.GamesAPI.model.Games;

import java.util.ArrayList;

public class DbGames extends DbHelper {

    Context context;

    public DbGames(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public long insertFavGames(String title,String imgGame,String platform,String genre,int idGame){

        long id = 0;
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {


            ContentValues values = new ContentValues();
            values.put("id",idGame);
            values.put("title", title);
            values.put("img", imgGame);
            values.put("platform", platform);
            values.put("genre", genre);

            id = db.insert(TABLE_GAMES, null, values);
        }catch (Exception ex) {
            ex.toString();
        }
        db.close();
        return id;
    }

    public ArrayList<Games> listAllFavGames() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Games> favGamesList = new ArrayList<>();
        Games game;
        Cursor cursorGames;

        cursorGames = db.rawQuery("SELECT * FROM " + TABLE_GAMES + " ORDER BY id ASC", null);

        if (cursorGames.moveToFirst()) {
            do {
                game = new Games();
                game.setId(cursorGames.getInt(0));
                game.setTitle(cursorGames.getString(1));
                game.setThumbnail(cursorGames.getString(2));
                game.setPlatform(cursorGames.getString(3));
                game.setGenre(cursorGames.getString(4));
                favGamesList.add(game);
            } while (cursorGames.moveToNext());
        }

        cursorGames.close();

        return favGamesList;
    }

    public boolean deleteFavGames(int idGame){

        boolean deleted = false;
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM "+TABLE_GAMES + " WHERE id = '"+idGame+"' LIMIT 1");
            deleted=true;
        }catch (Exception ex) {
            ex.toString();
            deleted = false;
        }
        return deleted;
    }



}
