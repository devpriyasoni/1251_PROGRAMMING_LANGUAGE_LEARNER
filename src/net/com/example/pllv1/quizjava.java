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

public class quizjava extends Activity implements OnCheckedChangeListener, OnClickListener{

	
	TextView heading,option1,option2,option3,option4,twatch;
	ProgressBar bar,bar1;
	int ii=0,progressStat=0,progressStatus=0,result=0,attempt=0,qnumber=0;
	String canswer;
	int y=0,no=0,exitcounter=0;
	RadioGroup group;
	MediaPlayer Oursong;
	Button next,quizend;
	private Handler handler = new Handler();
	String ques[][]={{"Which of these have highest precedence?","()","++","*",">>"},
			{" What should be expression1 evaluate to in using ternary operator as in this line?\nexpression1 ? expression2 : expression3 ","Integer","Floating","Boolean","None of these"},
			{"Which of these class is used to make a thread?","String","System","Thread","Runnable"},
			{"Which of these method of Thread class is used to find out the priority given to a thread?","get()","ThreadPriority()","getPriority()","getThreadPriority()"},
			{"Which function of pre defined class Thread is used to check weather current thread being checked is still running?","isAlive()","Join()","isRunning()","Alive()"},
			{"Which of these keywords are used to implement synchronization?","synchronize","syn","synch","synchronized"},
			{"Which of these method is used to avoid polling in Java?","wait()","notify()","notifyAll()","All of above"},
			{"Which of these method wakes up all the threads?","wakeAll()","notify()","start()","notifyAll()"},
			{"What is the prototype of the default constructor of this class?\npublic class prototype { }","prototype( )","prototype(void)","public prototype(void)","public prototype( )"},
			{"Which will legally declare, construct, and initialize an array?","int [] myList = {\"1\", \"2\", \"3\"};","int [] myList = (5,8,2);","int myList [] [] = {4,9,7,0};","int myList [] = {4, 3, 7};"},
			{"Which is a reserved word in the Java programming language?","method","native","array","reference"},
			{"Which is a valid keyword in java?","interface","string","Float","unsigned"},
			{"What is the numerical range of a char?","-128 to 127","2exp15 - 1","0 to 32767","0 to 65535"},
			{"Which class does not override the equals() and hashCode() methods, inheriting them directly from class Object?","java.lang.String","java.lang.Double","java.lang.StringBuffer","java.lang.Character"},
			{"Which collection class allows you to grow or shrink its size and provides indexed access to its elements, but whose methods are not synchronized?","java.util.HashSet","java.util.LinkedHashSet","java.util.List","java.util.ArrayList"},
			{"double d = Math.round ( 2.5 + Math.random() );","2","3","4","2.5"},
			{"Which of the following would compile without error?","int a = Math.abs(-5);","int b = Math.abs(5.0);","int c = Math.abs(5.5F);","int d = Math.abs(5L);"},
			{"What is the prototype of the default constructor?","Test()","Test(void)","public Test()","public Test(void)"}};
	String ans[]={"select1","select3","select3","select3","select1","select4","select4","select4","select4","select4","select2","select1","select4","select3","select4","select2","select1","select3"};
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
			//stoptime=(TextView)findViewById(R.id.stoptime);
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
							twatch.setText(Integer.toString(progressStatus+1) +" sec gone");
							
							if(progressStatus==46)
							{
								Oursong=MediaPlayer.create(quizjava.this, R.raw.alarm);
								Oursong.start();
								  Vibrator v12 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
								  v12.vibrate(1000);

						//		stoptime.setBackgroundResource(R.drawable.timestop);
							}
							if(progressStatus==50)
							{
								if(exitcounter==0)
								{
								result();
								Intent sl = new Intent(quizjava.this, result.class);
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
					
			 
			// Update the progress bar and display the current value in the text view
//	if(y==1)
	//{		
					result++;	
					progressStat += 1;
					bar1.setProgress(progressStat);
	//}
	

	
	
	
//					bar.setMax(3);
					//textView.setText(progressStatus+"/"+progressBar.getMax());
			

		
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	//	ii++;
		switch(arg0.getId())
		{
		case (R.id.quiznext) :
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
			Intent sl = new Intent(quizjava.this, result.class);
			startActivity(sl);
			exitcounter=1;
		//	onPause();
			System.exit(0);
			
			
		}
		break;
		}
		case (R.id.quizend) :
		{
			result();
			Intent sl = new Intent(quizjava.this, result.class);
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
