package com.test.list;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.test.list.R.layout;

import android.app.Activity;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;

public class DddActivity extends Activity {
	int index = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initview();
	}

	private void initview() {
		final ListView listView = (ListView) findViewById(R.id.mlist);
		ArrayList<String> ss = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			ss.add("asd" + i);
		}

		listadpter listadpter = new listadpter(this, ss);
		listView.setAdapter(listadpter);
	
		Timer autoUpdate = new Timer();
/**
 * ×Ô¶¯¹ö¶¯listview
 */
		autoUpdate.schedule(new TimerTask() {
			@Override
			public void run() {

				runOnUiThread(new Runnable() {
					public void run() {

						index += 1;
						if (index >= listView.getCount()) {
							index = 0;

						}
						listView.smoothScrollToPosition(index);
					}
				});
			}
		}, 0, 500);

	}
}