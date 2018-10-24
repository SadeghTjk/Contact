package com.shadow.contact;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class list extends AppCompatActivity {
    RecyclerView rv;
    DBHelper helper;
    Button back,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        rv = findViewById(R.id.rv);
        back = findViewById(R.id.back);
        delete = findViewById(R.id.deletebtn);

        helper = new DBHelper(this);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(llm);
        CustomAdapter ca = new CustomAdapter(this,helper);
        rv.setAdapter(ca);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.deleteAllData();
            }
        });


    }
}
