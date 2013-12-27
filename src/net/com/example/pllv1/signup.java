package net.com.example.pllv1;



import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends Activity implements OnClickListener, OnCheckedChangeListener{

	String aa="",bb="";
	Button save;
	EditText username,password,email,confirmpass;
	CheckBox c1;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.login2);
		
		save=(Button)findViewById(R.id.save);
		confirmpass=(EditText)findViewById(R.id.confirmpass);
		username=(EditText)findViewById(R.id.usernamedetail);
		password=(EditText)findViewById(R.id.passdetail);
		email=(EditText)findViewById(R.id.emaildetail);
	//	tv=(TextView)findViewById(R.id.tView1);
		c1=(CheckBox)findViewById(R.id.pvisible1);
		confirmpass=(EditText)findViewById(R.id.confirmpass);
		c1.setOnCheckedChangeListener(this);
		save.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		boolean okpass= false,okadd =false;
		
		if(v.getId()==R.id.save)
		{
			
			
		
			String name=username.getText().toString();
			String pass=password.getText().toString();
			String add=email.getText().toString();
			String cpass=confirmpass.getText().toString();
			if(pass.contentEquals(cpass) )
			{
				okpass=true;
				
				aa="";
			}
			else
			{
				 aa="password are not equal \n";
			}
			
			
			if(add.contains("@") )
			{
				okadd=true;
				bb="";
			}
			else
			{
				 bb="enter valid mail";
			}
			
			
			if(okpass==false || okadd==false)
			{
			Toast toast = Toast.makeText(signup.this,aa.concat(bb),Toast.LENGTH_LONG);
			toast.show();    
			}
			
			if(okpass==true && okadd==true)
			{
			database12 entry=new database12(signup.this);
			entry.open();
			long q=entry.createEntry(name,pass,add);
			entry.close();
			
			String filename="file";
			SharedPreferences bookmark=getSharedPreferences(filename,0);								
			 SharedPreferences.Editor editor=bookmark.edit();
			 editor.putString("starting", name);
			 editor.putString("pass",pass);
			 editor.commit();

			Toast toast = Toast.makeText(signup.this,"Details Saved",Toast.LENGTH_LONG);
			toast.show();    

			
			Dialog d=new Dialog(this);
			d.setTitle(" WELCOME TO PLL ");
			TextView tv=new TextView(this);
			tv.setText("\n" +"    ENJOY PLL LEARNING \n\n " +" MAY YOU HAVE ENJOYABLE EXPERIENCE" + " \n ");
			tv.setTextColor(Color.BLUE);
			tv.setTextSize(20);
			d.setContentView(tv);
			d.show();

			
			
			
/*			Thread t=new Thread();
			try {
				Thread.sleep(4500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	*/		
			
/*			AlertDialog.Builder builder = new AlertDialog.Builder(signup.this);
			builder.setMessage("WELCOME TO PLL");
		    builder.setTitle(" PLL WELCOME"); */
		    
			
		Intent se=new Intent("net.com.example.pllv1.STARTMENU");
		startActivity(se);


			

		}

				

		}
		
	}
	
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
		if(arg0.isChecked())
		{
			password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			confirmpass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
		
		else
		{
			password.setInputType(InputType.TYPE_CLASS_TEXT );
			confirmpass.setInputType(InputType.TYPE_CLASS_TEXT );
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

	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}

	

}