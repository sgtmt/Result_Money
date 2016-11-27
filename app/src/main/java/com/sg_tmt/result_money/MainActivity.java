package com.sg_tmt.result_money;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_send;
    Button syukei;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_send =(Button)findViewById(R.id.button_send);
        syukei = (Button)findViewById(R.id.syukei);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = DialogFragment.newInstance();
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });
        syukei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


}
