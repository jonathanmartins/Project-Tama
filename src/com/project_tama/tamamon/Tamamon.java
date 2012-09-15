package com.project_tama.tamamon;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Tamamon {

	private ActionController controller;
	private int toX = 0;
	private int toY = 0;

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
		canvas.drawBitmap(bmp, update(canvas), controller.dst(x, y), null);
	}

	public void walkTo(float x, float y) {
		this.toX = Float.valueOf(x).intValue();
		this.toY = Float.valueOf(y).intValue();
	}

	private Rect update(Canvas canvas) {
		if (isStopped()) {
			return controller.stand(ySpeed);
		} else {
			walk(canvas);
			return controller.walk(xSpeed);
		}
	}

	private boolean isStopped() {
		return toX == x && Math.abs(y - toY)<10;
	}

	private void walk(Canvas canvas) {
		xSpeed = toX < x ? -10 : 10;
		if (Math.abs(toX - x) >= 10) {
			x += xSpeed;
		} else {
			x +=  toX > x ? toX-x : x-toX;
		}

		ySpeed = toY < y ? -10 : 10;
		if (Math.abs(toY - y) >= 10) {
			y += ySpeed;
		} else {
			y +=  toY > y ? toY-y : y-toY;
		}
	}

}
