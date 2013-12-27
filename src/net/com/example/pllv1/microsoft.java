package net.com.example.pllv1;

import java.io.FileOutputStream;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class microsoft extends Activity implements OnClickListener{
	
	TextView t,t1,t2,t3,t4,t5;


	
	int ii = 0;
	Button prev, next;
	
	String var,data;
	
	String heading[] = { "MICROSOFT Set 1", "MICROSOFT Set 2", "MICROSOFT Set 3" };
	
	String q1[] = {"Q- Arrange the numbers in an array in alternating order. \nFor example if the array is [a1, a2, a3, a4.. ]arrange the array such that b1<=b2>=b3<=b4 and so on. \nSampe Input: 3 5 7 8 4 9 \nSample Output: 3 < 5 > 4 < 8 >7 < 9\n\n",
					"Q- Write code for removing alternate duplicate characters (case insensitive) in a string in place. Also give test cases.\n\nQ-\tWrite code for removing alternate duplicate characters (case insensitive) in a string in place.",
					"Q- You have three covered baskets labelled \"Apples\", \"Oranges\" and \"Mixed.\" All of them are labelled incorrectly. Choosing only one fruit from one of the baskets (and not peeking inside), how can you determine how to relabel the baskets?\n\n" };
	
	String q2[] = {"Q- Write code to remove alternate duplicate characters (case insensitive) from a string in place. For eg. \"Today is the day\" -> \"Today ishe \". Also give test cases.",
					"Q- You have a gold bar with seven segments. For seven days, you must pay an employee with one gold segment each day. Breaking the bar only twice, how can you ensure the employee gets paid appropriately?",
						"Q- Given two strings remove duplicates and test it\n\nQ-\tGiven a function to reverse a linked list write code to test the function" };

	String q3[] = {"Q-Delete m nodes for every n nodes in linked list and write the test cases\n\nQ-Complexity of a function: \n",
			"Q- You have 10 million IP addresses. (IPv4 4 byte addresses). Create a hash function for these IP addresses. \n\nHint: Using the IP\'s themselves as a key is a bad idea because there will be a lot of wasted space.",
			"Given 3 sorted arrays A[], B[] and C[]. Find the three numbers in these arrays such that A + B[j] = C[k]." };
	
	String q4[] = {"Q-How many points are there on the globe where, by walking one mile south, then one mile east and then one mile north, you would reach the place where you started?",
			"Q-If you had an infinite supply of water and a 5 quart and 3 quart pails, how would you measure exactly 4 quarts? and What is the least number of steps you need?",
			"Q-Three ants are sitting at the three corners of an equilateral triangle. Each ant starts randomly picks a direction and starts to move along the edge of the triangle. What is the probability that none of the ants collide?" };
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		SharedPreferences getprefs1 = PreferenceManager
		.getDefaultSharedPreferences(getBaseContext());
//boolean anim1 = getprefs1.getBoolean("at", true);
SharedPreferences bookmark1 = getSharedPreferences("az", 0);
String set = bookmark1.getString("sets", "");
if(set.equals("set1"))
{
	ii=0;
	
	
}
else if(set.equals("set2"))
{
	ii=1;
}
else if(set.equals("set3"))
{
	ii=2;
}

		super.onCreate(savedInstanceState);
		fscreen();
		setContentView(R.layout.viewt);

		t = (TextView) findViewById(R.id.t5);
		t1 = (TextView) findViewById(R.id.t1);
		t2 = (TextView) findViewById(R.id.t2);
		t3 = (TextView) findViewById(R.id.t3);
		t4 = (TextView) findViewById(R.id.t4);
		 prev = (Button) findViewById(R.id.pageprev);
		 next = (Button) findViewById(R.id.pagenext);
		 prev.setOnClickListener(this);
		 next.setOnClickListener(this);
		 
		t.setText(heading[ii]);
		t1.setText(q1[ii]);
		t2.setText(q2[ii]);
		t3.setText(q3[ii]);
		t4.setText(q4[ii]);
		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);		
	}	

	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.pageprev:
			
			ii--;
			if(ii<0)
			{
				ii=(heading.length)-1;
			}
			t.setText(heading[ii]);
			t1.setText(q1[ii]);
			t2.setText(q2[ii]);
			t3.setText(q3[ii]);
			t4.setText(q4[ii]);
	//		getcolor();
	//		getsize();

			break;
		case R.id.pagenext:
			
			ii++;
			if(ii>((heading.length)-1))
			{
				ii=0;
			}
			t.setText(heading[ii]);
			t1.setText(q1[ii]);
			t2.setText(q2[ii]);
			t3.setText(q3[ii]);
			t4.setText(q4[ii]);


			break;
			
			
			
		}
	
	
	}
	private void fscreen() {
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
