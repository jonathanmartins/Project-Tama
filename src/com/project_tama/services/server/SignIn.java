package com.project_tama.services.server;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.project_tama.activities.view.AccountActivity;
import com.project_tama.services.HttpClientSingleton;

public class SignIn extends AsyncTask<String, String, String> {
	
    private ProgressDialog progressDialog;
    private AccountActivity activity;
    private String email;
    private String password;
    
    public SignIn(AccountActivity activity) {
    	this.activity = activity;
	}
	
	@Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(activity, "", "Autenticando...");
    }

	@Override
	protected String doInBackground(String... params) {
		email = params[0];
		password = params[1];
		
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
		
		if (result.equals("0")) {
			Toast.makeText(activity, "Email ou password incorretos!", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(activity, "Login efetuado", Toast.LENGTH_LONG).show();
			GetTamamon getTama = new GetTamamon(activity);
			getTama.execute(email, password);
		}
	}

}
