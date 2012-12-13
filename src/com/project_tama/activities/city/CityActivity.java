package com.project_tama.activities.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;

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
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.new_battle:
			newBattle();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void newBattle() {
		
	}
}
