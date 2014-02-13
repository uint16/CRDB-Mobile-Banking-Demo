package com.crdb.mobilebanking.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.crdb.mobilebanking.R;
import com.crdb.mobilebanking.support.FragmentHandler;
import com.crdb.mobilebanking.ui.SearchCard;
import com.fima.cardsui.views.CardUI;

public class HomeFragment extends FragmentHandler {

	CardUI mCardView;
	Spinner region, service;
	Button search;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View home = inflater.inflate(R.layout.activity_home, container, false);
		
		mCardView = (CardUI) home.findViewById(R.id.cardsview);
		mCardView.setSwipeable(false);
		
		
		region = (Spinner) home.findViewById(R.id.spSearchRegion);
		service = (Spinner) home.findViewById(R.id.spSearchService);
		search = (Button) home.findViewById(R.id.btSearch);
		
//		search.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				
//				
//			}
//		});
		
		SearchCard testCard = new SearchCard("ATM and Branch Locator");

		mCardView.addCard(testCard);
		mCardView.refresh();
		
		return home;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	

}
