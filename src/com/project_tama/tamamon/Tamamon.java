package com.project_tama.tamamon;

import android.content.Context;
import android.graphics.Canvas;

import com.project_tama.tamamon.action.ActionController;

public class Tamamon {

	private ActionController controller;
	
	private int id;
	private int tamaId;
	private String name;
	private int life;
	private int energy;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTamaId() {
		return tamaId;
	}

	public void setTamaId(int tamaId) {
		this.tamaId = tamaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	//Using in database
	public Tamamon(int id, int tamaId, String name, int life, int energy){
		this.id = id;
		this.tamaId = tamaId;
		this.name = name;
		this.life = life;
		this.energy = energy;
	}
	
	public Tamamon(String name, int life, int energy){
		this.name = name;
		this.life = life;
		this.energy = energy;
	}
	
	//Using in database
	public Tamamon(){}

	public void drawMe(Canvas canvas) {
		controller.drawOnCanvas(canvas);
	}

	public void walkTo(float x, float y, int screenWidth, int screenHeight) {
		controller.notifyMotor(x, y, screenWidth, screenHeight);
	}

	public void setControllerContext(Context context) {
		controller = new ActionController(context);		
	}

}
