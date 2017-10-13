package xyz.zzyandzzy.utility.supertoastdemo;

import android.graphics.Color;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import xyz.zzyandzzy.utility.widget.SuperToast;
import xyz.zzyandzzy.utility.widget.SuperToastType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1, bt2, bt3;
    private Button bt4, bt5, bt6;
    private Button bt7, bt8, bt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        SuperToast.make(this, "hhh").show();
    }

    private void initView() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        bt1 = findViewById(R.id.main_button1);
        bt2 = findViewById(R.id.main_button2);
        bt3 = findViewById(R.id.main_button3);

        bt4 = findViewById(R.id.main_button4);
        bt5 = findViewById(R.id.main_button5);
        bt6 = findViewById(R.id.main_button6);

        bt7 = findViewById(R.id.main_button7);
        bt8 = findViewById(R.id.main_button8);
        bt9 = findViewById(R.id.main_button9);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);

        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SuperToast superToast = new SuperToast(this);
        switch (v.getId()) {
            case R.id.main_button1:
                superToast.setImage(-1);
                superToast.setText("Text");
                break;
            case R.id.main_button2:
                superToast.setImage(R.mipmap.ic_launcher);
                break;
            case R.id.main_button3:
                superToast.setText("Color");
                superToast.setColor(Color.GREEN);
                break;
            case R.id.main_button4:
                superToast.setText("info");
                superToast.setType(SuperToastType.INFO);
                break;
            case R.id.main_button5:
                superToast.setText("Waring");
                superToast.setType(SuperToastType.WARNING);
                break;
            case R.id.main_button6:
                superToast.setText("Error");
                superToast.setType(SuperToastType.ERROR);
                break;
            case R.id.main_button7:
                superToast.setText("LongTime");
                superToast.setDuration(5000);
                break;
            case R.id.main_button8:
                superToast.setText("Center");
                superToast.setGravity(Gravity.CENTER, 0, 0);
                break;
            case R.id.main_button9:
                superToast.setText("Elevation");
                superToast.setColor(Color.WHITE);
                superToast.getTextView().setTextColor(Color.BLACK);
                VectorDrawableCompat drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_sentiment_neutral_black_24dp, getTheme());
                drawable.setTint(Color.BLACK);
                superToast.setImage(drawable);
                superToast.setElevation(5);
                break;
        }
        superToast.show();
    }
}
