package com.project_tama.tamamon.action.designer;

import android.graphics.Rect;

import com.project_tama.tamamon.action.RectFactory;

public class Designer {
	
	private RectFactory factory;
	
	public Designer(int width, int height) {
		this.factory = new RectFactory(width, height);
	}
	
	public Rect drawRect(int x, int y) {
		return factory.createRect(x, y);
	}
	
	public Rect drawRect(Rect r) {
		return factory.createRect(r);
	}
	
}
