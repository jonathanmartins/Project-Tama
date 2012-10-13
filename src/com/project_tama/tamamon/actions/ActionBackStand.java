package com.project_tama.tamamon.actions;

import com.project_tama.tamamon.actions.controller.ActionType;

public class ActionBackStand extends ActionType {
	public ActionBackStand() {
		//(left, top, right bottom). 
		this.frame = 0;
		this.MOTION = new int[][]{{0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380},
								  {0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380},
								  {0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380}, {0,315,65,380},
				                  {80,240,145,305}, {80,240,145,305}, {160,160,225,225}, {160,160,225,225},
				                  {80,240,145,305}, {80,240,145,305}, {160,160,225,225}, {160,160,225,225}};
	}
}
