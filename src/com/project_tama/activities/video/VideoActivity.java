package com.project_tama.activities.video;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.project_tama.activities.AbstractActivity;
import com.project_tama.activities.view.MainMenuActivity;

public class VideoActivity extends AbstractActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www..com/watch?v=rpDCLkqWjLw")));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		callMainMenu();
		return super.onTouchEvent(event);
	}

	private void callMainMenu() {
		Intent in = new Intent(VideoActivity.this, MainMenuActivity.class);
		startActivity(in);
		finish();
	}
}
