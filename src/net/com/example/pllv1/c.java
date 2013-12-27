package net.com.example.pllv1;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class c extends ListActivity {

	String options[]={ "INTRO", "First example", "Let's Compute", " Loops", "Symbolic Constants", "Conditionals", "Pointers",
			"Arrays", "Character Arrays", "I/O Capabilities", "Functions", " Command-line arguments", "Graphical Interfaces: Dialog Boxes" };
		
		//{"INTRO","CONSTRUCTOR","FUNCTIONS","EXCEPTIONHANDLE","ARRAYS"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setListAdapter(new ArrayAdapter<String>(c.this,android.R.layout.simple_dropdown_item_1line,options));
	     ActionBar actionBar1 = getActionBar();
	     actionBar1.setDisplayHomeAsUpEnabled(true);

	}
	
	
	


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese=options[position];
		
		Bundle basket=new Bundle();
		basket.putString("a1", cheese);
		Intent a=new Intent(c.this,langreader.class);
		a.putExtras(basket);
		startActivity(a);	
	/*	Intent myIntent=new Intent("net.com.example.pll.LANGREADER") ;
		startActivity(myIntent); */

	}
	
	
	void fscreen() {
		// TODO Auto-generated method stub
	
	SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	boolean screen=getprefs.getBoolean("fscreen", false);
	
	if(screen==true)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}

		
	}

	
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.main, menu);
		return true;
	}






	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//return super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case (R.id.about):
		Intent i=new Intent("net.com.example.pllv1.ABOUTUS");
		startActivity(i);
		break;
		
		case (R.id.pref):
			Intent s=new Intent("net.com.example.pllv1.PREFFS");
			startActivity(s);
			
			break;
		case (R.id.exit):
			finish();
		default:        startActivity(new Intent(c.this,language.class));
		}
		return false;
	}


}
