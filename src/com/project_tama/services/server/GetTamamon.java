package com.project_tama.services.server;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import com.project_tama.activities.city.CityActivity;
import com.project_tama.activities.view.AccountActivity;
import com.project_tama.database.DatabaseHandler;
import com.project_tama.services.HttpClientSingleton;
import com.project_tama.tamamon.Tamamon;

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
	        //throw new Exception(json.toString());
			return json;

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
		SharedPreferences gameSettings = activity.getSharedPreferences("gameSettings", AccountActivity.MODE_PRIVATE);
		
		if (result.equals("0")) {
			Toast.makeText(activity, "Não foi possível recuperar o seu tamamon!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", false).commit();
		} else {
			Toast.makeText(activity, "Tamamon recuperado, divirta-se!", Toast.LENGTH_LONG).show();
			login.edit().putBoolean("ready", true).commit();
			
			DatabaseHandler db = new DatabaseHandler(activity);
			try {
				if (db.getAllTamamons().size() == 0) {
					Tamamon tama = new Tamamon(1, new Random().nextInt(9), "tamamon", 20, 20);
					db.addTamamon(tama);
				} else {
					Tamamon tama = db.getTamamon(1);
					tama.setEnergy(((Integer) result.get("energy")).intValue());
					tama.setLife(((Integer) result.get("life")).intValue());
					db.updateTamamon(tama);	
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}

			// Reading all tamamons
	        Log.d("Reading: ", "Reading all contacts..");
	        List<Tamamon> tamas = db.getAllTamamons();       
	 
	        for (Tamamon tm : tamas) {
	            String log = "Id: "+tm.getId()+", Name: " + tm.getName() + ", Life: " + tm.getLife();
	            // Writing Tamamons to log
	            Log.d("Name: ", log);
	        }
	        
	        db.close();
		}
		
		progressDialog.dismiss();
		
		if (gameSettings.getBoolean("vibrate", true)) {
			Vibrator v = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
			v.vibrate(300);
		}

		Intent in = new Intent(activity, CityActivity.class);
		activity.startActivity(in);
	}

}
