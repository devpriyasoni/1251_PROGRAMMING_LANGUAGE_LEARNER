package net.com.example.pllv1;





import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class preffs extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preff);
		
		
/*		Context context = getApplicationContext();
		CharSequence text = "Hello toast!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text,duration);
		toast.show();   */
	}
	

}

