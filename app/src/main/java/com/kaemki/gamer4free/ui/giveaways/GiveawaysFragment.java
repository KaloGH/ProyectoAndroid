package com.kaemki.gamer4free.ui.giveaways;

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
import com.kaemki.gamer4free.GamesAPI.model.Giveaways;
import com.kaemki.gamer4free.R;
import com.kaemki.gamer4free.ui.login.LoginActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GiveawaysFragment extends Fragment implements GiveawaysAdapter.OnGiveawaysListener {


    private ArrayList<Giveaways> listGiveaways = new ArrayList<>();
    private GiveawaysAdapter giveawaysAdapter = new GiveawaysAdapter();
    private RecyclerView recyclerView;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_games,container,false);

        if (user != null ) {
            GamesAPI.getGiveawaysInstance().listGiveaways().enqueue(new Callback<ArrayList<Giveaways>>() {
                @Override
                public void onResponse(Call<ArrayList<Giveaways>> call, Response<ArrayList<Giveaways>> response) {
                    ArrayList<Giveaways> result = response.body();
                    setAdapterToGiveaways(result);
                }

                @Override
                public void onFailure(Call<ArrayList<Giveaways>> call, Throwable t) {

                }
            });
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        giveawaysAdapter.setOnGiveawaysListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.rview_games);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onGiveawaysClick(int pos) {
        /*Intent intent = new Intent(this.getActivity(), GameActivity.class);
        intent.putExtra("games", listGames.get(pos));
        strtActivity(intent);

         */
        Log.d("Giveaway ID -> ",String.valueOf(listGiveaways.get(pos).getId()));
    }

    public void setAdapterToGiveaways(ArrayList<Giveaways> listGiveaways){
        this.listGiveaways = listGiveaways;
        giveawaysAdapter.setListGiveaways(listGiveaways);
        recyclerView.setAdapter(giveawaysAdapter);

    }
}