package com.project_tama.activities.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.project_tama.R;
import com.project_tama.activities.AbstractActivity;
import com.project_tama.services.server.SignIn;
import com.project_tama.services.server.SignUp;

public class AccountActivity extends AbstractActivity {

	public static final String LOGIN_PREFS = "login_prefs";
	public static final String READY = "ready";
	
	private EditText pass_login, email_login, email_register;
	private Context context;
	private CheckBox remember;
	
	private boolean saveLogin;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);

		Intent acc = getIntent();
		acc.getAction();

		email_login = (EditText) findViewById(R.id.email_sign_in);
		pass_login = (EditText) findViewById(R.id.pass_sign_in);
		email_register = (EditText) findViewById(R.id.email_sign_up);
		remember = (CheckBox) findViewById(R.id.remember_login);

		context = getApplicationContext();
	}

	@Override
	protected void onResume() {
		//Recupera os dados em login
		super.onResume();
		SharedPreferences login = getSharedPreferences(LOGIN_PREFS, MODE_PRIVATE);

		saveLogin = login.getBoolean("saveLogin", false);
		if(saveLogin){
			email_login.setText(login.getString("email", ""));
			pass_login.setText(login.getString("password", ""));
			remember.setChecked(true);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		saveUser();
	}

	private String[] saveUser(){
		//Salva email e password se requisitado
		SharedPreferences login = getSharedPreferences(LOGIN_PREFS, MODE_PRIVATE);
		SharedPreferences.Editor editor = login.edit();

		if(remember.isChecked()){
			editor.putString("email", email_login.getText().toString());
			editor.putString("password", pass_login.getText().toString());
			editor.putBoolean("saveLogin", true);
		}else{
			editor.clear();
		}
		editor.commit();

		String[] result = new String[2];

		result[0] = email_login.getText().toString();
		result[1] = pass_login.getText().toString();

		return result;
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_sign_in:
			String[] s = saveUser();
			signIn(s[0], s[1]); 
			break;
		case R.id.button_sign_up:
			CharSequence text = "Por favor, verifique seu email! Precisamos de confirmacao.";
			Toast.makeText(context, text, Toast.LENGTH_LONG).show();

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
		SignUp signUp = new SignUp();
		signUp.execute(email);
	}

	private void signIn(String email, String password) {
		SignIn signIn = new SignIn(this);
		signIn.execute(email, password);
	}

}