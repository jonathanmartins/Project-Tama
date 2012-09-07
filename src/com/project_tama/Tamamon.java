package com.project_tama;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect; // L T R B 

public class Tamamon {

	private int currentFrame = 0;

	private int x = 0;
	private int y = 0;

	private int xSpeed = 10;
	private int ySpeed = 10;

	private City city;
	private Bitmap bmp;

	public Tamamon(City city, Bitmap bmp) {
		this.city = city;
		this.bmp = bmp;	
	}

	public void drawMe(Canvas canvas) {
		update();
		Rect src = leftWalk(currentFrame);
		Rect dst = new Rect(x, y, x + 55, y + 50);
		canvas.drawBitmap(bmp, src, dst, null);
	}

	private void update() {
		if (x > city.getWidth() - 55 - xSpeed || x + xSpeed < 0) {
			xSpeed = -xSpeed;
		}
		x += xSpeed;

		if (y > city.getHeight() - 50 - ySpeed || y + ySpeed < 0) {
			ySpeed = -ySpeed;
		}
		y += ySpeed;


		currentFrame = ++currentFrame % 3;
	}

	private Rect leftWalk(int frame) {
		int[][] motion = {{0,0,65,65}, {80,0,145,65}, {0,80,65,145}, {80,80,145,145}};

		return new Rect(motion[frame][0], motion[frame][1], motion[frame][2], motion[frame][3]);
	}
}
