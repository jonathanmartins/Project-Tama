package com.project_tama.activities.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.activities.view.MainMenuActivity;

public class VideoActivity extends AbstractActivity{
	
	private VideoView mVideoView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.homevideo);

		String path="android.resource://"+getPackageName()+"/"+R.raw.opening;
		mVideoView = (VideoView) findViewById(R.id.video);
		mVideoView.setVideoPath(path);
		mVideoView.start();
		mVideoView.requestFocus();

		mVideoView.setOnCompletionListener(new OnCompletionListener() {         
			public void onCompletion(MediaPlayer arg0) {
				callMainMenu();
			}
		});
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
