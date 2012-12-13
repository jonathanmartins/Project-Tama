package com.project_tama.services.server;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class SignUp extends AsyncTask<String, Integer, Integer> {

	@Override
	protected Integer doInBackground(String... params) {
		String email = params[0];
		HttpClient client = new DefaultHttpClient();
		HttpPost url = new HttpPost("http://secure-oasis-7521.herokuapp.com/invite_me/"+email);
		try {
			client.execute(url);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
