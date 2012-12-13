package com.project_tama.services.server;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.project_tama.activities.city.CityActivity;
import com.project_tama.activities.view.AccountActivity;
import com.project_tama.services.HttpClientSingleton;

public class GetTamamon extends AsyncTask<String, String, JSONObject>{
	
    private ProgressDialog progressDialog;
    private AccountActivity activity;
	
    public GetTamamon(AccountActivity activity) {
    	this.activity = activity;
	}

	@Override
	protected JSONObject doInBackground(String... params) {
		String email = params[0];
		String password = params[1];
		
		HttpGet url = new HttpGet("http://secure-oasis-7521.herokuapp.com/tama?email="+email+"&password="+password);
		try {

			HttpResponse response = HttpClientSingleton.getHttpClientInstace().execute(url);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
	        response.getEntity().writeTo(out);
	        out.close();
	        JSONObject json = new JSONObject(out.toString());
	        throw new Exception(json.toString());
			//return json;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(activity, "", "Recuperando o seu tamamon...");
    }
	
	@Override
	protected void onPostExecute(JSONObject result) {
		super.onPostExecute(result);
		SharedPreferences login = activity.getSharedPreferences("login_prefs", AccountActivity.MODE_PRIVATE);
		
		if (result.equals("0")) {
			Toast.makeText(activity, "N�o foi poss�vel recuperar o seu tamamon!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", false).commit();
		} else {
			Toast.makeText(activity, "Tamamon recuperado, divirta-se!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", true).commit();
		}
		
		progressDialog.dismiss();
		Intent in = new Intent(activity, CityActivity.class);
		activity.startActivity(in);
	}

}
