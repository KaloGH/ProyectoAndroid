package com.kaemki.gamer4free.ui.fav_games;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kaemki.gamer4free.GamesAPI.GamesAPI;
import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.R;
import com.kaemki.gamer4free.db.DbGames;
import com.kaemki.gamer4free.ui.games.GamesAdapter;
import com.kaemki.gamer4free.ui.login.LoginActivity;

import java.util.ArrayList;



public class FavGamesFragment extends Fragment implements GamesAdapter.OnGamesListener {


    private ArrayList<Games> listGames = new ArrayList<>();
    private GamesAdapter gamesAdpt = new GamesAdapter();
    private RecyclerView recyclerView;
    private DbGames db;
    private boolean haveFavGames;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        db = new DbGames(getActivity().getBaseContext());
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        View rootView = inflater.inflate(R.layout.fragment_fav_games, container, false);

        if (user != null) {
            gamesAdpt.setmContext(getActivity().getBaseContext());

            TextView textView = rootView.findViewById(R.id.string_noFavGames);


            ArrayList<Games> favGames = db.listAllFavGames();
            if (favGames.size() > 0 ){
                gamesAdpt.setOnGamesListener(this);
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rview_games);
                recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
                recyclerView.setHasFixedSize(true);
                setAdapterToGames(favGames);
                textView.setVisibility(View.GONE);

            } else {
                textView.setText("You dont have Favourite Games yet.");
                textView.setVisibility(View.VISIBLE);
            }
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