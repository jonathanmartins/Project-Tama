package com.project_tama.services.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.project_tama.R;

public class BackgroundSound extends Service {

	private MediaPlayer player;
	public static boolean isPlaying;

	@Override
	public void onCreate() {
		super.onCreate();
		player = MediaPlayer.create(this, R.raw.mainmenu);
		player.setLooping(true);
		player.setVolume(100,100);
		isPlaying = true;
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