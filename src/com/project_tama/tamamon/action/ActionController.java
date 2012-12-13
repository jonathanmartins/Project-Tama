package com.project_tama.tamamon.action;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.project_tama.R;
import com.project_tama.database.DatabaseHandler;
import com.project_tama.tamamon.action.designer.Designer;
import com.project_tama.tamamon.action.motor.Motor;

public class ActionController {
	
	private Designer designer;
	private Motor motor;
	
	private Bitmap bmp;
	
	public ActionController(Context context) {
		this.bmp = Bitmap.createBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.inits));
		
		int width = bmp.getWidth() / 18;
		int height = bmp.getHeight() / 4;
		
		designer = new Designer(width, height);
		
		DatabaseHandler db = new DatabaseHandler(context);
		motor = new Motor(width, height, db.getTamamon(1).getTamaId());
		db.close();
	}
	
	public void drawOnCanvas(Canvas canvas) {
		Rect src = motor.walk();
		Rect dst = designer.drawRect(motor.getX(), motor.getY());
		canvas.drawBitmap(bmp, src, dst, null);
	}
	
	public void notifyMotor(float x, float y, int sWidth, int sHeight) {
		motor.walkTo(x, y, sWidth, sHeight);
	}

}
