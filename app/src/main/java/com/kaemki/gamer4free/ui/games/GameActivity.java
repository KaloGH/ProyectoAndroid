/*package com.kaemki.gamer4free.ui.games;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaemki.gamer4free.GamesAPI.model.Games;
import com.kaemki.gamer4free.R;
import com.squareup.picasso.Picasso;

public class GameActivity extends AppCompatActivity {

    private RecyclerView rvGames;

    private ImageView imagen;

    private TextView gameName;

    private Games games;

    private GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rvGames = findViewById(R.id.rview_games);
        games = (Games) getIntent().getSerializableExtra("games");

        imagen = (ImageView) findViewById(R.id.imgv_gameImg);
        String gameName = String.valueOf(games.getTitle());
        Picasso.get().load(games.getThumbnail()).into(imagen);


        iniciaRecyclerView();

    }

    public void iniciaRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGames.setLayoutManager(linearLayoutManager);
        habilidadesAdapter = new HabilidadesAdapter(listaHabilidades);
        habilidadReciclerView.setAdapter(habilidadesAdapter);

    }
}*/