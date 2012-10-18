package com.project_tama.activities.city;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.project_tama.activities.city.texture.Background;
import com.project_tama.tamamon.Tamamon;

public class City extends SurfaceView {
	
	private CityCallback callback;
	private Tamamon tama;
	private Background background; 

	public City(Context context) {
		super(context);

		callback = new CityCallback(this);
		getHolder().addCallback(callback);

		tama = new Tamamon(context);
		background = new Background(context);
	}

	@Override
	public void onDraw(Canvas canvas) {
		background.drawMe(canvas);
		tama.drawMe(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		tama.walkTo(event.getX(), event.getY(), this.getWidth(), this.getHeight());
		return super.onTouchEvent(event);
	}
	
	public void onPause() {
		callback.surfaceDestroyed(getHolder());
	}
}
