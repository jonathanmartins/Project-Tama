package com.project_tama.activities.city.texture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.project_tama.R;

public class Background {

	private Bitmap bkground;
	
	public Background(Context context) {
		bkground = BitmapFactory.decodeResource(context.getResources(), R.drawable.city);
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
	}
}
