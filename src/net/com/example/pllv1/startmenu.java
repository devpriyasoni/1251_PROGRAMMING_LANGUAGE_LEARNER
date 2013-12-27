package net.com.example.pllv1;

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
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
	
	public class startmenu extends Activity implements OnClickListener 
	{
		Button paper,quiz,notes;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			fscreen();
			
			setContentView(R.layout.mainmenu);
			paper=(Button)findViewById(R.id.paper);
			quiz=(Button)findViewById(R.id.quiz);
			notes=(Button)findViewById(R.id.notes);
			paper.setOnClickListener(this);
			quiz.setOnClickListener(this);
			notes.setOnClickListener(this);
			
			
			
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 
				 
			switch(v.getId())
			{
				case R.id.quiz :
					


				Intent se=new Intent("net.com.example.pllv1.QUIZSELECT");
				startActivity(se);
					


					
					break;
				
				case R.id.paper  :
	
					SharedPreferences getprefsa=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
					boolean anima=getprefsa.getBoolean("at", true);

				Intent see=new Intent("net.com.example.pllv1.PAPERS");
				startActivity(see);



				
					
					break;
																					
				
				
				
				case R.id.notes :
					
					
					SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
					boolean anim=getprefs.getBoolean("at", true);


				Intent seq=new Intent("net.com.example.pllv1.LANGUAGE");
				startActivity(seq);



				
					
					break;
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
			}
			return false;
			

		}

		
		

	}
