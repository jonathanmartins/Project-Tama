package com.project_tama;

import android.view.SurfaceHolder;


public class CityCallback implements SurfaceHolder.Callback {
	private GameLoop gloop;

	public CityCallback(City city) {
		gloop = new GameLoop(city);
	}

	public void surfaceDestroyed(SurfaceHolder holder) { 
		gloop.finish();
	}

	public void surfaceCreated(SurfaceHolder holder) {
		gloop.start();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		//TO-DO
	}
}
