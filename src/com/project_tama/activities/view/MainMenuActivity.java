package com.project_tama.activities.view;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.activities.city.CityActivity;
import com.project_tama.services.music.BackgroundSound;

public class MainMenuActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		SharedPreferences settings = getSharedPreferences("gameSettings", MODE_PRIVATE);
		if (settings.getBoolean("sound", true)) {
			settings.edit().putBoolean("sound", true).commit();
			
			Intent music = new Intent(this, BackgroundSound.class);
			startService(music);
		}
	}

	public void onClick(View view){
		switch (view.getId()) {
		case R.id.start_game:
			SharedPreferences ready = getSharedPreferences("login_prefs", MODE_PRIVATE);

			if (ready.getBoolean("ready", false)) {
				Intent startGame = new Intent(view.getContext(), CityActivity.class);
				startActivity(startGame);	
			} else {
				Intent signIn = new Intent(view.getContext(), AccountActivity.class);
				startActivity(signIn);	
			}
			
			break;
		case R.id.settings:
			Intent settings = new Intent(view.getContext(), SettingsActivity.class);
			startActivity(settings);
			break;
		case R.id.account_button:
			Intent account = new Intent(view.getContext(), AccountActivity.class);
			startActivity(account);
		default:
			break;
		}
	}
}
