package com.project_tama;

import android.graphics.Canvas;

import com.project_tama.activities.city.City;

public class GameLoop extends Thread {
	private City city;
	private boolean running = false;

	static final long FPS = 15;
	static final long ticksPS = 1000/FPS;

	public GameLoop(City city) {
		this.city = city;
	}

	public void finish() {
		running = false;

		boolean retry = true;
		while (retry) {
			try {
				join();
				retry = false;
			} catch (InterruptedException e) {
				// TO-DO
				e.printStackTrace();
			}
		}
	}

	public void run() {
		long iTime, sleepTime;
		running = true;
		while (running) {
			Canvas c = null;
			iTime = System.currentTimeMillis();
			try {
				c = city.getHolder().lockCanvas();
				synchronized (city.getHolder()) {
					city.onDraw(c);
				}
			} finally {
				if (c != null) {
					city.getHolder().unlockCanvasAndPost(c);
				}
			}
			sleepTime = ticksPS - (System.currentTimeMillis() - iTime);
			try {
				if (sleepTime > 0)
					sleep(sleepTime);
			} catch (Exception e) {
				// TO-DO
				e.printStackTrace();
			}
		}
	}

}
