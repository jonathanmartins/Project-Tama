package com.project_tama;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class City extends SurfaceView {
	private Tamamon tama;
	private Bitmap texture; 

	public City(Context context) {
		super(context);

		/* In order to draw, we should make a explicit call */
		getHolder().addCallback(new CityCallback(this));

		/* Drawing the Tamamon sprite */
		tama = new Tamamon(this, BitmapFactory.decodeResource(getResources(), R.drawable.yoyo6));
		
		texture = BitmapFactory.decodeResource(getResources(), R.drawable.texture);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(texture, 0, 0, null);
		tama.drawMe(canvas);
	}
	
}
