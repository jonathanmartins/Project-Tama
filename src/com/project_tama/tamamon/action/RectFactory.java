package com.project_tama.tamamon.action;

import android.graphics.Rect;

public class RectFactory {
	
	private int width;
	private int height;
	
	public RectFactory(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rect createRect(int x, int y) {
		return new Rect(x, y, x+width, y+height);
	}
	
	public Rect createRect(Rect r) {
		return new Rect(r);
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
