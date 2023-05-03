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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Трекрезан 250 мг", "", "", "", "300"},
                    {"Аспирин", "", "","","305"},
                    {"Капсула с комплексом витаминов группы D", "","","","448"},
                    {"Капсула с комплексом витаминов группы E", "","","", "539"},
                    {"Нурофен", "", "", "", "400"},
                    {"Ибуклин", "","","","240"},
                    {"Стрепсилс - лекарственные пастилки от боли в горле", "","","","300"},
                    {"Снуп", "","","","200"},
                    {"Смекта", "","","","345"},
            };
    private String[] package_details = {
            "Препарат для повышения иммунитета и профилактики простудных заболеваний\n"+
                    "При лечении и профилактике ОРВИ\n"+
                    "Активирует иммунитет, помогает справиться с высокими нагрузками",
            "Лекарственное средство, оказывающее обезболивающее, жаропонижающее, противовоспалительное действие\n",
            "Помогает организму усваивать кальций и фосфор, которые необходимы для роста костей\n"+
                    "Выполняет защитную функцию: сокращает рост раковых клеток,\n"+
                    "Уменьшает выраженность воспалительных процессов",
            "Витамин Е является универсальным протектором клеточных мембран от окислительного повреждения.\n"+
                    "Активизирует ферментативную антиоксидантную защиту\n"+
                    "Способствует укреплению иммунозащитных сил организма",
            "Препарат применяется для снижения темпертуры и снятия боли\n",
            "Это комбинированный препарат, который обладает противовоспалительным, жаропонижающим и болеутоляющим эффектом.\n"+
                    "Максимальный эффект при лечении различных видов болевых синдромов.",
            "Препарат оказывает местное обезболивающее и противовоспалительное действие на слизистую оболочку полости рта и горла\n"+
                    "Уменьшает отек, затруднение при глотании, боль и ощущение раздражения в горле",
            "Назальный дозированный спрей, предназначенный для лечения и профилактики аллергических ринитов\n"+
                    "Он содержит действующее вещество – ксилометазолин гидрохлорид, который оказывает противовоспалительный и антигистаминный эффект.",
            "Помогает с нарушениями в работе желудочно-кишечного тракта"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, Home_activity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5","Total Cost:"+ packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}