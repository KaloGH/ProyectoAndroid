package com.kaemki.gamer4free.FirebaseActions;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class FirebaseActions {

    private ArrayList<String> errors = new ArrayList<>(); // Lista de errores

    FirebaseAuth mAuth = FirebaseAuth.getInstance(); // Instanciamos Firebase

    private FirebaseUser user; // Usuario

// TODO: Hacer registro y probar funcionamiento
    private FirebaseUser firebaseLogin(String email, String password) throws Exception {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            errors.add(task.getException().getMessage());
                        }
                    }
                });

        if (errors.size() == 0) { // Si no hay errores devolvemos usuario
            return user;
        } else { // En caso de errores que salte error con mensaje de los errores.
            throw new Exception(errors.toString());
        }
    }
}
