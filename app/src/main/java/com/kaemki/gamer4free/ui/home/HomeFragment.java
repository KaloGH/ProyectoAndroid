package com.kaemki.gamer4free.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.kaemki.gamer4free.R;
import com.kaemki.gamer4free.databinding.FragmentHomeBinding;
import com.kaemki.gamer4free.ui.games.GamesFragment;
import com.kaemki.gamer4free.ui.login.LoginActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private FirebaseAuth mAuth;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mAuth = FirebaseAuth.getInstance();
        Intent intent = new Intent(getActivity(), LoginActivity.class);



        Button btn_games = (Button) root.findViewById(R.id.btn_games);
        Button btn_giveaways = (Button) root.findViewById(R.id.btn_giveaways);
        Button btn_favGames = (Button) root.findViewById(R.id.btn_favgames);

        btn_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.nav_games);
            }
        });

        btn_giveaways.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_giveaways);
            }
        });

        btn_favGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_fav_games);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}