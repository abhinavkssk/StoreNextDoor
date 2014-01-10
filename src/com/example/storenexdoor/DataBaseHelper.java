package com.example.storenexdoor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper
{
	public DataBaseHelper(Context context, String name,CursorFactory factory, int version) 
    {
	           super(context, name, factory, version);
	}
	// Called when no database exists in disk and the helper class needs
	// to create a new one.
	@Override
	public void onCreate(SQLiteDatabase _db) 
	{
			_db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
			_db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE1);
		_db.execSQL(LoginDataBaseAdapter.DATABASE_data);
		
		/*FileReader file = null;
		try {
			file = new FileReader("amazoncsv.csv");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader buffer = new BufferedReader(file);
		String line = "";
		String tableName ="DATA";
		String columns = "id, name, category, avg";
		String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
		String str2 = ");";

		_db.beginTransaction();
		try {
			while ((line = buffer.readLine()) != null) {
			    StringBuilder sb = new StringBuilder(str1);
			    String[] str = line.split(",");
			    sb.append("'" + str[0] + "',");
			    sb.append(str[1] + "',");
			    sb.append(str[2] + "',");
			    sb.append(str[3] + "'");
			    sb.append(str2);
			    _db.execSQL(sb.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_db.setTransactionSuccessful();
		_db.endTransaction();*/
	
	}
	// Called when there is a database version mismatch meaning that the version
	// of the database on disk needs to be upgraded to the current version.
	@Override
	public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) 
	{
			// Log the version upgrade.
			Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
	
	
			// Upgrade the existing database to conform to the new version. Multiple
			// previous versions can be handled by comparing _oldVersion and _newVersion
			// values.
			// The simplest case is to drop the old table and create a new one.
			_db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
			_db.execSQL("DROP TABLE IF EXISTS " + "SEEARCH");
			_db.execSQL("DROP TABLE IF EXISTS " + "DATA");

			// Create a new one.
			onCreate(_db);
	}
	

}
