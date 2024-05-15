package com.javaexamples.feellucky;

import android.util.Log;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    TextView textViewy;
    TextView lucky;
    Button shareButton;
    // public String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewy = findViewById(R.id.textView2);
        lucky = findViewById(R.id.luckyN);
        //lucky.setText("hh");
        shareButton = findViewById(R.id.share_btn);
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //lucky.setText("hh");
        int ranNum;
        ranNum = rNum();
        String str2 = Integer.toString(ranNum);
        lucky.setText(str2);

        shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shareData(userName, ranNum);
            }
        });
    }

    private int rNum() {
        int n;

        Random random = new Random();
        n = random.nextInt(100);

        return n;
    }

    private void shareData(String userName, int aRanNum) {
        String str1 = Integer.toString(aRanNum);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is \n" + str1);
        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}
