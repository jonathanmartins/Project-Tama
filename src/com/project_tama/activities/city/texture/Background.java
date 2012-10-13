package com.project_tama.activities.city.texture;

import com.project_tama.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {

	private Bitmap bmp;
	private Bitmap wmill;
	private int currentFrame;
	
	public Background(Context context) {
		bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.texture);
		wmill = BitmapFactory.decodeResource(context.getResources(), R.drawable.windmill);
		currentFrame = 0;
	}
	
	public void drawMe(Canvas canvas) {
		int wi = 0;
		do {
			canvas.drawBitmap(bmp, bmp.getWidth()*wi, 0, null);
			int hi = 1;
			do {
				canvas.drawBitmap(bmp, bmp.getWidth()*wi, bmp.getHeight()*hi, null);
				hi++;
			} while(bmp.getHeight()*hi < canvas.getHeight());
			wi++;
		} while (bmp.getWidth()*wi < canvas.getWidth());
		
		int w =  (++currentFrame % 3) * (wmill.getWidth() / 3);
		int h = canvas.getWidth() - (wmill.getWidth() / 3);
		Rect src = new Rect(w, 0, w+wmill.getWidth(), wmill.getHeight());
		Rect dst = new Rect(h, 0, h+wmill.getWidth(), wmill.getHeight());
		canvas.drawBitmap(wmill, src, dst, null);
	}
}
