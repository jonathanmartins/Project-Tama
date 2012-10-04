package com.project_tama.activities.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.VideoView;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.activities.view.MainMenuActivity;

public class VideoActivity extends AbstractActivity{
	private String current;
	private String path ;
	private VideoView mVideoView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homevideo);

		path="android.resource://"+getPackageName()+"/"+R.raw.opening;
		mVideoView = (VideoView) findViewById(R.id.video);
		
		if (path == null || path.length() == 0) {
			Toast.makeText(VideoActivity.this, "File URL/path is empty", Toast.LENGTH_LONG).show();
		} else {
			// If the path has not changed, just start the media player
			if (path.equals(current) && mVideoView != null) {
				mVideoView.start();
				mVideoView.requestFocus();
				return;
			}
			current = path;
			mVideoView.setVideoPath(path);
			mVideoView.start();
			mVideoView.requestFocus();
		}
		
		mVideoView.setOnCompletionListener(new OnCompletionListener() {         
			public void onCompletion(MediaPlayer arg0) {
				Intent in = new Intent(VideoActivity.this,MainMenuActivity.class);
				startActivity(in);
				finish();
			}
		});
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Intent in = new Intent(VideoActivity.this,MainMenuActivity.class);
		startActivity(in);
		finish();
		return super.onTouchEvent(event);
	}

}
