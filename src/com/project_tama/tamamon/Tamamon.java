package com.project_tama.tamamon;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Tamamon {

	private ActionController controller;

	private int x = 0;
	private int y = 0;

	private int xSpeed = 10;
	private int ySpeed = 10;

	private Bitmap bmp;

	public Tamamon(Bitmap bmp) {
		this.bmp = bmp;
		this.controller = new ActionController();
	}

	public void drawMe(Canvas canvas) {
		update(canvas);
		
		canvas.drawBitmap(bmp, controller.walk(xSpeed, ySpeed), controller.dst(x, y), null);
	}

	private void update(Canvas canvas) {
		if (x > canvas.getWidth() - 55 - xSpeed || x + xSpeed < 0) {
			xSpeed = -xSpeed;
		}
		x += xSpeed;

		if (y > canvas.getHeight() - 50 - ySpeed || y + ySpeed < 0) {
			ySpeed = -ySpeed;
		}
		y += ySpeed;
	}

}
