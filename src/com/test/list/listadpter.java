package com.test.list;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class listadpter extends BaseAdapter {
	int lastx;
	int lastY;
	ArrayList<String> mlist = null;


	Context mycontest = null;

	public listadpter(Context c, ArrayList<String> mlist) {

		this.mlist = mlist;
		this.mycontest = c;

	}

	public int getCount() {

		return mlist.size();
	}

	public Object getItem(int position) {

		return mlist.get(position);
	}

	public long getItemId(int position) {

		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		 stringview Sview = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mycontest).inflate(
					R.layout.item_frined, null);
			Sview = new stringview();
			Sview.tv = (Button) convertView.findViewById(R.id.button1);
			convertView.setTag(Sview);
		} else {

			Sview = (stringview) convertView.getTag();
		}
		Sview.tv.setText(mlist.get(position).toString());
	
		Sview.tv.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {

				int rawX = (int) event.getRawX();
				int rawY = (int) event.getRawY();

				switch (event.getAction()) {
						
				case MotionEvent.ACTION_DOWN:
					lastx=rawX;
					lastY=rawY;
					break;
				case MotionEvent.ACTION_MOVE:
					int offsetX=rawX-lastx;
					int offsetY=rawY-lastY;
		
					v.layout(v.getLeft()+offsetX,
							v.getTop()+offsetY ,
							v.getRight()+offsetX, 
							v.getBottom()+offsetY);
					 lastx=rawX;
					 lastY=rawY;
					 
					break;

				}
				return false;
			}
		});
	
 
		return convertView;
	}

	class stringview {
		Button tv;

	}


}
