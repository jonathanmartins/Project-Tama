package com.project_tama.activities.city;

import android.content.Intent;
import android.os.Bundle;

import com.project_tama.services.AbstractActivity;

public class CityActivity extends AbstractActivity {
	
	private City city;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		city = new City(this);
		setContentView(city);

		Intent playGame = getIntent();
		playGame.getAction();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		city.onPause();
	}
	
}
