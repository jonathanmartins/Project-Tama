package com.project_tama.activities.city;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.database.DatabaseHandler;
import com.project_tama.tamamon.Tamamon;

public class CityActivity extends AbstractActivity {
	
	private City city;
	private Tamamon tama;
	private DatabaseHandler db;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		city = new City(this);
		setContentView(city);

		Intent playGame = getIntent();
		playGame.getAction();
		
		/*
		db = new DatabaseHandler(this);
        
		tama = new Tamamon("Tamamon", 19, 19);
        db.addTamamon(tama);
		db.updateTamamon(tama);
		tama = db.getTamamon(1);
		
		// Reading all tamamons
        Log.d("Reading: ", "Reading all contacts..");
        List<Tamamon> tamas = db.getAllTamamons();       
 
        for (Tamamon tm : tamas) {
            String log = "Id: "+tm.getId()+", Name: " + tm.getName() + ", Life: " + tm.getLife();
            // Writing Tamamons to log
            Log.d("Name: ", log);
        }
        */
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
