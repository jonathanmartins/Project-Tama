package com.project_tama.activities.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;

public class AccountActivity extends AbstractActivity {

	private EditText pass_login, email_login, email_register;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);

		Intent acc = getIntent();
		acc.getAction();

		email_login = (EditText) findViewById(R.id.email_sign_in);
		pass_login = (EditText) findViewById(R.id.pass_sign_in);
		email_register = (EditText) findViewById(R.id.email_sign_up);

	}

	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.button_sign_in:
			//salvar o login
			email_login.setText("");
			email_login.clearFocus();
			pass_login.setText("");
			pass_login.clearFocus();
			break;
		case R.id.button_sign_up:
			//avisar que sera enviado um email e redirecionar pra algum canto
			String newUser = email_register.getText().toString();
			signUp(newUser);
			email_register.setText("");
			email_register.clearFocus();
			break;
		default:
			break;
		}
	}

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