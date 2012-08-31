package name.hash.characterclock;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class ClockWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		updateAppWidget(context);
	}

	public void updateAppWidget(Context context) {
		AppWidgetManager manager = AppWidgetManager.getInstance(context);
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		long currentTimeMillis = System.currentTimeMillis();
		int time = (int) ((currentTimeMillis / 1000) & 0xFFFFFFFF);
		views.setTextViewText(R.id.time_char, String.valueOf((char) time));
		manager.updateAppWidget(new ComponentName(context, ClockWidget.class), views);
	}
}
