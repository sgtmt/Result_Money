package com.sg_tmt.result_money;


import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;



public class SecondActivity extends AppCompatActivity {
    ActionBar actionBar;
    LinearLayout linearLayout;
    private InputMethodManager inputMethodManager;

    EditText member;
    EditText money;
    EditText back_member;
    EditText members_money;
    String text = "";
    String mem_text, money_text, back_m_text, mem_mo_text;
    TextView memo;
    String kiroku = "";
    Button button;
    int f1;
    int f2;
    int f3;
    int f4;
    int mem_result;
    int money_result;
    int back_result;
    int member_result;
    int result_data;
    int people_member;
    int now_money;
    String reset = "0";
    String allMoney = "";
    String amari = "";
    String sagaku ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        linearLayout = (LinearLayout) findViewById(R.id.activity_second);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        member = (EditText) findViewById(R.id.member);
        money = (EditText) findViewById(R.id.money);
        back_member = (EditText) findViewById(R.id.back_member);
        members_money = (EditText) findViewById(R.id.members_money);
        button = (Button) findViewById(R.id.button);

        memo = (TextView) findViewById(R.id.textView2);


        member.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mem_text = member.getText().toString();
                if (b) {
                    member.setText("");
                    f1 = 0;
                } else {
                    if (mem_text.equals("") == true) {

                    } else {
                        member.setText(mem_text);
                        kiroku = member.getText().toString();
                        f1 = 1;
                    }
                }
                memo.setText(kiroku);
            }
        });
        money.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean bss) {
                money_text = money.getText().toString();
                if (bss) {
                    money.setText("");
                    f2 = 0;
                } else {
                    memo.setText(text);
                    if (money_text.equals("") == true) {

                    } else {
                        money.setText(money_text);
                        kiroku = money.getText().toString();
                        f2 = 1;
                    }
                }
                memo.setText(kiroku);

            }
        });
        back_member.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean baa) {
                back_m_text = back_member.getText().toString();
                if (baa) {
                    back_member.setText("");
                    f3 = 0;
                } else {
                    back_member.setText(back_m_text);
                    if (back_m_text.equals("") == true) {

                    } else {
                        back_member.setText(back_m_text);
                        kiroku = back_member.getText().toString();
                        f3 = 1;
                    }
                }
                memo.setText(kiroku);
            }
        });
        members_money.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                mem_mo_text = members_money.getText().toString();
                if (b) {
                    members_money.setText("");
                    f4 = 0;
                } else {
                    memo.setText(mem_mo_text);
                    if (mem_mo_text.equals("") == true) {

                    } else {
                        members_money.setText(mem_mo_text);
                        kiroku = members_money.getText().toString();
                        f4 = 1;
                    }
                }
                memo.setText(kiroku);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f1 == 1 && f2 == 1 && f3 == 1 && f4 == 1) {

                    mem_result = Integer.parseInt(mem_text);
                    money_result = Integer.parseInt(money_text);
                    back_result = Integer.parseInt(back_m_text);
                    member_result = Integer.parseInt(mem_mo_text);


                    if (money_result < mem_result) {
                        Bignumber_fragment dialog = Bignumber_fragment.newInstance();
                        dialog.show(getSupportFragmentManager(), "dialog");

                    }
                    if (mem_result - back_result > 0) {
                        people_member = mem_result - back_result;
                    }
                    if (money_result > member_result) {
                        result_data = ((money_result / people_member) - member_result);
                    }

                    kiroku = String.valueOf((money_result-member_result)/(mem_result-back_result));
                    allMoney= String.valueOf((money_result-member_result));
                    sagaku = String.valueOf((money_result-(money_result-member_result))-member_result);

                    memo.setText(kiroku);


                    if((money_result > mem_result)) {
                        notication();
                        sampleDialog();
                    }
//                    previewFragment dialog = previewFragment.newInstance();
//                    dialog.show(getSupportFragmentManager(), "dialog");


                } else {


                    ErrorFragment dialog = ErrorFragment.newInstance();
                    dialog.show(getSupportFragmentManager(), "dialog");


                }


            }
        });

        members_money.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    //ソフトキーボードを閉じる
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        //背景にフォーカスを移す
        linearLayout.requestFocus();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void notication() {
        int notificationId = 001;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.warikan)
                        .setContentTitle("支払金額について")
                        .setContentText("合計金額は"+money_text+"円です。\n1人あたりの支払金額は" + kiroku + "円です。\n総支払額は"+
                                allMoney+"円です。\n帰宅した"+back_result+"名の方が置いていった\n総額は"+member_result+"円です。\n不足金は、"+sagaku+"円です。");
// Notification を発行
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

    public void sampleDialog() {
        new MaterialDialog.Builder(this)
                .title("１人あたりの支払金額")
                .content("合計金額は"+money_text+"円です。\n1人あたりの支払金額は" + kiroku + "円です。\n総支払額は"+
                allMoney+"円です。\n帰宅した"+back_result+"名の方が置いていった\n総額は"+member_result+"円です。\n不足金は、"+sagaku+"円です。")
                .positiveText("ok")
                .show();
    }

}
