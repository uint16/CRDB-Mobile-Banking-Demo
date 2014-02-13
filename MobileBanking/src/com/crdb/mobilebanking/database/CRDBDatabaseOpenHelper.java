package com.crdb.mobilebanking.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CRDBDatabaseOpenHelper extends SQLiteOpenHelper {

	//All Static Variables

	//Database path
	public static final String DATABASE_PATH="/data/data/com.crdb.mobilebanking/databases/";
	//Name of the database
	public static final String DATABASE_NAME ="crdb.db";
	//Name of the database table 1
	public static final String DATABASE_TABLE_NAME_1="users";
	//Name of the database table 2
	public static final String DATABASE_TABLE_NAME_2="transactions";
	//Column id. _id used to comply with android requirements
	public static final String COLUMN_ID="_id";
	
	public static final String COLUMN_FIRST_NAME="first_name";

	public static final String COLUMN_LAST_NAME="last_name";
	
	public static final String COLUMN_ACCOUNTS="accounts";
	
	public static final String COLUMN_EMAIL="email";
	
	public static final String COLUMN_PHONE="phone";

	public static final String COLUMN_DESCRIPTION="description";
	
	public static final String COLUMN_DATE="date";
	
	public static final String COLUMN_BALANCE="balance";
	
	public static final String COLUMN_USER_ID="user_id";
	
	
	public static final String COLUMN_AMOUNT="amount";
	//Version of the database
	public  static final int DATABASE_VERSION = 1;
	//Exact Path to the database
	public static final String EXACT_PATH=DATABASE_PATH+DATABASE_NAME;

	private SQLiteDatabase database;

	private Context context;

	public CRDBDatabaseOpenHelper(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context=context;

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		/*This sql  statement will create a table and set all the fields with specific types of data
		 * Called the first time when the app is launched
		 * Will not be called again if the database already exists*/
		String createDatabaseTable_1 ="create table "+ DATABASE_TABLE_NAME_1 + " (" 
				+ COLUMN_ID + " integer primary key autoincrement, " 
				+ COLUMN_FIRST_NAME + " text not null, "
				+ COLUMN_LAST_NAME + " text not null, "
				+ COLUMN_ACCOUNTS + " text not null, "
				+ COLUMN_EMAIL + " text not null, "
				+ COLUMN_PHONE + " text not null" + ");";

		String createDatabaseTable_2 ="create table "+ DATABASE_TABLE_NAME_2 + " (" 
				+ COLUMN_ID + " integer primary key autoincrement, " 
				+ COLUMN_DESCRIPTION + " text not null, "
				+ COLUMN_DATE + " text not null, "
				+ COLUMN_BALANCE + " text not null, "
				+ COLUMN_USER_ID + " integer not null, "				
				+ COLUMN_AMOUNT + " text not null" + ");";

		db.execSQL(createDatabaseTable_1);
		db.execSQL(createDatabaseTable_2);


	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		/*
		 * This method will be called only when the database is upgraded*/

		//Drop older table if it exists
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME_1);
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME_2);

		//create the table again
		onCreate(db);

	}

	//Adding a user to  users table of the database
	public void addUserToUsersTable(User user){

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = addInfo(user);

		//Inserting a row

		db.insert(DATABASE_TABLE_NAME_1, null, values);

		db.close();//closing database connection


	}

	//Adding a transaction table of the database
	public void addTransactionToTransactionTable(Transaction transaction){

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = addInfo(transaction);

		//Inserting a row

		db.insert(DATABASE_TABLE_NAME_2, null, values);
		db.close();//closing database connection


	}


	// Getting All Users From Users table
	public List<User> getAllUsersFromUsersTable() {
		List<User> userList = new ArrayList<User>();
		// Select All Query
		String selectQuery = "SELECT * FROM "+DATABASE_TABLE_NAME_1+" ORDER BY "+COLUMN_ID;

		SQLiteDatabase db = this.getWritableDatabase();

	
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {

			do {

				User user = new User();
				user.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
				user.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
				user.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME)));
				user.setAccounts(cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNTS)));
				user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
				user.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)));

				// Adding user to list
				userList.add(user);

			} while (cursor.moveToNext());

		}
		cursor.close();
		// close inserting data from database
		db.close();
		// return client list
		Log.i("Executed","table1");
		return userList;

	}
	
	public User getUser(int key) {
		
		// Select All Query
		String selectQuery = "SELECT * FROM "+DATABASE_TABLE_NAME_1+" ORDER BY "+COLUMN_ID;

		SQLiteDatabase db = this.getWritableDatabase();

	
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {

			do {
				
				if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID)))==key){
				
			    User user = new User();
			    
				user.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
				user.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
				user.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME)));
				user.setAccounts(cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNTS)));
				user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
				user.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)));

				return user;
				
				}
				

			} while (cursor.moveToNext());

		}
		cursor.close();
		
		db.close();
		
		return null;

	}

	// Getting All Transactions From transaction table
	public ArrayList<Transaction> getAllTransactions(int user_id) {
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>(); 
		// Select All Query

		String selectQuery = "SELECT * FROM "+DATABASE_TABLE_NAME_2+" ORDER BY "+COLUMN_ID;

		SQLiteDatabase db = this.getWritableDatabase();

		Log.i("Executed","table2");
		Cursor cursor = db.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {

			do {
				if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)))==user_id){

				Transaction transaction = new Transaction();
				transaction.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
				transaction.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
				transaction.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
				transaction.setBalance(cursor.getString(cursor.getColumnIndex(COLUMN_BALANCE)));
				transaction.setAmount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));

				// Adding transaction to list
				transactionList.add(transaction);
				}

			} while (cursor.moveToNext());

		}
		cursor.close();
		// close inserting data from database
		db.close();
		// return client list
		return transactionList;

	}

	private ContentValues addInfo(User user) {

		ContentValues values = new ContentValues();	
		values.put(COLUMN_FIRST_NAME, user.getFirstName());
		values.put(COLUMN_LAST_NAME, user.getLastName());
		values.put(COLUMN_ACCOUNTS, user.getAccounts());
		values.put(COLUMN_EMAIL, user.getEmail());
		values.put(COLUMN_PHONE, user.getPhone());
		
		return values;
	}

	private ContentValues addInfo(Transaction transaction) {

		ContentValues values = new ContentValues();	
		values.put(COLUMN_DESCRIPTION, transaction.getDescription());
		values.put(COLUMN_DATE, transaction.getDate());
		values.put(COLUMN_BALANCE, transaction.getBalance());
		values.put(COLUMN_USER_ID, transaction.getUser_id());
		values.put(COLUMN_AMOUNT, transaction.getAmount());
		
		return values;
	}
	public void createEmptyDatabase() throws IOException{
		/*
		 * This method creates an empty database in the system and overwrites it with the
		 * provided populated database from the assets folder*/

		boolean databaseExists=verifyDatabaseExistence();

		if(databaseExists){
			//do nothing because the database already exists
		}else{

			/*
			 * By executing this block an empty database will be created into the default system path 
			 * of Digicom application i.e /data/data/com.gottibujiku.adigicom.android.ui/databases/
			 * So that it will be possible to overwrite that database with the pre-populated database*/
			this.getWritableDatabase();

			try{

				overwriteDatabase();

			}catch (IOException e){

				throw new Error("Error Overwriting Database");
			}


		}


	}

	private void overwriteDatabase() throws IOException{

		/*
		 * Copies the database from the local assets folder and overwrites the created empty database
		 * in the system path of the application where it can handled and used
		 * This is done by transferring byte stream*/

		//Open your local database as the input stream
		InputStream inputDatabaseStream =context.getAssets().open(DATABASE_NAME);

		//Open the empty database as the output stream
		OutputStream outputDatabaseStream = new FileOutputStream(EXACT_PATH);

		//Transfer bytes from the inputDatabaseStream to OutputDatabaseStream

		byte[] buffer = new byte[1024];
		int length;
		while((length=inputDatabaseStream.read(buffer))>0){

			outputDatabaseStream.write(buffer,0,length);

		}

		//Close the streams
		outputDatabaseStream.flush();
		outputDatabaseStream.close();
		inputDatabaseStream.close();

	}

	private boolean verifyDatabaseExistence() {

		database=null;

		try{

			database = SQLiteDatabase.openDatabase(EXACT_PATH,null,SQLiteDatabase.OPEN_READONLY);

		}catch(SQLiteException e){

			//Database does not exist yet 
			return false;
		}


		database.close();
		return true;
	}

	@Override
	public synchronized void close(){

		if(database!=null){

			database.close();

		}

		super.close();
	}

	public void openDatabase(){

		SQLiteDatabase db = this.getWritableDatabase();

	}
}
