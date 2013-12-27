package net.com.example.pllv1;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends Activity implements OnCheckedChangeListener, OnClickListener{

	
	TextView heading,option1,option2,option3,option4,twatch;
	ProgressBar bar,bar1;
	int ii=0,progressStat=0,progressStatus=0,result=0,attempt=0,qnumber=0;
	String canswer;
	int y=0,no=0,exitcounter=0;
	RadioGroup group;
	MediaPlayer Oursong;
	Button next,quizend;
	private Handler handler = new Handler();
	String ques[][]={{"Which directory the compiler first looks for the file when using #include ?","Current directory where program is saved","C:COMPILERINCLUDE","S:SOURCEHEADERS","Both (b) and (c) simultaneously"},
			{"Can function definition be present in header files? ","Yes","No","Depends on compiler","Depends on standard"},
			{"For which of the following, \u201cPI++;\u201d code will fail?","#define PI 3.14","char *PI = “A”;","float PI = 3.14;","both of above"},
			{"Which keyword is used to prevent any changes in the variable within a C program?","immutable","mutable","const","volatile"},
			{"Which of the following is not a pointer declaration?","char a[10];","char a[] = {’1', ’2', ’3', ’4'};","char *str;","char a"},
			{"A variable declared in a function can be used in main","true","false","True if it is declared static","none of these"},
			{"The name of the variable used in one function cannot be used in another function","true","false","May be","none of these"},
			{" char *str = \u201cSanfoundry.com\\0? \u201ctraining classes\u201d;\n       The character pointer str holds reference to string:","Sanfoundry.com"," Sanfoundry.com\0training classes","Sanfoundry.comtraining classes","Invalid declaration"},
			{"C language has been developed by ?","Ken Thompson","Dennis Ritchie","Peter Norton","Martin Richards"},
			{"C programs are convrted into the machine language with the help of ?","An editor","Compiler","An operating system","none of these"},
			{"The real constant in C can be expressed which of the following forms ?","Fractional form only","Exponetial form only","ASCII form only","Both Fractional and Exponetial"},
			{"Which bitwise operator is suitable for turning off a particular bit in a number?","&& operator","|| operator","& operator","! operaor"},
			{"Which bitwise operator is suitable for checking whether a particular bit is on or off?","&& operator","|| operator","& operator","! operaor"},
			{"Which of the following function sets first n characters of a string to a given character?","strinit()","strnset()","strset()","strcset()"},
			{"How will you print \n on the screen?","printf(\"\\n\");","echo \"\\\\n\";","printf(\'\\n\');","printf(\"\\\\n\");"},
			{"Which of the following correctly shows the hierarchy of arithmetic operations in C?","/ + * -","* - / +","+ - / *","/ * + -"},
			{"Input/output function prototypes and macros are defined in which header file?","conio.h","stdlib.h","stdio.h","dos.h"},
			{"The keyword used to transfer control from a function back to the calling function is","switch","goto","go back","return"}};
	String ans[]={"select2","select1","select1","select3","select4","select2","select2","select2","select2","select2","select4","select3","select3","select2","select4","select4","select3","select4"};
	Random crazy=new Random();
	TextView stoptime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.ccccquiz);
			result=0;
			twatch=(TextView)findViewById(R.id.twatch);
		//	stoptime=(TextView)findViewById(R.id.stoptime);
		heading=(TextView)findViewById(R.id.headingquiz);
		option1=(TextView)findViewById(R.id.option1);
		option2=(TextView)findViewById(R.id.option2);
		option3=(TextView)findViewById(R.id.option3);
		option4=(TextView)findViewById(R.id.option4);
		next=(Button)findViewById(R.id.quiznext);
		quizend=(Button)findViewById(R.id.quizend);
		bar=(ProgressBar)findViewById(R.id.pB1);
		bar1=(ProgressBar)findViewById(R.id.pB2);
		bar.setMax(51);
		bar1.setMax(10);
		group=(RadioGroup)findViewById(R.id.rG1);
		next.setOnClickListener(this);
		quizend.setOnClickListener(this);
		group.setOnCheckedChangeListener(this);
				ii=crazy.nextInt(18);
			//	qnumber++;
			heading.setText(ques[ii][0]);
			option1.setText(ques[ii][1]);
			option2.setText(ques[ii][2]);
			option3.setText(ques[ii][3]);
			option4.setText(ques[ii][4]);
			canswer=ans[ii];
//			y=answer(canswer);
			timer();
		
	}
	private void timer() {
		// TODO Auto-generated method stub
		
	new Thread(new Runnable() {
			public void run() {
				while (progressStatus < 51) {
					progressStatus += 1;
					// Update the progress bar and display the current value in the text view
					
				
					handler.post(new Runnable() {
						public void run() {
							
							bar.setProgress(progressStatus);
							twatch.setText(Integer.toString(progressStatus+1)+" sec gone");
							
							if(progressStatus==46)
							{
								Oursong=MediaPlayer.create(quiz.this, R.raw.alarm);
								Oursong.start();
								  Vibrator v12 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
								  v12.vibrate(1000);

								//stoptime.setBackgroundResource(R.drawable.timestop);
							}
							if(progressStatus==50)
							{
								if(exitcounter==0)
								{
								result();
								Intent sl = new Intent(quiz.this, result.class);
								startActivity(sl);
								System.exit(0);
								}
							}
							//textView.setText(progressStatus+"/"+progressBar.getMax());
						}
					});
					try {
						// Sleep for 200 milliseconds. Just to display the progress slowly
						
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	private int answer(String a) {
		// TODO Auto-generated method stub
		
		if(canswer.equals(a))
		{
			return 1;	
		}
		
		else
		{
			
		return 0;
		
		}
		
	}
	
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1)
		{
		case R.id.select1 :
			 y=answer("select1");			
			 attempt=1;
			break;
			
		case R.id.select2 :
			y=answer("select2");
			attempt=1;
			break;
			
		case R.id.select3 :
			y=answer("select3");
			attempt=1;
			break;
			
		case R.id.select4 :
			 y=answer("select4");
			 attempt=1;
			break;
			
		//	default: y=0;
			//break;

		}
	}
	private void ProgressStatus() {
		// TODO Auto-generated method stub
					result++;	
					progressStat += 1;
					bar1.setProgress(progressStat);
					
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	//	ii++;
		switch(arg0.getId())
		{
		
		
		case R.id.quiznext :
		{
		ii=crazy.nextInt(18);		
		qnumber++;
		
		
		if(qnumber<10)
			
			{
			
			group.clearCheck();
			heading.setText(ques[ii][0]);
			option1.setText(ques[ii][1]);
			option2.setText(ques[ii][2]);
			option3.setText(ques[ii][3]);
			option4.setText(ques[ii][4]);
			canswer=ans[ii];
			if(y==1 && attempt==1)         //it's for previous iteration
			{
			ProgressStatus();
			result();
			}
			//y=answer(canswer);
			attempt=0;
					y=0;

			
			}
		
		
			if(qnumber==10)
				{	

				if(y==1 && attempt==1)     //it's for last iteartion
				
				{
					ProgressStatus();
					result();
				}
				Intent sl = new Intent(quiz.this, result.class);
				startActivity(sl);
				exitcounter=1;
		//	onPause();
				System.exit(0);
			
			
				}
			break;
		}
		
		case R.id.quizend :
		{
			result();
			Intent sl = new Intent(quiz.this, result.class);
			startActivity(sl);
			System.exit(0);
			break;
		}
		}
	}
	private void result() {
		// TODO Auto-generated method stub
		SharedPreferences bookmark=getSharedPreferences("result",0);								
		 SharedPreferences.Editor editor=bookmark.edit();
		 String a=Integer.toString(result);
		 editor.putString("result",a);			 
		 editor.commit();
		
		
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Oursong.release();
//		finish();
		
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
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
	    if (  Integer.valueOf(android.os.Build.VERSION.SDK) < 7 //Instead use android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ECLAIR
	            && keyCode == KeyEvent.KEYCODE_BACK
	            && event.getRepeatCount() == 0) {
	        // Take care of calling this method on earlier versions of
	        // the platform where it doesn't exist.
	        onBackPressed();
	    }

	    return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
	    // This will be called either automatically for you on 2.0
	    // or later, or by the code above on earlier versions of the
	    // platform.
	    return;
	}

}
