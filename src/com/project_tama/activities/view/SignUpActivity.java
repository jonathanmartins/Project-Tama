package com.project_tama.activities.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.project_tama.services.AbstractActivity;

public class SignUpActivity extends AbstractActivity {
	
	private void signUp(String email) {
		HttpPost url = new HttpPost("http://warm-tundra-7090.herokuapp.com/home/sign_up");
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>(1);
			params.add(new BasicNameValuePair("email", email));
			url.setEntity(new UrlEncodedFormEntity(params));
			
			
		} catch (Exception e) {
			//TO-DO
		}		
	}

}
