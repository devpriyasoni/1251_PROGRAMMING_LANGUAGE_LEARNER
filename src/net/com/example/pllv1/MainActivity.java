package net.com.example.pllv1;




import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSharedPreferenceChangeListener{
MediaPlayer Oursong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.activity_main);
		Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound);
//		Oursong.start();
		SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getprefs.getBoolean("music", true);
		//Oursong=MediaPlayer.create(Secondclass.this, R.raw.sound);
		String no=getprefs.getString("mselect", "c1");
		
		
		//onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
		
		
		
		if(no.contentEquals("c1"))
		{
		Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound);
	//	Oursong.start();
		}
		else if(no.contentEquals("c2"))
		{
			Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound1);
	//		Oursong.start();

		}

		else if(no.contentEquals("c3"))
		{
			Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound2);
	//		Oursong.start();

		}

		else if(no.contentEquals("c4"))
		{
			Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound4);
	//		Oursong.start();

		}

		else if(no.contentEquals("c5"))
		{
			Oursong=MediaPlayer.create(MainActivity.this, R.raw.sound4);
	//		Oursong.start();

		}

		if(music==true)
		{
		Oursong.start();
		}
		
	


Thread timer=new Thread() {

	public void run(){
		try{
			sleep(2500);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			Intent sew=new Intent("net.com.example.pllv1.FIRSTLOGIN");
			startActivity(sew);

		}
	}
}; 
timer.start();

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
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	finish();
	Oursong.release();
}

@Override
public void onSharedPreferenceChanged(SharedPreferences preffs, String mselect) {
	// TODO Auto-generated method stub
	

	
	
}

}


