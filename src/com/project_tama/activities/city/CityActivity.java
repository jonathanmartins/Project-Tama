package com.project_tama.activities.city;

import android.content.Intent;
import android.os.Bundle;

import com.project_tama.activities.AbstractActivity;

public class CityActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new City(this));

		Intent playGame = getIntent();
		playGame.getAction();

	}
}
