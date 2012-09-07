package com.project_tama.tamamon.actions;

import android.graphics.Rect;

public class ActionLeftWalk implements ActionType {
	private int frame;
	private static final int[][] MOTION = {{0,0,65,65}, {80,0,145,65}, {0,80,65,145}, {80,80,145,145}};
	
	public ActionLeftWalk() {
		this.frame = 0;
	}

	private Rect createAction(int frame) {
		return new Rect(MOTION[frame][0], MOTION[frame][1], MOTION[frame][2], MOTION[frame][3]);
	}

	public Rect execute() {
		frame = ++frame % (MOTION.length-1);
		return createAction(frame);
	}

}
