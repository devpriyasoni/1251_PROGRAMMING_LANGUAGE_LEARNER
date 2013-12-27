package net.com.example.pllv1;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database12 {
	public static final String KEY_USERNAME="UNAME";
	public static final String KEY_PASSWORD="PASS";
	public static final String KEY_EMAIL="UEMAIL";
	public static final String KEY_BOOKC="BOOKC";
	public static final String KEY_BOOKCPLUS="BOOKCPLUS";
	public static final String KEY_BOOKJAVA="BOOKJAVA";
	public static final String KEY_NOTES="NOTES";
	public static final String KEY_GNOTE="GNOTES";
	
	
	private static final String DATABASE_NAME="PLLNAME123";
	private static final String DATABASE_TABLE="PLLTABLE123";
	private static final int DATABASE_VERSION=1;
	
	private dbhelper ourhelper;
	private final Context context1;
	private SQLiteDatabase ourdatabase;
	
	
	private static class dbhelper extends SQLiteOpenHelper{

		public dbhelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {			
			// TODO Auto-generated method stub
			db.execSQL(" CREATE TABLE " + DATABASE_TABLE + " ( " + KEY_USERNAME + "  TEXT PRIMARY KEY  ," + KEY_PASSWORD + " TEXT NOT NULL ,"
					+ KEY_EMAIL + " TEXT NOT NULL , " + KEY_BOOKC + " TEXT NOT NULL  ,"+ KEY_BOOKCPLUS + " TEXT NOT NULL ,"+ KEY_BOOKJAVA + " TEXT NOT NULL,"
					+ KEY_NOTES + " TEXT NOT NULL );"
					
					
					);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
			onCreate(db);
			
		}
		
		
	}
	public database12 (Context c)
	{
		context1=c;
	}
	
	public database12 open(){
		
		ourhelper=new dbhelper(context1);
		ourdatabase=ourhelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourhelper.close();
	}

	public long createEntry(String name, String pass, String add) {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		cv.put(KEY_USERNAME,name);
		cv.put(KEY_PASSWORD, pass);
		cv.put(KEY_EMAIL,add);
		cv.put(KEY_BOOKC, "0");
		cv.put(KEY_BOOKCPLUS, "0");
		cv.put(KEY_BOOKJAVA, "0");
		cv.put(KEY_NOTES," ");
		return ourdatabase.insert(DATABASE_TABLE, null, cv);
		
	}

	public String validate(String name, String pass) {
		// TODO Auto-generated method stub
		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
				KEY_BOOKJAVA,KEY_NOTES};
		
		Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
		String aa="";
		int iname=c.getColumnIndex(KEY_USERNAME);
		int ipass=c.getColumnIndex(KEY_PASSWORD);
		int i = 0;
		for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
		{
			if((name.equalsIgnoreCase(c.getString(iname))) && (pass.equalsIgnoreCase(c.getString(ipass))))
			{
				 aa="c.getString(iname) "+"c.getString(ipass)";
				 
				 
				break;
			}
													
		}
		
		return aa;
	}

	public String getdata() {
		// TODO Auto-generated method stub

		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
		KEY_BOOKJAVA,KEY_NOTES};

Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
String result="";
int iname=c.getColumnIndex(KEY_USERNAME);
int ipass=c.getColumnIndex(KEY_PASSWORD);
int imail=c.getColumnIndex(KEY_EMAIL);
int ibookc=c.getColumnIndex(KEY_BOOKC);
int ibookcplus=c.getColumnIndex(KEY_BOOKCPLUS);
int ibookjava=c.getColumnIndex(KEY_BOOKJAVA);
int inotes=c.getColumnIndex(KEY_NOTES);
int i = 0;
for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
{
	result=result+c.getString(iname)+" "+c.getString(ipass) + " "
+ c.getString(imail) + " " + c.getString(ibookc) +" " +c.getString(ibookcplus) + " " + c.getString(ibookjava) + " " + c.getString(inotes) + "\n";
											
}

		
		return result;
	}

	public int updateEntry(String bm, String cm, String bookvalue) {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		//String g=Integer.toString(jx);
		cv.put(KEY_BOOKC,bookvalue);
		ourdatabase.update(DATABASE_TABLE, cv, KEY_USERNAME + "=" + bm /*+ "AND" + KEY_PASSWORD + "=" + cm */, null);
		return 1;
		
		
	}
	
	
	public String validatebookc(String bm1, String cm1) {
		// TODO Auto-generated method stub
		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
				KEY_BOOKJAVA,KEY_NOTES};
		
		Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
		String aa="";
		int iname=c.getColumnIndex(KEY_USERNAME);
		int ipass=c.getColumnIndex(KEY_PASSWORD);
		int ibookc=c.getColumnIndex(KEY_BOOKC);
		int i = 0;
		for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
		{
			if((bm1.equalsIgnoreCase(c.getString(iname))) && (cm1.equalsIgnoreCase(c.getString(ipass))))
			{
				 aa=c.getString(ibookc) ;
				 
				 
				break;
			}
													
		}
		
		return aa;
	}

	public int updateEntrycpp(String bm, String cm, String bookvalue) {
		// TODO Auto-generated method stub
		
		
		ContentValues cv= new ContentValues();
		//String g=Integer.toString(jx);
		cv.put(KEY_BOOKCPLUS,bookvalue);
		ourdatabase.update(DATABASE_TABLE, cv, KEY_USERNAME + "=" + bm /*+ "AND" + KEY_PASSWORD + "=" + cm */, null);
		return 1;


	}

	public String validatebookcpp(String bm1, String cm1) {
		// TODO Auto-generated method stub
		
		
		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
				KEY_BOOKJAVA,KEY_NOTES};
		
		Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
		String aa="";
		int iname=c.getColumnIndex(KEY_USERNAME);
		int ipass=c.getColumnIndex(KEY_PASSWORD);
		int ibookc=c.getColumnIndex(KEY_BOOKCPLUS);
		int i = 0;
		for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
		{
			if((bm1.equalsIgnoreCase(c.getString(iname))) && (cm1.equalsIgnoreCase(c.getString(ipass))))
			{
				 aa=c.getString(ibookc) ;
				 
				 
				break;
			}
													
		}
		
		return aa;

		
		
	}

	public int updateEntryjava(String bm, String cm, String bookvalue) {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		//String g=Integer.toString(jx);
		cv.put(KEY_BOOKJAVA,bookvalue);
		ourdatabase.update(DATABASE_TABLE, cv, KEY_USERNAME + "=" + bm /*+ "AND" + KEY_PASSWORD + "=" + cm */, null);
		return 1;

	}

	public String validatebookjava(String bm1, String cm1) {
		// TODO Auto-generated method stub
		
		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
				KEY_BOOKJAVA,KEY_NOTES};
		
		Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
		String aa="";
		int iname=c.getColumnIndex(KEY_USERNAME);
		int ipass=c.getColumnIndex(KEY_PASSWORD);
		int ibookc=c.getColumnIndex(KEY_BOOKJAVA);
		int i = 0;
		for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
		{
			if((bm1.equalsIgnoreCase(c.getString(iname))) && (cm1.equalsIgnoreCase(c.getString(ipass))))
			{
				 aa=c.getString(ibookc) ;
				 
				 
				break;
			}
													
		}
		
		return aa;


	}

	public String validateEmail(String bm1, String cm1) {
		
		// TODO Auto-generated method stub
		String[] colm=new String[]{KEY_USERNAME,KEY_PASSWORD,KEY_EMAIL,KEY_BOOKC,KEY_BOOKCPLUS,
				KEY_BOOKJAVA,KEY_NOTES};
		
		Cursor c=ourdatabase.query(DATABASE_TABLE, colm,null,null, null, null, null);
		String aa="";
		int iname=c.getColumnIndex(KEY_USERNAME);
		int ipass=c.getColumnIndex(KEY_PASSWORD);
		int ibookc=c.getColumnIndex(KEY_EMAIL);
		int i = 0;
		for(c.moveToFirst();! c.isAfterLast();c.moveToNext())
		{
			if((bm1.equalsIgnoreCase(c.getString(iname))) && (cm1.equalsIgnoreCase(c.getString(ipass))))
			{
				 aa=c.getString(ibookc) ;
				 
				 
				break;
			}
													
		}
		
		return aa;

		

	}

	

}

