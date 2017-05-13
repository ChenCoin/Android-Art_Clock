package com.mycompany.myapp;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.*;
import android.content.*;
import android.net.*;
import android.util.*;
import android.widget.*;
import android.os.*;
import android.text.format.*;

public class Widget extends AppWidgetProvider
{
	private static WidgetProduce WP = new WidgetProduce();

	@Override
    public void onUpdate(Context c, AppWidgetManager aWM, int[] appWidgetIds) {
        WP.updateViews( c.getApplicationContext() );
        super.onUpdate(c, aWM, appWidgetIds);  
    }
	
}
