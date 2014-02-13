package com.crdb.mobilebanking.database;

public class Transaction {
	
	
	private int _id;
	private String description;
	private String date;
	private String balance;
	private String amount;
	private int user_id;

	
	

	public Transaction(){
		
	}
	
	public Transaction(int _id,String description,String date,String balance,int user_id,String amount){
		
		this._id=_id;
		this.description=description;
		this.date=date;
		this.balance=balance;
		this.amount=amount;
		this.user_id=user_id;
		
	}

public Transaction(String description,String date,String balance,int user_id,String amount){
		
		this.description=description;
		this.date=date;
		this.balance=balance;
		this.amount=amount;
		this.user_id=user_id;
		
	}
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int get_id() {
		return _id;
	}



	public void set_id(int _id) {
		this._id = _id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getBalance() {
		return balance;
	}



	public void setBalance(String balance) {
		this.balance = balance;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}





}
