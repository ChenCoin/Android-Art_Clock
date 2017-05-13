package com.mycompany.myapp;
import android.appwidget.*;
import android.content.*;
import android.widget.*;

public class WidgetProduce
{
	public void updateViews(Context c){
		Config config = Config.getConfig(c);
		RemoteViews r = new RemoteViews(c.getPackageName(), config.getView());

		AppWidgetManager aWM = AppWidgetManager.getInstance(c);
		ComponentName appWidgetId = new ComponentName(c, Widget.class);
        aWM.updateAppWidget(appWidgetId, r);
	}
}
