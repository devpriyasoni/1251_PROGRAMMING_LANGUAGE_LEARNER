package net.com.example.pllv1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class quizselect extends Activity implements OnClickListener 
{
	Button btnc,btncplus,btnjava;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     fscreen();
	     setContentView(R.layout.quizselect);
	    
	     
	     // Get The Refference Of Buttons
	     btnc=(Button)findViewById(R.id.qbtnc);
	     btncplus=(Button)findViewById(R.id.qbtncplus);
	     btnjava=(Button)findViewById(R.id.qbtnjava);
	     btnc.setOnClickListener(this);
	     btncplus.setOnClickListener(this);
	     btnjava.setOnClickListener(this);
	     ActionBar actionBar = getActionBar();
	     actionBar.setDisplayHomeAsUpEnabled(true);
	    
	}
	
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {       
        startActivity(new Intent(quizselect.this,startmenu.class)); 
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.qbtnc:
		Intent se=new Intent("net.com.example.pllv1.QUIZ");
		startActivity(se);



			
			break;
		case R.id.qbtncplus:
			
			
		Intent seq=new Intent("net.com.example.pllv1.QUIZCPP");
		startActivity(seq);


			
			
			
			break;
			
		case R.id.qbtnjava:
			
			
		Intent sew=new Intent("net.com.example.pllv1.QUIZJAVA");
		startActivity(sew);
			
			
			
			break;


		}
		
	}

}