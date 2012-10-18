package com.project_tama.tamamon;

import android.content.Context;
import android.graphics.Canvas;

import com.project_tama.tamamon.action.ActionController;

public class Tamamon {

	private ActionController controller;

	public Tamamon(Context context) {
		controller = new ActionController(context);
	}

	public void drawMe(Canvas canvas) {
		controller.drawOnCanvas(canvas);
	}

	public void walkTo(float x, float y, int screenWidth, int screenHeight) {
		controller.notifyMotor(x, y, screenWidth, screenHeight);
	}
	
}
