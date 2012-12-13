package com.project_tama.services.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

import com.project_tama.services.HttpClientSingleton;

public class DownloadTama extends AsyncTask<String, Integer, String> {

	@Override
	protected String doInBackground(String... params) {
		String email = params[0];
		String password = params[1];
		
		HttpPost url = new HttpPost("http://secure-oasis-7521.herokuapp.com/my_tama");
		
		try {
			List<NameValuePair> getParams = new ArrayList<NameValuePair>(2);
			
	        getParams.add(new BasicNameValuePair("email", email));
	        getParams.add(new BasicNameValuePair("password", password));
	        
	        url.setEntity(new UrlEncodedFormEntity(getParams));
	        
			HttpResponse response =  HttpClientSingleton.getHttpClientInstace().execute(url);
			
			return response.getAllHeaders().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
