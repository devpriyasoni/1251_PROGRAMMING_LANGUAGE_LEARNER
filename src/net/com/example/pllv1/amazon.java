package net.com.example.pllv1;

import java.io.FileOutputStream;
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

public class amazon extends Activity implements OnClickListener{
	
	TextView t,t1,t2,t3,t4,t5;


	
	int ii = 0;
	Button prev, next;
	
	String var,data;
	
	String heading[] = { "AMAZON Set 1", "AMAZON Set 2", "AMAZON Set 3" };
	
	String q1[] = {"Q-You have two integer arrays. Treat these arrays as if they were big numbers, with one digit in each slot. Perform addition on these two arrays and store the results in a new array.",
					"Q-Given a binary representation of an integer say 15 as 1111, find the maximum longest continous sequence of 0s. The twist is it needs to be done in log N. I could think of O(N) solution. but couldn\'t go for log(N). ",
					"Q- Find the first non-repeating character in a stream of characters?\n\nQ- What language are you most comfortable with?\n" };
	
	String q2[] = {"Q-  Suppose there were n numbers in an array S1, S2, S3, S4.......SN rearrange them in a such a way that they satisfy bellow property.  S1<S2>S3<S4>......\n",
					"Q-  Implement HashTable in java , especially hash function that should take care of any type of keys. The key may be integer or String or Object. But based on that the hash function should find index in the hashArray\n\nQ-  Implement Array Class in java.\n",
					"Q-  Given an array of pairs of the form <a, b>. We have to find a sub-array such that the 1st element in the pairs are in increasing order and the sum of 2nd element of the pairs in the sub-array is maximum possible\n" };

	String q3[] ={" Q: Design a component that will implement web browser history. the user goes to different site and once he press on history button you should display the last 5 (no duplicates allowed, and 5 can be any N later) if duplicates occur display the most recent one.",
				"Q- Write a function called FooBar that takes input integer n and prints all the numbers from 1 upto n in a new line. If the number is divisible by 3 then print \"Foo\", if the number is divisible by 5 then print \"Bar\" and if the number is divisible by both 3 and 5, print \"FooBar\". Otherwise just print the number. \n",
				"Q- ABC Inc is a private company focused on oil and exploration. Its net income has been fluctuating since inception. It plans to raise funding for new explorations. The financiers are seeking out if the company had successful runs. If so, which was the most successful one historically. A successful run being a set of consecutive years in which adding the net income year over year results" };
	
	String q4[] = {"Q-given a dictionary of words,find the pair of word with following property: \n1,the two word don\'t have same letter. \n2,the multiple of the two word\'s length is maximum. \n",
					"Q- Given a binary representation of an integer say 15 as 1111, find the maximum longest continous sequence of 0s. The twist is it needs to be done in log N. I could think of O(N) solution. but couldn\'t go for log(N). \nQ-\tPrint words of given string in reverse order: \n\t\"This is test\" \n",
					"Q- 4 individual numbers which could be permuted in 4 factorial ways. permutation of these 4 integers is an 0indexedarray consisting of 4 digits in some order when integers are different. the best permute of the 4 integers is by the following funciton func(summ) = abs(summ[0] - summ[1]) + abs(summ[2] - summ[3])) that would give maximum value. \n" };
	
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
