package com.javaexamples.feellucky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String userName = editText.getText().toString();
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                i.putExtra("name", userName);
                startActivity(i);
            }
        });
    }
}
