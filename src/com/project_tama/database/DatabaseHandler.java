package com.project_tama.database;

import java.util.ArrayList;
import java.util.List;

import com.project_tama.tamamon.Tamamon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper{

	//Database version
	private static final int DATABASE_VERSION = 3;
	//Database name
	private static final String DATABASE_NAME = "tamamon";
	//Tamamons table name
	private static final String TABLE_TAMAMONS = "tamamons";
	//Tatamons table columns names
	private static final String KEY_ID = "id";
	private static final String KEY_TAMA_ID = "tamaid";
	private static final String KEY_NAME = "name";
	private static final String KEY_LIFE = "life";
	private static final String KEY_ENERGY = "energy";

	public DatabaseHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TAMAMONS_TABLE = "CREATE TABLE " + TABLE_TAMAMONS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY,"
				+ KEY_TAMA_ID + " INTEGER,"
				+ KEY_NAME + " TEXT,"
				+ KEY_LIFE + " INTEGER,"
				+ KEY_ENERGY + " INTEGER" + ")";
		db.execSQL(CREATE_TAMAMONS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHandler.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAMAMONS);
		onCreate(db);
	}

	//CRUD operations
	//Adding new tamamon
	public void addTamamon(Tamamon tamamon){
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_TAMA_ID, tamamon.getTamaId());
	    values.put(KEY_NAME, tamamon.getName());
	    values.put(KEY_LIFE, tamamon.getEnergy());
	    values.put(KEY_ENERGY, tamamon.getLife());
	 
	    // Inserting Row
	    db.insert(TABLE_TAMAMONS, null, values);
	    db.close();
	}

	//Getting single tamamon
	public Tamamon getTamamon(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
        Cursor cursor = db.query(TABLE_TAMAMONS, new String[] { KEY_ID,
        		KEY_TAMA_ID, KEY_NAME, KEY_LIFE, KEY_ENERGY }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        
        Tamamon Tamamon = new Tamamon(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
        		cursor.getString(2), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
        		
        return Tamamon;	
	}

	// Getting all tamamons
	public List<Tamamon> getAllTamamons() {
		List<Tamamon> TamamonList = new ArrayList<Tamamon>();
        String selectQuery = "SELECT  * FROM " + TABLE_TAMAMONS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tamamon Tamamon = new Tamamon();
                Tamamon.setId(Integer.parseInt(cursor.getString(0)));
                Tamamon.setTamaId(Integer.parseInt(cursor.getString(1)));
                Tamamon.setName(cursor.getString(2));
                Tamamon.setLife(Integer.parseInt(cursor.getString(3)));
                Tamamon.setEnergy(Integer.parseInt(cursor.getString(4)));
                // Adding Tamamon to list
                TamamonList.add(Tamamon);
            } while (cursor.moveToNext());
        }
 
        return TamamonList;
	}

	// Getting tamamons count
	public int getTamamonsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_TAMAMONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
	}
	
	// Updating single tamamon
	public int updateTamamon(Tamamon tamamon) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, tamamon.getName());
        values.put(KEY_LIFE, tamamon.getLife());
        values.put(KEY_ENERGY, tamamon.getEnergy());
 
        // updating row
        return db.update(TABLE_TAMAMONS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(tamamon.getId()) });
	}

	// Deleting single tamamon
	public void deleteTamamon(Tamamon tamamon) {
		 SQLiteDatabase db = this.getWritableDatabase();
	        db.delete(TABLE_TAMAMONS, KEY_ID + " = ?",
	                new String[] { String.valueOf(tamamon.getId()) });
	        db.close();
	}

}
