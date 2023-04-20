package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home_activity extends AppCompatActivity {

    private TextView textViewWelcome, textViewName, textViewEmail,textViewRegisterDate;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
    }
    private void signout() {
        Button buttonSignOut = findViewById(R.id.button_signout);
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(Home_activity.this, "Signed Out", Toast.LENGTH_SHORT).show();

                Intent mainActivity = new Intent(Home_activity.this, MainActivity.class);
                // Clear srack to prevent using back button
                mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainActivity);
                finish();
            }
        });
    }
}