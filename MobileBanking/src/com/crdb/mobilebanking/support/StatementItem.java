package com.crdb.mobilebanking.support;

import java.math.BigDecimal;

public class StatementItem {

	public StatementItem(){
		
	}
	
	public String getDate(){
		return "";
	}
	
	public String getDescription(){
		return "";
	}
	
	public String getTransactionID(){
		return "";
	}
	
	public String getTimeStamp(){
		return "";
	}
	
	public String getAccount(){
		return "";
	}
	
	public BigDecimal getAmount(){
		BigDecimal amount = new BigDecimal("0.0");
		return amount;
	}
	
}
