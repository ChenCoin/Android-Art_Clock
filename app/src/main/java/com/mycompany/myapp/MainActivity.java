package com.mycompany.myapp;

import android.app.*;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends Activity 
{
    FrameLayout fl;
    LayoutInflater inflater;
    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //将软件界面设为沉浸式状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                widgetChange();
            }
        });

        config = Config.getConfig(getApplicationContext());

        fl = (FrameLayout)findViewById(R.id.show_view);
        inflater=getLayoutInflater();
        View view = inflater.inflate(config.getView(), fl , false);
        fl.addView(view);
    }

    private void widgetChange(){
        config.incStyleClock();

        (new WidgetProduce()).updateViews(MainActivity.this);

        fl.removeAllViews();
        View view = inflater.inflate(config.getView(), fl , false);
        fl.addView(view);
    }

}
