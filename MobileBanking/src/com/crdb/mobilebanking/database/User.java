package com.crdb.mobilebanking.database;

public class User {
	
	private int _id;
	private String firstName;
	private String lastName;
	private String accounts;
	private String email;
	private String phone;
	
	
	public User(){
		
	}

	public User(int _id,String firstName,String lastname,String accounts,String email,String phone){
		
		this._id=_id;
		this.firstName=firstName;
		this.lastName=lastname;
		this.accounts=accounts;
		this.email=email;
		this.phone=phone;
		
	}

	public User(String firstName,String lastname,String accounts,String email,String phone){
		
	
		this.firstName=firstName;
		this.lastName=lastname;
		this.accounts=accounts;
		this.email=email;
		this.phone=phone;
		
	}


	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
