package com.project_tama;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Tamamon {

	private static final int COLS = 2;
	private int width;
	private int height;
	private int currentFrame = 0;
	
	private int x = 0;
	private int y = 0;
	private int xSpeed = 5;
	private City city;
	private Bitmap bmp;

	public Tamamon(City city, Bitmap bmp) {
		this.city = city;
		this.bmp = bmp;	
		this.width = 55;
		this.height = 50;
	}
	
	public void drawMe(Canvas canvas) {
		update();
        int srcX = currentFrame * width;
        int srcY = 1 * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bmp, src, dst, null);
	}

	private void update() {
		if (x > city.getWidth() - bmp.getWidth() - xSpeed) {
			xSpeed = -5;
		}
		
		if (x + xSpeed< 0) {
			xSpeed = 5;
		}

		x += xSpeed;
		currentFrame = ++currentFrame % COLS;
	}
}
