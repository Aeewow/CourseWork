package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ann Nazarenko", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No: 89054568713", "600"},
                    {"Doctor Name : Egor Klichko", "Hospital Address: Zvezdiskaya", "Exp : 7yrs", "Mobile No: 89056573467", "900"},
                    {"Doctor Name : Andrew Konopalow", "Hospital Address: Lesnaya", "Exp : 1yrs", "Mobile No: 890543378523", "300"},
                    {"Doctor Name : Mike Tyson", "Hospital Address: Chinchwad", "Exp : 10yrs", "Mobile No: 89054665789", "500"},
                    {"Doctor Name : Djordj Hovhich", "Hospital Address: Katraj", "Exp : 15yrs", "Mobile No: 890541143681", "100"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ann Nazarenko", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No: 89054568713", "600"},
                    {"Doctor Name : Egor Klichko", "Hospital Address: Zvezdiskaya", "Exp : 7yrs", "Mobile No: 89056573467", "900"},
                    {"Doctor Name : Andrew Konopalow", "Hospital Address: Lesnaya", "Exp : 1yrs", "Mobile No: 890543378523", "300"},
                    {"Doctor Name : Mike Tyson", "Hospital Address: Chinchwad", "Exp : 10yrs", "Mobile No: 89054665789", "500"},
                    {"Doctor Name : Djordj Hovhich", "Hospital Address: Katraj", "Exp : 15yrs", "Mobile No: 890541143681", "100"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ann Nazarenko", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No: 89054568713", "600"},
                    {"Doctor Name : Egor Klichko", "Hospital Address: Zvezdiskaya", "Exp : 7yrs", "Mobile No: 89056573467", "900"},
                    {"Doctor Name : Andrew Konopalow", "Hospital Address: Lesnaya", "Exp : 1yrs", "Mobile No: 890543378523", "300"},
                    {"Doctor Name : Mike Tyson", "Hospital Address: Chinchwad", "Exp : 10yrs", "Mobile No: 89054665789", "500"},
                    {"Doctor Name : Djordj Hovhich", "Hospital Address: Katraj", "Exp : 15yrs", "Mobile No: 890541143681", "100"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ann Nazarenko", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No: 89054568713", "600"},
                    {"Doctor Name : Egor Klichko", "Hospital Address: Zvezdiskaya", "Exp : 7yrs", "Mobile No: 89056573467", "900"},
                    {"Doctor Name : Andrew Konopalow", "Hospital Address: Lesnaya", "Exp : 1yrs", "Mobile No: 890543378523", "300"},
                    {"Doctor Name : Mike Tyson", "Hospital Address: Chinchwad", "Exp : 10yrs", "Mobile No: 89054665789", "500"},
                    {"Doctor Name : Djordj Hovhich", "Hospital Address: Katraj", "Exp : 15yrs", "Mobile No: 890541143681", "100"},
            };

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
    }
}