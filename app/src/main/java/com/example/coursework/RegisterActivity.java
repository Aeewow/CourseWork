package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursework.Models.Database;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword,edConfirm;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edEmail = findViewById(R.id.editText_register_email);
        edPassword = findViewById(R.id.editText_register_pwd2);
        edUsername = findViewById(R.id.editText_register_name);
        edConfirm = findViewById(R.id.editText_confirm_password);
        btn = findViewById(R.id.button_register);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String username = edUsername.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                //Check if all the data are present before registering user

                if (username.length()==0||email.length()==0||password.length()==0||confirm.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm)==0){
                        if (isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String passwordHere){
        int f1 = 0,f2=0,f3=0;
        if (passwordHere.length()<8){
            return false;
        }else {
            for (int p = 0;p<passwordHere.length(); p++){
                if (Character.isLetter(passwordHere.charAt(p))){
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordHere.length();r++){
                if (Character.isDigit(passwordHere.charAt(r))){
                    f2 = 1;
                }
            }
            for (int s=0; s < passwordHere.length();s++){
                char c = passwordHere.charAt(s);
                if (c>=33&&c<=46||c==64){
                    f3 = 1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }




    /*private void showHidePwd() {
        ImageView imageViewShowHidePwd = findViewById(R.id.imageView_show_hide_pwd);
        imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);

        imageViewShowHidePwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (editTextRegisterPwd.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    editTextRegisterPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);
                }else {
                    editTextRegisterPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
                }
            }
        });
    }

    private void findViews() {
        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterPwd = findViewById(R.id.editText_register_pwd);
        editTextRegisterName = findViewById(R.id.editText_register_name);
        progressBar = findViewById(R.id.progressBar);
    }*/
}