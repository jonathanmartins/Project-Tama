package com.project_tama.activities.city;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.project_tama.R;
import com.project_tama.tamamon.Tamamon;

public class City extends SurfaceView {
	private Tamamon tama;
	private Bitmap texture; 

	public City(Context context) {
		super(context);

		/* In order to draw, we should make a explicit call */
		getHolder().addCallback(new CityCallback(this));

		tama = new Tamamon(BitmapFactory.decodeResource(getResources(), R.drawable.yoyo));
		texture = BitmapFactory.decodeResource(getResources(), R.drawable.texture);
	}

	@Override
	public void onDraw(Canvas canvas) {
		drawTexture(canvas);
		
		tama.drawMe(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		tama.walkTo(event.getX(), event.getY());
		return super.onTouchEvent(event);
	}
	
	private void drawTexture(Canvas canvas) {
		int textureWidth = texture.getWidth(), textureHeight = texture.getHeight();
		
		/* Filling the display with */
		for (int i = 0; i < 3; i++) {
			canvas.drawBitmap(texture, textureWidth*i, 0, null);
			canvas.drawBitmap(texture, textureWidth*i, textureHeight, null);	
		}
	}
	
}
