package com.kaemki.gamer4free.ui.games;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kaemki.gamer4free.GamesAPI.GamesAPI;
import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.R;
import com.kaemki.gamer4free.ui.login.LoginActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesFragment extends Fragment implements GamesAdapter.OnGamesListener {


    private ArrayList<Games> listGames = new ArrayList<>();
    private GamesAdapter gamesAdpt = new GamesAdapter();
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        if (user != null) {
            gamesAdpt.setmContext(getActivity().getBaseContext());

            GamesAPI.getGamesInstance().listGames().enqueue(new Callback<ArrayList<Games>>() {
                @Override
                public void onResponse(Call<ArrayList<Games>> call, Response<ArrayList<Games>> response) {
                    ArrayList<Games> result = response.body();
                    setAdapterToGames(result);
                }

                @Override
                public void onFailure(Call<ArrayList<Games>> call, Throwable t) {

                }
            });
            return rootView;
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gamesAdpt.setOnGamesListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.rview_games);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onGamesClick(int pos) {
        /*Intent intent = new Intent(this.getActivity(), GameActivity.class);
        intent.putExtra("games", listGames.get(pos));
        strtActivity(intent);

         */
        Log.d("GameID -> ",String.valueOf(listGames.get(pos).getId()));
    }

    public void setAdapterToGames(ArrayList<Games> gamesList){
        this.listGames = gamesList;
        gamesAdpt.setListGames(gamesList);
        recyclerView.setAdapter(gamesAdpt);

    }
}