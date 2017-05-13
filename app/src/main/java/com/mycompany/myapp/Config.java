package com.mycompany.myapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Coin on 2017/4/7.
 */

public class Config {
    private final static int view[] = {
            0,
            R.layout.c_sony1,
            R.layout.c_sony2,
            R.layout.c_samsung1,
            R.layout.c_samsung2,
            R.layout.c_xiaomi,
            R.layout.c_apple,
            R.layout.c_diy1,
            R.layout.c_diy2
    };
    private int STYLE_CLOCK = 0, CLOCK_NUM = 8;
    private Context c;
    private static Config config;

    private Config(Context c){
        this.c = c;
        setSTYLE_CLOCK();
    }

    public static Config getConfig(Context c){
        if (config == null) {
            config = new Config(c);
        }
        return config;
    }

    public int getView(){
        setSTYLE_CLOCK();
        return view[STYLE_CLOCK];
    }

    private void setSTYLE_CLOCK(){
        SharedPreferences pref = c.getSharedPreferences("data", Context.MODE_PRIVATE);
        STYLE_CLOCK = pref.getInt("STYLE_CLOCK",1);
    }

    public void incStyleClock(){
        if( STYLE_CLOCK == CLOCK_NUM )
            STYLE_CLOCK = 0;
        SharedPreferences.Editor editor = c.getSharedPreferences("data",c.MODE_PRIVATE).edit();
        editor.putInt("STYLE_CLOCK",STYLE_CLOCK+1);
        editor.apply();
    }

}
