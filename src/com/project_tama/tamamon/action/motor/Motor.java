package com.project_tama.tamamon.action.motor;

import com.project_tama.tamamon.action.RectFactory;

import android.graphics.Rect;

public class Motor {
	
	private RectFactory factory;
	
	private static final int xSpeed = 5;
	private static final int ySpeed = 5;
	
	private int currentFrame = 0;
	
	private int x = 0;
	private int y = 0;
	
	private int toX = 0;
	private int toY = 0;
	
	public Motor(int width, int height) {
		this.factory = new RectFactory(width, height);
	}

	public void walkTo(float x, float y, int sWidth, int sHeight) {
		int toX = offset(x);
		int toY = offset(y);
		
		if (toX+factory.getWidth() > sWidth-factory.getWidth()) {
			this.toX = offset(sWidth-factory.getWidth());
		} else {
			this.toX = toX;
		}
		
		if (toY+factory.getHeight() > sHeight-factory.getHeight()) {
			this.toY = offset(sHeight-factory.getHeight());
		} else {
			this.toY = toY;
		}
	}
	
	public Rect walk() {
		if (toX != x || toY != y) {
			if (toX > x) {
				x += xSpeed;
				int h = ((++currentFrame%2)+2)*factory.getHeight(); 
				int w = 3*factory.getWidth();
				return factory.createRect(w, h);
			} else if (toX < x) {
				x -= xSpeed;
				int h = (++currentFrame%2)*factory.getHeight();
				int w = 3*factory.getWidth();
				return factory.createRect(w, h);
			}

			if (toY > y) {
				y += ySpeed;
				int h = ((++currentFrame%2)+2)*factory.getHeight();
				int w = 2*factory.getWidth();
				return factory.createRect(w, h);
			} else if (toY < y) {
				y -= ySpeed;
				int h = (++currentFrame%2)*factory.getHeight();
				int w = 2*factory.getWidth();
				return factory.createRect(w, h);
			}
		} else {
			int h = 2*factory.getHeight();
			int w = 2*factory.getWidth();
			return factory.createRect(w, h);
		}
		return null;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	private int offset(int x) {
		return x + (5 -x%5);
	}
	
	private int offset(float x) {
		return Float.valueOf(x).intValue() + (5 - Float.valueOf(x).intValue()%5);
	}
}
