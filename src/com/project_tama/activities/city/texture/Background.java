package com.project_tama.activities.city.texture;

import com.project_tama.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Background {

	private Bitmap bmp;
	
	public Background(Context context) {
		bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.texture);
	}
	
	public void drawMe(Canvas canvas) {
		int textureWidth = bmp.getWidth(), textureHeight = bmp.getHeight();
		
		for (int i = 0; i < 3; i++) {
			canvas.drawBitmap(bmp, textureWidth*i, 0, null);
			canvas.drawBitmap(bmp, textureWidth*i, textureHeight, null);	
		}
	}
}
