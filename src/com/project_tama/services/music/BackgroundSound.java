package com.project_tama.services.music;

import com.project_tama.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSound extends Service {
	
	private MediaPlayer player;
	
	@Override
	public void onCreate() {
		super.onCreate();
		player = MediaPlayer.create(this, R.raw.mainmenu);
		player.setLooping(true);
		player.setVolume(100,100);
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) {
		player.start();
		return 1;
	}

	@Override
	public void onDestroy() { 
		player.stop();
		player.release();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}