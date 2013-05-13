package com.yz.weightrecord;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etWeight;
	private EditText etLightWeight;
	private Button btnOk;
	private ProgressDialog mDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etWeight = (EditText) findViewById(R.id.et_weight);
		etLightWeight = (EditText) findViewById(R.id.et_light_weight);
		btnOk = (Button) findViewById(R.id.btn_commit);
		
		btnOk.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(View v) {

				new AsyncTask(){

					
					
					@Override
					protected void onPreExecute() {
						super.onPreExecute();
						if(mDialog == null){
							mDialog = new ProgressDialog(new ContextThemeWrapper(MainActivity.this, android.R.style.Theme_Holo_Dialog));
						}
						if(!mDialog.isShowing()){
							mDialog.show();
						}
					}

					@Override
					protected Object doInBackground(Object... params) {
						Api.add(etWeight.getText() + "", etLightWeight.getText()+"");
						return null;
					}

					@Override
					protected void onPostExecute(Object result) {
						super.onPostExecute(result);
						Toast.makeText(getApplication(), "添加完成", 1000).show();
						mDialog.dismiss();
					}
				}.execute();				
			}
		});

	}

	
	@Override
	protected void onResume() {
		super.onResume();
//		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//		imm.showSoftInput(etWeight, InputMethodManager.SHOW_FORCED);
//		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//		etWeight.requestFocus();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
