package com.example.recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        Intent intent = getIntent();
        String sfullName = intent.getStringExtra("nameFull");
        String shardFull = intent.getStringExtra("hardFull");
        String sfullDesc = intent.getStringExtra("descFull");

        TextView nameFull = (TextView) findViewById(R.id.nameFull);
        TextView hardFull = (TextView) findViewById(R.id.hardFull);
        TextView descFull = (TextView) findViewById(R.id.descFull);

        nameFull.setText(sfullName);
        hardFull.setText(shardFull);
        descFull.setText(sfullDesc);

    }
}
