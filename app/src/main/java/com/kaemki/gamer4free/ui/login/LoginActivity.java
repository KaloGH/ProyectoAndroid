package com.kaemki.gamer4free.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.kaemki.gamer4free.MainActivity;
import com.kaemki.gamer4free.R;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String username;
    private String email;
    private String password;
    boolean isRegister;
    // Creamos el intent que redirigira
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Damos contexto al intent
        intent = new Intent(this, MainActivity.class);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Comprobar si desea Loggear o Registrar
        isRegister = false;

        ///////////////////// Establecer Video de inicio de app ///////////////////////
        final VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.gamer_free_video);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoview.start();
                mp.setLooping(true);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////

        //////////////////// DEFINIMOS OBJETOS DE LA VISTA /////////////////////////////
        CircularProgressIndicator loader = (CircularProgressIndicator) findViewById(R.id.loader);

        // Layouts , para mostrar errores
        TextInputLayout email_layout = (TextInputLayout) findViewById(R.id.textLayout_email);
        TextInputLayout password_layout = (TextInputLayout) findViewById(R.id.textLayout_password);
        TextInputLayout username_layout = (TextInputLayout) findViewById(R.id.textLayout_username);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(R.id.switch_login);

        // Edit Texts para recoger informacion.
        TextInputEditText email_text = (TextInputEditText) findViewById(R.id.textField_email);
        TextInputEditText password_text = (TextInputEditText) findViewById(R.id.textField_password);
        TextInputEditText username_text = (TextInputEditText) findViewById(R.id.textField_username);

        // Eliminar cuando la app este echa
        email_text.setText("efren@efren.efren");
        password_text.setText("123456");

        ////////////////////////////////////////////////////////////////////////////////


        // Comprobamos si se va a registrar o loggear
        switchMaterial.setOnCheckedChangeListener((buttonView,isChecked) -> {
            Resources r = getResources();
            // Si NO esta checkeado está en Login , Si no modificar estilo y añadir campo de usuario
            if (!isChecked) {
                // Asignamos dimensiones del video para redimensionar y lo redimensionamos
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
                params.gravity = Gravity.CENTER;
                videoview.setLayoutParams(params);
                username_layout.setVisibility(View.GONE);
                isRegister = false;

            } else {
                // Asignamos dimensiones del video para redimensionar y lo redimensionamos
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
                params.gravity = Gravity.CENTER;
                videoview.setLayoutParams(params);
                username_layout.setVisibility(View.VISIBLE);
                isRegister = true;
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Asignamos el valor a variables para manejar los listeners
                email = email_text.getText().toString().trim();
                password = password_text.getText().toString().trim();
                username = username_text.getText().toString().trim();

                loader.setVisibility(View.VISIBLE); // Iniciamos Loader

                if (isRegister){


                    if (!TextUtils.isEmpty(email_text.getText()) && !TextUtils.isEmpty(password_text.getText()) && !TextUtils.isEmpty(username_text.getText())) {
                        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(email,password);
                        task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username)
                                        .build();
                                user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() { // Actualizamos nombre de usuario del registrado
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            intent.putExtra("user", user);
                                            startActivity(intent);
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        showErrorInEmptyTexts(email,password,username);
                    }

                } else {

                    if (!TextUtils.isEmpty(email_text.getText()) && !TextUtils.isEmpty(password_text.getText())) {

                        Task<AuthResult> task = mAuth.signInWithEmailAndPassword(email,password);
                        task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    intent.putExtra("user",user);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.

                                }
                            }
                        });
                    } else {
                        showErrorInEmptyTexts(email,password,"0");
                    }
                }

            }

            private void showErrorInEmptyTexts(String email, String password, String username) {
                if (email == null || TextUtils.isEmpty(email)){
                    email_layout.setError("Please write your e-mail.");
                }
                if (password == null || TextUtils.isEmpty(password)){
                    password_layout.setError("Please write your password.");
                }
                if (!username.equals("0") && (username == null || TextUtils.isEmpty(username))){
                    username_layout.setError("Please write your username.");
                }
            }

        });


    }
    private void firebaseLogin(String email, String password) {

    }

    private void firebaseRegister(String email, String password,String username) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username)
                                    .build();
                            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() { // Actualizamos nombre de usuario del registrado
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        intent.putExtra("user",user);
                                        startActivity(intent);
                                    }
                                }
                            });

                        } else {
                            // If sign in fails, display a message to the user.
                        }
                    }
                });
    }

}