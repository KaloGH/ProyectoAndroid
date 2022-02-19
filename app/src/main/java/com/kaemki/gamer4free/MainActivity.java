package com.kaemki.gamer4free;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.kaemki.gamer4free.databinding.ActivityMainBinding;
import com.kaemki.gamer4free.ui.login.LoginActivity;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseUserMetadata userMetadata;
    private Snackbar welcomeSnackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userMetadata = user.getMetadata();

        if (user != null){
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            if (snackbarGOD()) {
                welcomeSnackbar = Snackbar.make(binding.getRoot(), "Welcome " + user.getDisplayName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null);
                welcomeSnackbar.show();
            }
            setSupportActionBar(binding.appBarMain.toolbar);

            DrawerLayout drawer = binding.drawerLayout;
            NavigationView navigationView = binding.navView;
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_games, R.id.nav_giveaways,R.id.nav_fav_games,R.id.settings)
                    .setOpenableLayout(drawer)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);


            ActionBar actionBar;
            actionBar = getSupportActionBar();

            // Define ColorDrawable object and parse color
            // using parseColor method
            // with color hash code as its parameter
            ColorDrawable colorDrawable
                    = new ColorDrawable(getResources().getColor(R.color.main_navbar_color));

            // Set BackgroundDrawable
            actionBar.setBackgroundDrawable(colorDrawable);


            // Modify Logged User Data
            NavigationView navHeader = (NavigationView) this.findViewById(R.id.nav_view);
            View viewHeader = navHeader.getHeaderView(0);
            TextView txt_username = viewHeader.findViewById(R.id.username);
            TextView txt_email = viewHeader.findViewById(R.id.email);
            txt_username.setText(user.getDisplayName());
            txt_email.setText(user.getEmail());

        } else {
           Intent intent = new Intent(this, LoginActivity.class);
           startActivity(intent);


        }
    }

    private boolean snackbarGOD() {


            long lastLogInTime = userMetadata.getLastSignInTimestamp();
            long now = System.currentTimeMillis();

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
            = now - lastLogInTime;

            // Calucalte time difference in seconds
            long difference_In_Seconds
            = (difference_In_Time
            / 1000)
            % 60;

            if (difference_In_Seconds < 30) {
                return true;
            } else {
                return false;
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        // LogOut Setting
        menu.findItem(R.id.action_logout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                mAuth.signOut();
                startActivity(intent);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}