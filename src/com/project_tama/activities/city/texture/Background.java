package com.project_tama.activities.city.texture;

import com.project_tama.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {

	private Bitmap bkground;
	private Bitmap warn;
	private Bitmap pkball;
	
	public Background(Context context) {
		bkground = BitmapFactory.decodeResource(context.getResources(), R.drawable.texture);
		warn = BitmapFactory.decodeResource(context.getResources(), R.drawable.warn);
		pkball = BitmapFactory.decodeResource(context.getResources(), R.drawable.pokeball);
	}
	
	public void drawMe(Canvas canvas) {
		int wi = 0;
		do {
			canvas.drawBitmap(bkground, bkground.getWidth()*wi, 0, null);
			int hi = 1;
			do {
				canvas.drawBitmap(bkground, bkground.getWidth()*wi, bkground.getHeight()*hi, null);
				hi++;
			} while(bkground.getHeight()*hi < canvas.getHeight());
			wi++;
		} while (bkground.getWidth()*wi < canvas.getWidth());
		
		Rect dst = new Rect(20,20,20+pkball.getWidth(),20+pkball.getHeight()); 
		canvas.drawBitmap(pkball, null, dst, null);
		
		dst = new Rect(20,20,20+warn.getWidth(),20+warn.getHeight());
		canvas.drawBitmap(warn, null, dst, null);
	}
}
