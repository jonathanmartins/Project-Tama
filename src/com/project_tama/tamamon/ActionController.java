package com.project_tama.tamamon;

import java.util.HashMap;

import android.graphics.Rect;

import com.project_tama.tamamon.actions.*;

public class ActionController {

	private HashMap<String, ActionType> actions;

	public ActionController() {
		actions = new HashMap<String, ActionType>();
		actions.put("LEFT", new ActionLeftWalk());
		actions.put("RIGHT", new ActionRightWalk());
		actions.put("FSTAND", new ActionFrontStand());
		actions.put("BSTAND", new ActionBackStand());
	}

	public Rect dst(int x, int y) {
		return new Rect(x, y, x + 55, y + 50);
	}
	
	public Rect walk(int xSpeed) {
		if (xSpeed > 0) {
			return actions.get("RIGHT").execute();
		} else {
			return actions.get("LEFT").execute();
		}
	}

	public Rect stand(int ySpeed) {
		if (ySpeed < 0) {
			return actions.get("BSTAND").execute();
		} else {
			return actions.get("FSTAND").execute();
		}
	}

}
