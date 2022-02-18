package com.kaemki.gamer4free.GamesAPI;

import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.GamesAPI.model.Giveaways;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGiveawaysEndPoints {

    @GET("giveaways")
    public Call<ArrayList<Giveaways>> listGiveaways();


    @GET("giveaway{id}")
    public Call<Void> listGiveawayInfoFromID(@Query("id") int id);
}
