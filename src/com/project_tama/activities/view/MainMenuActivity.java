package com.project_tama.activities.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.activities.city.CityActivity;

public class MainMenuActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

	public void startGame(View view){
		Intent startGame = new Intent(view.getContext(), CityActivity.class);
		startActivity(startGame);
	}

	public void editSettings(View view){
		//Button editSettings = (Button) findViewById(R.id.settings);

		Intent settings = new Intent(view.getContext(), SettingsActivity.class);
		startActivity(settings);

		/*editSettings.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent settings = new Intent(v.getContext(), SettingsActivity.class);
				startActivity(settings);
			}
		});
		 */
	}
}
