package net.com.example.pllv1;


import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class mainmenu extends ListActivity {

	String Classes[]={"C","C++","JAVA","QUIZ","DISPLAYTABLE","FIRSTLOGIN","SIGNUP"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(mainmenu.this,android.R.layout.simple_dropdown_item_1line,Classes));
	}
	
	
	


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese=Classes[position];
	//	try{
			
		Intent myIntent=new Intent("net.com.example.pll." + cheese);
		startActivity(myIntent);
	//	}
	/*	catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}



public boolean onCreateOptionsMenu(android.view.Menu menu) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu);
	MenuInflater blowup=getMenuInflater();
	blowup.inflate(R.menu.main, menu);
	return true;
}





@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	//return super.onOptionsItemSelected(item);
	switch(item.getItemId())
	{
	case (R.id.about):
	Intent i=new Intent("net.com.example.pll.ABOUTUS");
	startActivity(i);
	break;
	
	case (R.id.pref):
		Intent s=new Intent("net.com.example.pll.PREFFS");
		startActivity(s);
		
		break;
	case (R.id.exit):
		//finish();
		System.exit(0);
	}
	return false;
	

}


}


