package net.com.example.pllv1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class paperset extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.set);
		Button set1, set2, set3;
		// SharedPreferences bookmark;


		set1 = (Button) findViewById(R.id.pset1);
		set2 = (Button) findViewById(R.id.pset2);
		set3 = (Button) findViewById(R.id.pset3);
		set1.setOnClickListener(this);
		set2.setOnClickListener(this);
		set3.setOnClickListener(this);
		


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.pset1:

			SharedPreferences getprefs = PreferenceManager
					.getDefaultSharedPreferences(getBaseContext());
			boolean anim = getprefs.getBoolean("at", true);
			SharedPreferences bookmark = getSharedPreferences("az", 0);
			String bm1 = bookmark.getString("comp", "");
			SharedPreferences.Editor editor = bookmark.edit();
			editor.putString("sets", "set1");
			// editor.putString("pass",pass);
			editor.commit();

			if (bm1.equals("google")) {

					Intent se = new Intent("net.com.example.pllv1.GOOGLE");
					startActivity(se);
				

			}

			if (bm1.equals("amazon")) {

				
					Intent se = new Intent("net.com.example.pllv1.AMAZON");
					startActivity(se);
				

			}

			if (bm1.equals("microsoft")) {

				 
					Intent se = new Intent("net.com.example.pllv1.MICROSOFT");
					startActivity(se);
				

			}

			break;

		case R.id.pset2:

			SharedPreferences getprefs1 = PreferenceManager
			.getDefaultSharedPreferences(getBaseContext());
	boolean anim1 = getprefs1.getBoolean("at", true);
	SharedPreferences bookmark1 = getSharedPreferences("az", 0);
	String bm11 = bookmark1.getString("comp", "");
	SharedPreferences.Editor editor1 = bookmark1.edit();
	editor1.putString("sets", "set2");
	// editor.putString("pass",pass);
	editor1.commit();

	if (bm11.equals("google")) {

			Intent se = new Intent("net.com.example.pllv1.GOOGLE");
			startActivity(se);
		

	}

	if (bm11.equals("amazon")) {

			Intent se = new Intent("net.com.example.pllv1.AMAZON");
			startActivity(se);
		

	}

	if (bm11.equals("microsoft")) {

			Intent se = new Intent("net.com.example.pllv1.MICROSOFT");
			startActivity(se);
		

	}


			break;

		case R.id.pset3:


			SharedPreferences getprefs11 = PreferenceManager
			.getDefaultSharedPreferences(getBaseContext());
	boolean anim11 = getprefs11.getBoolean("at", true);
	SharedPreferences bookmark11 = getSharedPreferences("az", 0);
	String bm111 = bookmark11.getString("comp", "");
	SharedPreferences.Editor editor11 = bookmark11.edit();
	editor11.putString("sets", "set3");
	// editor.putString("pass",pass);
	editor11.commit();

	if (bm111.equals("google")) {

			Intent se = new Intent("net.com.example.pllv1.GOOGLE");
			startActivity(se);
		

	}

	if (bm111.equals("amazon")) {

			Intent se = new Intent("net.com.example.pllv1.AMAZON");
			startActivity(se);
		

	}

	if (bm111.equals("microsoft")) {

			Intent se = new Intent("net.com.example.pllv1.MICROSOFT");
			startActivity(se);
		

	}


			break;
		}

	}


	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.main, menu);
		return true;
	}

	void fscreen() {
		// TODO Auto-generated method stub

		SharedPreferences getprefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean screen = getprefs.getBoolean("fscreen", false);

		if (screen == true) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);

		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// return super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case (R.id.about):
			Intent i = new Intent("net.com.example.pllv1.ABOUTUS");
			startActivity(i);
			break;

		case (R.id.pref):
			Intent s = new Intent("net.com.example.pllv1.PREFFS");
			startActivity(s);

			break;
		case (R.id.exit):
			// finish();
			System.exit(0);
		default:         startActivity(new Intent(paperset.this,papers.class));
		}
		return false;

	}

}
