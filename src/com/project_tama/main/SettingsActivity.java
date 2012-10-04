package com.project_tama.main;

import com.project_tama.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SettingsActivity extends Activity {
	public static final String SETTINGS_PREFS = "gameSettings";
	private boolean[] settingsHolder = new boolean[2];
	private Button btn_sound, btn_vibrate;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent editSettings = getIntent();
		editSettings.getAction();
		
		/* Make this activity fullscreen! */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_settings);
		
		btn_sound = (Button) findViewById(R.id.sound_button);
		btn_vibrate = (Button) findViewById(R.id.vibrate_button);
		
		getSettings();
		setText();
	}
	
	public void getSettings(){
		SharedPreferences settings = getSharedPreferences(SETTINGS_PREFS, MODE_PRIVATE);

		settingsHolder[0] = settings.getBoolean("sound", true);
		settingsHolder[1] = settings.getBoolean("vibrate", true);
	}
	
	public void setText(){
		btn_sound.setText(settingsHolder[0] ? "Sound OFF" : "Sound ON");
		btn_vibrate.setText(settingsHolder[1] ? "Vibrate OFF" : "Vibrate ON");
		
		Drawable sound_image = null;
		Drawable vibrate_image = null;

		if(settingsHolder[0]){
			sound_image = getResources().getDrawable(R.drawable.volume_off);
			btn_sound.setCompoundDrawablesWithIntrinsicBounds(null, null, sound_image, null);
		}else{
			sound_image = getResources().getDrawable(R.drawable.volume_on);
			btn_sound.setCompoundDrawablesWithIntrinsicBounds(null, null, sound_image, null);
		}

		if(settingsHolder[1]){
			vibrate_image = getResources().getDrawable(R.drawable.disable);
			btn_vibrate.setCompoundDrawablesWithIntrinsicBounds(null, null, vibrate_image, null);
		}else{
			vibrate_image = getResources().getDrawable(R.drawable.enable);
			btn_vibrate.setCompoundDrawablesWithIntrinsicBounds(null, null, vibrate_image, null);
		}
	}
	
	public void onClick(View view){
		SharedPreferences settings = getSharedPreferences(SETTINGS_PREFS, MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		switch (view.getId()) {
		case R.id.sound_button:
			editor.putBoolean("sound", !settingsHolder[0]);
			break;
		case R.id.vibrate_button:
			editor.putBoolean("vibrate", !settingsHolder[1]);
			break;
		default:
			break;
		}
		
		editor.commit();
		
		getSettings();
		setText();
	}
}