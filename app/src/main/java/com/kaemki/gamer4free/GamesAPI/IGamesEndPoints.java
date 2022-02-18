package com.kaemki.gamer4free.GamesAPI;

import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.GamesAPI.GamesAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGamesEndPoints {

    @GET("games")
    public Call<ArrayList<Games>> listGames();


    @GET("game{id}")
    public Call<Void> listGameInfoFromID(@Query("id") int id);
}
