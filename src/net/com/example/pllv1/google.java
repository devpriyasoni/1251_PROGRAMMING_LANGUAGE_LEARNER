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

public class google extends Activity implements OnClickListener{
	
	TextView t,t1,t2,t3,t4,t5;


	
	int ii = 0;
	Button prev, next;
	
	String var,data;
	
	String heading[] = { "GOOGLE Set 1", "GOOGLE Set 2", "GOOGLE Set 3" };
	
	String q1[] = {"Q- How to represent a number in base -2? (negative -2 base) eg 6 can be 11010 i.e. 16 -8 +0 -2 +0 = 6.",
			"Q-Write code for finding first duplicate element in given array: \n\t[4,3,1,2,5,9,5,4] \n",
			"Q-Lets say there is a device which gets push message for update from server \n(like android mobile gets) and it switches between wifi and 3G. \nWrite all possible test scenario (negative that might occur in real world, like server gows down etc..)\n" };
	
	String q2[] = {"Q-\tPrint words of given string in reverse order: \n\t\"This is test\" ",
			"Q-\tPrint array in spiral \n\t123  894 765 \n",
			"Q-There are two methods printA inside Class A and printB inside class B. printA is a static method and printB is a non-static method. Both the methods are synchronized. There exact 100 million threads fired on both printA and printB each. Which method execution will take less time?\n" };

	String q3[] = {"Q-Design a OO system for furniture where there are wooden chairs and tables, metal chairs and tables. There are stress and fire tests for each products.\n",
			"Q- Find the first non-repeating character in a stream of characters?\n\nQ-What language are you most comfortable with? (I answered C/C++) \nWhat\'s an unordered map, and how is it implemented?\n",
			"Q-Given a function to reverse a linked list write code to test the function\n\nQ-Delete m nodes for every n nodes in linked list and write the test cases\n" };
	
	String q4[] = {"Q-Given a string, and the letters are NOT DISTINCT, print out all possible permutations. The solution must be optimized so don\'t implement the naive O(n!) solution.\n\nQ-What is the difference between an array and linked list?\n",
			"Q-You have a gold bar with seven segments. For seven days, you must pay an employee with one gold segment each day. Breaking the bar only twice, how can you ensure the employee gets paid appropriately?\n",
			"The input would be an array with the net income for all years till date since inception. Output should be a pair of years <Y1 Y2> which represent the most successful run. For simplicity let Y1 and Y2 be array indices. If there wasn\'t a successful run return -1. \nSample Input1: 3 2 -6 2 1 " };
	
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
