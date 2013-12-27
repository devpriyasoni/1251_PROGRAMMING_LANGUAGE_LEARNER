package net.com.example.pllv1;

    import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.Toast;

	public class language extends Activity implements OnClickListener 
	{
		Button btnc,btncplus,btnjava;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) 
		{
		     super.onCreate(savedInstanceState);
		     fscreen();
		     setContentView(R.layout.language);
		    
		     
		     // Get The Refference Of Buttons
		     btnc=(Button)findViewById(R.id.btnc);
		     btncplus=(Button)findViewById(R.id.btncplus);
		     btnjava=(Button)findViewById(R.id.btnjava);
		     btnc.setOnClickListener(this);
		     btncplus.setOnClickListener(this);
		     btnjava.setOnClickListener(this);

		    
		}
		
		
		@Override
	    public boolean onOptionsItemSelected(MenuItem menuItem)
	    {       
	        startActivity(new Intent(language.this,startmenu.class)); 
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
			case R.id.btnc:
			/*	Intent slideactivity = new Intent(language.this, c.class);
				 
				Bundle bndlanimation =
						ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
				        startActivity(slideactivity, bndlanimation);*/
			Intent se=new Intent("net.com.example.pllv1.C");
			startActivity(se);
				


				
				break;
			case R.id.btncplus:
				
				
			Intent seq=new Intent("net.com.example.pllv1.CPP");
			startActivity(seq);


				
				
				
				break;
				
			case R.id.btnjava:
				
				
			Intent sew=new Intent("net.com.example.pllv1.JAVA");
			startActivity(sew);



				
				
				
				break;


			}
			
		}

     }