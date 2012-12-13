package com.project_tama.activities.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.services.music.BackgroundSound;

public class SettingsActivity extends AbstractActivity {

	private static final String SETTINGS_PREFS = "gameSettings";
	private boolean sound, vibrate;
	private Button btn_sound, btn_vibrate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		Intent editSettings = getIntent();
		editSettings.getAction();

		btn_sound = (Button) findViewById(R.id.sound_button);
		btn_vibrate = (Button) findViewById(R.id.vibrate_button);

		updateButtons();
	}

	public void onClick(View view) {
		SharedPreferences settings = getSharedPreferences(SETTINGS_PREFS, MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		switch (view.getId()) {
		case R.id.sound_button:
			editor.putBoolean("sound", !sound).commit();
			notifyMusicService(settings.getBoolean("sound", true));
			break;
		case R.id.vibrate_button:
			editor.putBoolean("vibrate", !vibrate).commit();
			if (settings.getBoolean("vibrate", true)) {
				Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
				v.vibrate(300);	
			}
			break;
		default:
			break;
		}

		updateButtons();
	}

	private void notifyMusicService(boolean activate) {
		Intent music = new Intent(this, BackgroundSound.class);
		if (activate) {
			startService(music);
		} else {
			stopService(music);
		}
	}

	private void updateButtons() {
		SharedPreferences settings = getSharedPreferences(SETTINGS_PREFS, MODE_PRIVATE);

		sound = settings.getBoolean("sound", true);
		vibrate = settings.getBoolean("vibrate", true);

		btn_sound.setText(sound ? "Sound OFF" : "Sound ON");
		btn_vibrate.setText(vibrate ? "Vibrate OFF" : "Vibrate ON");

		Drawable sound_image = sound ?
				getResources().getDrawable(R.drawable.volume_off) : getResources().getDrawable(R.drawable.volume_on);
				btn_sound.setCompoundDrawablesWithIntrinsicBounds(null, null, sound_image, null);

				Drawable vibrate_image = vibrate ?
						getResources().getDrawable(R.drawable.disable) : getResources().getDrawable(R.drawable.enable);
						btn_vibrate.setCompoundDrawablesWithIntrinsicBounds(null, null, vibrate_image, null);
	}
}