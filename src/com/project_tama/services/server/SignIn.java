package com.project_tama.services.server;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.project_tama.activities.city.CityActivity;
import com.project_tama.activities.view.AccountActivity;
import com.project_tama.services.HttpClientSingleton;

public class SignIn extends AsyncTask<String, String, String> {
	
    private ProgressDialog progressDialog;
    private AccountActivity activity;
    
    public SignIn(AccountActivity activity) {
    	this.activity = activity;
	}
	
	@Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(activity, "", "Autenticando...");
    }

	@Override
	protected String doInBackground(String... params) {
		String email = params[0];
		String password = params[1];
		
		HttpGet url = new HttpGet("http://secure-oasis-7521.herokuapp.com/me?email="+email+"&password="+password);
		try {

			HttpResponse response = HttpClientSingleton.getHttpClientInstace().execute(url);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
	        response.getEntity().writeTo(out);
	        out.close();
			return out.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		progressDialog.dismiss();
		SharedPreferences login = activity.getSharedPreferences("login_prefs", AccountActivity.MODE_PRIVATE);
		
		if (result.equals("0")) {
			Toast.makeText(activity, "Email ou password incorretos!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", false).commit();
		} else {
			Toast.makeText(activity, "Login efetuado, divirta-se!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", true).commit();
			Intent in = new Intent(activity, CityActivity.class);
			activity.startActivity(in);
		}
		
		
	}

}
