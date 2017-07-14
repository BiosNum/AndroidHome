package com.example.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    EditText text;
    Button save;
    Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);

        load = (Button) findViewById(R.id.load);
        load.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                save();
                break;
            case R.id.load:
                load();
                break;
            default:
                break;
        }
    }

    public void save()
    {
        prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("stext", text.getText().toString());
        ed.commit();
    }

    public void load()
    {
        prefs = getPreferences(MODE_PRIVATE);
        String stext = prefs.getString("stext", "");
        text.setText(stext);
    }

}
