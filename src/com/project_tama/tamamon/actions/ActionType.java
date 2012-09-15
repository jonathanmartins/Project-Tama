package com.project_tama.tamamon.actions;

import android.graphics.Rect;

public class ActionType {
	protected int frame;
	protected int[][] MOTION;
	
	private Rect createAction(int frame) {
		return new Rect(MOTION[frame][0], MOTION[frame][1], MOTION[frame][2], MOTION[frame][3]);
	}
	
	public Rect execute() {
		frame = ++frame % (MOTION.length-1);
		return createAction(frame);
	}
}
