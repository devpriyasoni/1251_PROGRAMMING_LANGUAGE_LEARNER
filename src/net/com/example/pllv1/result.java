package net.com.example.pllv1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class result extends Activity {
TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.resultquiz);
		result=(TextView)findViewById(R.id.dresult);
		 SharedPreferences bookmark=getSharedPreferences("result",0);
		 String bm=bookmark.getString("result", "");
		 result.setText(bm +"/10" );
		 bm="0";

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

}
