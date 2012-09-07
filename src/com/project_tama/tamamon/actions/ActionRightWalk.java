package com.project_tama.tamamon.actions;

import android.graphics.Rect;

public class ActionRightWalk implements ActionType {
	private int frame = 0;
	private static final int[][] MOTION = {{160,0,225,65}, {240,0,305,65}, {160,80,225,145}, {240,80,305,145}};
	
	public ActionRightWalk() {
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
