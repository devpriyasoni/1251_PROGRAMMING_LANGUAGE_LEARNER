package net.com.example.pllv1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class displaytable extends Activity{
TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewt);
	//	t1=(TextView)findViewById(R.id.tq1);
		database12 q=new database12(this);
		q.open();
		String data=q.getdata();
		q.close();
		t1.setText(data);
		
	}

}
