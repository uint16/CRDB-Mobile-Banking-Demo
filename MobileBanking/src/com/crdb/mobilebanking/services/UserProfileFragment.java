package com.crdb.mobilebanking.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crdb.mobilebanking.CRDBApplication;
import com.crdb.mobilebanking.R;
import com.crdb.mobilebanking.support.FragmentHandler;
import com.crdb.mobilebanking.ui.BalanceCard;
import com.crdb.mobilebanking.ui.MyImageCard;
import com.fima.cardsui.views.CardUI;

public class UserProfileFragment extends FragmentHandler {

	CardUI mCardView;
	String firstAndLastName,phone,email,account;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		firstAndLastName=CRDBApplication.user.getFirstName()+ " "+ CRDBApplication.user.getLastName();
		phone=CRDBApplication.user.getPhone();
		email=CRDBApplication.user.getEmail();
		account=CRDBApplication.user.getAccounts();

		View profile = inflater.inflate(R.layout.activity_profile, container,
				false);

		mCardView = (CardUI) profile.findViewById(R.id.cardsview);

		mCardView.setSwipeable(false);

		//create cards from database, static data for testing purposed
		
		MyImageCard testcard = new MyImageCard( firstAndLastName,R.drawable.ic_launcher,email, phone, "Active");
		
		
		BalanceCard test2 = new BalanceCard(account, 123498.34, 113498.34);
		
		mCardView.addCard(testcard);
		mCardView.addCard(test2);
		
		mCardView.refresh();
		return profile;
	}

}
