package com.project_tama.tamamon;

import java.util.HashMap;

import android.graphics.Rect;

import com.project_tama.tamamon.actions.ActionLeftWalk;
import com.project_tama.tamamon.actions.ActionRightWalk;
import com.project_tama.tamamon.actions.ActionType;

public class ActionController {

	private HashMap<String, ActionType> actions;

	public ActionController() {
		actions = new HashMap<String, ActionType>();
		actions.put("LEFT", new ActionLeftWalk());
		actions.put("RIGHT", new ActionRightWalk());
	}

	private Rect perform(String action) {
		return actions.get(action).execute();
	}

	public Rect walk(int xSpeed, int ySpeed) {
		if (ySpeed < 0 && xSpeed > 0) {
			return perform("RIGHT");
		} else {
			return perform("LEFT");
		}
	}

	public Rect dst(int x, int y) {
		return new Rect(x, y, x + 55, y + 50);
	}

}
