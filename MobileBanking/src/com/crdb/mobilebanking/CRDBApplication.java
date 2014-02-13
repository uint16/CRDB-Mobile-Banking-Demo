package com.crdb.mobilebanking;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Application;

import com.crdb.mobilebanking.database.CRDBDatabaseOpenHelper;
import com.crdb.mobilebanking.database.Transaction;
import com.crdb.mobilebanking.database.User;


public class CRDBApplication extends Application {
	
	public static ArrayList<Transaction> transactionList;
	public static User user;
	
	public static CRDBDatabaseOpenHelper db;

	@Override
	public void onCreate() {

		super.onCreate();

		db = new CRDBDatabaseOpenHelper(this);
		 
		new Thread(){

			public void run(){

				
				try {
					db.createEmptyDatabase();
				} catch (IOException e) {

				}

		/*Transaction tra = new Transaction( "Drawn", "25/12/2013", "1000.00 Tshs",1, "20.00 Tshs");
		Transaction tra1 = new Transaction("Drawn", "24/12/2011", "100.00 Tshs",2, "2.00 Tshs");
		Transaction tra2 = new Transaction("Drawn", "25/10/2014", "10000000.00 Tshs",3, "20000.00 Tshs");
		Transaction tra3= new Transaction("Drawn", "2/12/2010", "20.00 Tshs",4, "10.00 Tshs");
		Transaction tra4= new Transaction("Drawn", "25/12/2013", "3000.00 Tshs",5, "15.00 Tshs");
		
		for(int i=1;i<=20;i++){
			db.addTransactionToTransactionTable(tra);
			db.addTransactionToTransactionTable(tra1);
			db.addTransactionToTransactionTable(tra2);
			db.addTransactionToTransactionTable(tra3);
			db.addTransactionToTransactionTable(tra4);
		
		}
		*/
		
				
			}
		}.start();
	}


	



	@Override
	public void onTerminate() {

		super.onTerminate();
		db.close();
	}





}



