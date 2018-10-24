package com.shadow.contact;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {
    EditText name,number;
    Button save,back;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        save = findViewById(R.id.savebtn);
        back = findViewById(R.id.back);
        helper = new DBHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String p = number.getText().toString();
                boolean res = helper.insertData(n,p);
                if(res)
                    Toast.makeText(getApplicationContext(), "Contact Added.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Failed!!!", Toast.LENGTH_SHORT).show();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
