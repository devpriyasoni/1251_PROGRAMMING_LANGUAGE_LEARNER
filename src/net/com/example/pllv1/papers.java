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

public class papers extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.papers);
		Button micro,google,amazon;
		
		
		
		micro=(Button)findViewById(R.id.microsoft);
		google=(Button)findViewById(R.id.google);
		amazon=(Button)findViewById(R.id.amazon);
		micro.setOnClickListener(this);
		google.setOnClickListener(this);
		amazon.setOnClickListener(this);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
			 
		switch(v.getId())
		{
			case R.id.microsoft :
				
				SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				boolean anim=getprefs.getBoolean("at", true);
				SharedPreferences bookmark=getSharedPreferences("az",0);								
				 SharedPreferences.Editor editor=bookmark.edit();
				 editor.putString("comp", "microsoft");				 
				 editor.commit();


				if(anim==true)
				{
					
					animationxy(papers.this,paperset.class);

				}
				else
				{
			Intent se=new Intent("net.com.example.pllv1.PAPERSET");
			startActivity(se);
				}

				
				break;
			
			case R.id.google  :

				SharedPreferences getprefs1=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				boolean anim1=getprefs1.getBoolean("at", true);
				SharedPreferences bookmark1=getSharedPreferences("az",0);								
				 SharedPreferences.Editor editor1=bookmark1.edit();
				 editor1.putString("comp", "google");				 
				 editor1.commit();

				if(anim1==true)
				{
					
					animationxy(papers.this,paperset.class);

				}
				else
				{
			Intent se=new Intent("net.com.example.pllv1.PAPERSET");
			startActivity(se);
				}


			
			break;
			
			case R.id.amazon :
				
				
				SharedPreferences getprefs2=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				boolean anim2=getprefs2.getBoolean("at", true);
				SharedPreferences bookmark2=getSharedPreferences("az",0);								
				 SharedPreferences.Editor editor2=bookmark2.edit();
				 editor2.putString("comp", "amazon");				 
				 editor2.commit();

				if(anim2==true)
				{
					
					animationxy(papers.this,paperset.class);

				}
				else
				{
			Intent se=new Intent("net.com.example.pllv1.PAPERSET");
			startActivity(se);
				}


			
				
				break;
		}
		
	}
	

	private void animationxy(Context s, Class<?> f) {
		// TODO Auto-generated method stub
		
		SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String no=getprefs.getString("aselect", "t1");
		if(no.contentEquals("t1"))
		{
	Intent slideactivity = new Intent(s, f);
	 
	Bundle bndlanimation =
			ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
	        startActivity(slideactivity, bndlanimation);
		}
		
		if(no.contentEquals("t2"))
		{
	Intent slideactivity = new Intent(s, f);
	 
	Bundle bndlanimation =
			ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation3,R.anim.animation4).toBundle();
	        startActivity(slideactivity, bndlanimation);
		}
		
		
		if(no.contentEquals("t3"))
		{
	Intent slideactivity = new Intent(s, f);
	 
	Bundle bndlanimation =
			ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.q2,R.anim.q1).toBundle();
	        startActivity(slideactivity, bndlanimation);
		}
		
		if(no.contentEquals("t4"))
		{
	Intent slideactivity = new Intent(s, f);
	 
	Bundle bndlanimation =
			ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.q1).toBundle();
	        startActivity(slideactivity, bndlanimation);
		}

		
	}
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.main, menu);
		return true;
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



	@Override
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
			//finish();
			System.exit(0);
		default:         startActivity(new Intent(papers.this,startmenu.class));
		}
		return false;
		

	}

	}
	


