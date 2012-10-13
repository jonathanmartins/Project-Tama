package com.project_tama.tamamon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.project_tama.R;

public class Tamamon {

	private int currentFrame = 0;

	private int toX = 0;
	private int toY = 0;
	private int x = 0;
	private int y = 0;

	private int xSpeed = 5;
	private int ySpeed = 5;

	private Bitmap bmp;
	private int width;
	private int height;

	public Tamamon(Context context) {
		this.bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bub);
		this.width =  bmp.getWidth() / 6;
		this.height = bmp.getHeight() / 4;
	}

	public void drawMe(Canvas canvas) {

		Rect src = walk();
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(bmp, src, dst, null);
	}

	public void walkTo(float x, float y) {
		this.toX = Float.valueOf(x).intValue() + (5 - Float.valueOf(x).intValue()%5);
		this.toY = Float.valueOf(y).intValue() + (5 - Float.valueOf(y).intValue()%5);
	}

	private Rect walk() {
		if (toX != x || toY != y) {
			if (toX > x) {
				x += xSpeed;
				int h = ((++currentFrame%2)+2)*height;
				int w = 1*width;
				return new Rect(w, h, w+width, h+height);
			} else if (toX < x) {
				x -= xSpeed;
				int h = (++currentFrame%2)*height;
				int w = 1*width;
				return new Rect(w, h, w+width, h+height);
			}

			if (toY > y) {
				y += ySpeed;
				int h = ((++currentFrame%2)+2)*height;
				int w = 0*width;
				return new Rect(w, h, w+width, h+height);
			} else if (toY < y) {
				y -= ySpeed;
				int h = (++currentFrame%2)*height;
				int w = 0*width;
				return new Rect(w, h, w+width, h+height);
			}
		} else {
			int h = 2*height;
			int w = 0*width;
			return new Rect(w, h, w+width, h+height);
		}
		return null;
	}
}
