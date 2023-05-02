package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String [][] packeges=
            {
                    {"Packege 1 : Полная проверка тела","","","","999"},
                    {"Packege 2 : Уровень глюкозы в крови","","","","299"},
                    {"Packege 3 : Антитела к Covid-19 - IgG","","","","899"},
                    {"Packege 4 : Проверка щитовидной железы","","","","499"},
                    {"Packege 5 : Тест иммунной системы","","","","699"}
            };

    private String[] packege_details = {
            "Уровень глюкозы в крови\n" +
                    "Полная гемограмма\n" +
                    "Исследования железа\n"+
                    "Тест на функцию почек\n"+
                    "ЛДГ-лактатдегидрогеназа,\n"+
                    "Липидный профиль\n"+
                    "Функциональный тест печени",
            "Уровень глюкозы в крови",
            "COVID-19 Антитела - IgG",
            "Профиль щитовидной железы -общий (Т3, Т4 и ТТГ сверхчувствительный",
            "Полная гемограмма\n"+
                    "Исследования железа\n"+
                    "Тест на функцию почек\n"+
                    "D-25 гидроксивитаминов\n"+
                    "Функциональный тест печени\n"+
                    "Липидный профиль"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGotoCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        getSupportActionBar().hide();

        btnGotoCart = findViewById(R.id.buttonLTGoToCart);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, Home_activity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packeges.length;i++)
        {
            item = new HashMap<String, String>();
            item.put("line1", packeges[i][0]);
            item.put("line2", packeges[i][1]);
            item.put("line3", packeges[i][2]);
            item.put("line4", packeges[i][3]);
            item.put("line5", "Cons Fees:" + packeges[i][4]+ "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                 it.putExtra("text1",packeges[i][0]);
                 it.putExtra("text2",packege_details[i]);
                 it.putExtra("text3",packeges[i][4]);
                 startActivity(it);
            }
        });

        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}