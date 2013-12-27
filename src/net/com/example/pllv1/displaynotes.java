package net.com.example.pllv1;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class displaynotes extends Activity implements OnClickListener {

	TextView notes;Button button;
	String var;
	SharedPreferences bookmark;
	String filename="file",fa;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notes);
		notes=(TextView)findViewById(R.id.dnote);
		button=(Button)findViewById(R.id.button112);
		button.setOnClickListener(this);
		Bundle gotbasket = getIntent().getExtras();
		 var = gotbasket.getString("collect");
		notes.setText(var);
		Random crazy=  new Random();
		notes.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));
		bookmark=getSharedPreferences(filename,0);
		 String bm1=bookmark.getString("starting", "");
		 String cm1=bookmark.getString("pass", "");

		 database12 sd1= new database12(this);
		 sd1.open();
		 fa=sd1.validateEmail(bm1,cm1);
		 sd1.close();

		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.button112)
		{
			//email intent
			Intent email =new Intent(android.content.Intent.ACTION_SEND);
			email.putExtra(android.content.Intent.EXTRA_TEXT, var);
			email.putExtra(android.content.Intent.EXTRA_EMAIL, fa);
			email.setType("plain/text");
			startActivity(email);
		}
	}
	

}
