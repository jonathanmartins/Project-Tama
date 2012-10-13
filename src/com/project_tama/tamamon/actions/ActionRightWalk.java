package com.project_tama.tamamon.actions;

import com.project_tama.tamamon.actions.controller.ActionType;

public class ActionRightWalk extends ActionType {
	public ActionRightWalk() {
		this.frame = 0;
		this.MOTION = new int[][]{{160,0,225,65}, {240,0,305,65}, {160,80,225,145}, {240,80,305,145}};
	}
}
