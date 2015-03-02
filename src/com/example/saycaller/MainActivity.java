	package com.example.saycaller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnCheck(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void addListenerOnCheck() {
		final CheckBox chk;
	chk = (CheckBox) findViewById(R.id.chk1);	
		chk.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (chk.isChecked()) {
						startService(); 
					}
					else {
						stopService();
					}
						
				}
		} );	
		
	}
	
	private void startService() {
		Intent mSIntent = new Intent(this, SayCaller.class);
				this.startService(mSIntent);
	}

	private void stopService() {
		Intent msIntent = new Intent(this, SayCaller.class);
		this.stopService(msIntent);
		}
	
	
}
