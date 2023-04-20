package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UserProfileActivity extends AppCompatActivity {

    private TextView textViewWelcome, textViewName, textViewEmail,textViewRegisterDate;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        getSupportActionBar().setTitle("Home");

        auth = FirebaseAuth.getInstance();

        findViews();
        signout();

        //Show profile details if User is not null
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser != null){
            progressBar.setVisibility(View.VISIBLE);
            showUserProfile(firebaseUser);
        }else {
            Toast.makeText(UserProfileActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        // To obtain metadata of the user object
        FirebaseUserMetadata metadata = firebaseUser.getMetadata();

        //Ger the register date of the user
        long registerTimeStamp = metadata.getCreationTimestamp();

        //Define a pattern for the date
        String datePattern = "E, dd MMMM yyyy hh:mm a z";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        sdf.setTimeZone(TimeZone.getDefault());
        String register = sdf.format(new Date(registerTimeStamp));

        String registerDate = getResources().getString(R.string.user_since, register);
        textViewRegisterDate.setText(registerDate);

        String name = firebaseUser.getDisplayName();
        String email = firebaseUser.getEmail();
        textViewName.setText(name);
        textViewEmail.setText(email);

        String welcome = getResources().getString(R.string.welcome_user, name);
        textViewWelcome.setText(welcome);
        progressBar.setVisibility(View.GONE);
    }

    private void signout() {
        Button buttonSignOut = findViewById(R.id.button_signout);
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(UserProfileActivity.this, "Signed Out", Toast.LENGTH_SHORT).show();

                Intent mainActivity = new Intent(UserProfileActivity.this, MainActivity.class);
                // Clear srack to prevent using back button
                mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainActivity);
                finish();
            }
        });
    }

    private void findViews() {
        textViewWelcome = findViewById(R.id.textView_show_welcome);
        textViewName = findViewById(R.id.textView_show_name);
        textViewEmail = findViewById(R.id.textView_show_email);
        textViewRegisterDate = findViewById(R.id.textView_show_register_date);
        progressBar = findViewById(R.id.progressBar);
    }
}