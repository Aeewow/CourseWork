package com.example.coursework.Models;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursework.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Note extends AppCompatActivity {

    FloatingActionButton addNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        addNoteBtn = findViewById(R.id.add_note_btn);

        addNoteBtn.setOnClickListener((v)-> startActivity(new Intent(Note.this,NoteDetailsActivity.class)));
    }
}