package net.com.example.pllv1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class firstlogin extends Activity implements OnClickListener, OnCheckedChangeListener   {

Button signin,signup;
CheckBox c1;
EditText password,username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.login1);

		signin=(Button)findViewById(R.id.signin);
		signup=(Button)findViewById(R.id.signup);
		c1=(CheckBox)findViewById(R.id.pvisible);
		password=(EditText)findViewById(R.id.password);
		username=(EditText)findViewById(R.id.username);
		signin.setOnClickListener(this);
		signup.setOnClickListener(this);
		c1.setOnCheckedChangeListener(this);
	}
	
	
	String s;
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.signin :
			signin.setBackgroundColor(0xff77a31d);
			

			String name=username.getText().toString();
			String pass=password.getText().toString();
			database12 valid = new database12 (firstlogin.this);
			valid.open();
			s=valid.validate(name,pass);
			valid.close();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			signin.setBackgroundColor(android.R.drawable.btn_default);
/*			Toast toast = Toast.makeText(firstlogin.this,"valid user",Toast.LENGTH_LONG);
			toast.show();*/    

			if(s.equalsIgnoreCase(""))
			{
				
				
	              LayoutInflater inflater = getLayoutInflater();
	                // Inflate the Layout
	                View layout = inflater.inflate(R.layout.nologintoast,
	                                               (ViewGroup) findViewById(R.id.custom_toast_layout1));
	      
	                TextView text = (TextView) layout.findViewById(R.id.textToShow1);
	                // Set the Text to show in TextView
	                text.setText("Login Unsuccessful");

	                Toast toast = new Toast(getApplicationContext());
	                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
	                toast.setDuration(Toast.LENGTH_SHORT);
	                toast.setView(layout);
	                toast.show();
	               

				//Toast toast = Toast.makeText(firstlogin.this,"Invalid user" +" Try again ",Toast.LENGTH_LONG);
				//toast.show();    


			}
			else
			{
	              LayoutInflater inflater = getLayoutInflater();
	                // Inflate the Layout
	                View layout = inflater.inflate(R.layout.logintoast,
	                                               (ViewGroup) findViewById(R.id.custom_toast_layout));
	      
	                TextView text = (TextView) layout.findViewById(R.id.textToShow);
	                // Set the Text to show in TextView
	                text.setText("Login Successful");

	                Toast toast = new Toast(getApplicationContext());
	                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	                toast.setDuration(Toast.LENGTH_SHORT);
	                toast.setView(layout);
	                toast.show();
				/*Toast toast = Toast.makeText(firstlogin.this,"Valid User",Toast.LENGTH_LONG);
				toast.show();*/
				String filename="file";
				SharedPreferences bookmark=getSharedPreferences(filename,0);								
				 SharedPreferences.Editor editor=bookmark.edit();
				 editor.putString("starting", name);
				 editor.putString("pass",pass);
				 editor.commit();
				 
				Intent se=new Intent("net.com.example.pllv1.STARTMENU");
				startActivity(se);



				 /*Intent slideactivity = new Intent(firstlogin.this, startmenu.class);
				 
					Bundle bndlanimation =
							ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
					startActivity(slideactivity, bndlanimation);*/

			}
									
			break;
			
			
			
			
			
		case R.id.signup :
			signin.setBackgroundColor(0xff77a31d);
			SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			boolean anim=getprefs.getBoolean("at", true);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			signin.setBackgroundColor(android.R.drawable.btn_default);

		Intent se=new Intent("net.com.example.pllv1.SIGNUP");
		startActivity(se);
			
			break;
	
			
		}
		
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

	
	
	private boolean validate(String name, String pass) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
		if(arg0.isChecked())
		{
			password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
		
		else
		{
			password.setInputType(InputType.TYPE_CLASS_TEXT );
		}
		
		
	}
	
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}

	

}

