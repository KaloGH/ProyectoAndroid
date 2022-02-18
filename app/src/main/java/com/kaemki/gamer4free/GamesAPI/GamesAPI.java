package com.kaemki.gamer4free.GamesAPI;

import android.util.Log;

import com.kaemki.gamer4free.GamesAPI.model.Games;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamesAPI {

    private static Retrofit retrofitGames = new Retrofit.Builder()
            .baseUrl(" https://www.freetogame.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Retrofit retrofitGiveaways = new Retrofit.Builder()
            .baseUrl("  https://www.gamerpower.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static IGamesEndPoints serviceGames = retrofitGames.create(IGamesEndPoints.class);
    private static IGiveawaysEndPoints serviceGiveaways = retrofitGiveaways.create(IGiveawaysEndPoints.class);


    public static IGamesEndPoints getGamesInstance(){

            if (serviceGames == null )
                serviceGames = retrofitGames.create(IGamesEndPoints.class);
            return serviceGames;

    }
    public static IGiveawaysEndPoints getGiveawaysInstance() {
        if (serviceGiveaways == null )
            serviceGiveaways = retrofitGiveaways.create(IGiveawaysEndPoints.class);
        return serviceGiveaways;
    }

}
