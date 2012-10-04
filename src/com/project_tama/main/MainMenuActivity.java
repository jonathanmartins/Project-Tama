package com.project_tama.main;


import com.project_tama.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainMenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main_menu);
	}

	public void startGame(View view){
		Intent startGame = new Intent(view.getContext(), GameActivity.class);
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
