package com.example.calc;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResult;
    Button btnEnter;
    Button btnClear;
    TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        LinearLayoutCompat.LayoutParams lp = new LinearLayoutCompat.LayoutParams
        (
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT
        );

        display = new TextView(this);

        ll.addView(display);

        TableLayout tl = new TableLayout(this);
        //tl.setLayoutParams(lp);

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT);
        p.weight = 1;

        int curNum = 0;

        for (int i = 0; i < 4; i++) {
            TableRow tr = new TableRow(this);
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tr.getLayoutParams();
//            params.weight = 1;
//            params.width = 0;
//            params.height = LinearLayout.LayoutParams.WRAP_CONTENT;

            for(int j = 0; j < 3; j++) {
                Button btn = new Button(this);

                /*btn.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                btn.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                btn.getLayoutParams().w = 1;*/


                //weight ???
                btn.setOnClickListener(this);

                if (i < 3) {
                    btn.setText(++curNum + "");
                }
                else if (curNum == 9) {
                    btn.setText("clear");
                    curNum++;
                    btnClear = btn;
                } else if (curNum == 10) {
                    btn.setText("0");
                    curNum++;
                } else if (curNum == 11) {
                    btn.setText("enter");
                    btnEnter = btn;
                }

                tr.addView(btn);
            }

            tl.addView(tr);
        }

        ll.addView(tl);
        setContentView(ll, lp);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnClear)
        {
            display.setText("");
            return;
        }
        else if (v == btnEnter)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    display.getText(), Toast.LENGTH_SHORT);
            toast.show();
            display.setText("");
            return;
        }

        Button btn = (Button)v;
        display.append(btn.getText());
    }
}