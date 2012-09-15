package com.project_tama.tamamon.actions;

public class ActionLeftWalk extends ActionType {
	public ActionLeftWalk() {
		this.frame = 0;
		this.MOTION = new int[][]{{0,0,65,65}, {80,0,145,65}, {0,80,65,145}, {80,80,145,145}};
	}
}
