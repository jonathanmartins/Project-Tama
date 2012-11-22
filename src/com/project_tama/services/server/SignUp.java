package com.project_tama.services.server;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class SignUp extends AsyncTask<String, String, String> {

	@Override
	protected String doInBackground(String... params) {
		String email = params[0];
		HttpClient client = new DefaultHttpClient();
		HttpPost url = new HttpPost("http://secure-oasis-7521.herokuapp.com/invite_me/"+email);
		try {
			HttpResponse response = client.execute(url);
			return response.getEntity().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
