package com.crdb.mobilebanking.ui;

import java.math.BigDecimal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.crdb.mobilebanking.R;
import com.fima.cardsui.objects.Card;

public class BalanceCard extends Card {

	TextView actualBalance, availableBalance, title;
	String accNo;
	BigDecimal availableAmount, actualAmount;
	
	public BalanceCard(String accountNumber, double available, double actual){
		super(accountNumber);
		accNo = accountNumber;
		availableAmount = new BigDecimal(available);
		actualAmount = new BigDecimal(actual);
	}
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_balance, null);
		
		title = (TextView) view.findViewById(R.id.title);
		actualBalance = (TextView) view.findViewById(R.id.tvActualAmount);
		availableBalance = (TextView) view.findViewById(R.id.tvAvailableAmount);
		
		title.setText(accNo);
		actualBalance.setText(""+ actualAmount.intValue());		
		availableBalance.setText(""+ availableAmount.intValue());
		
		return view;
	}

}
