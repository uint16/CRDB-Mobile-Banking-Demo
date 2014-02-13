package com.crdb.mobilebanking.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.crdb.mobilebanking.R;
import com.fima.cardsui.objects.Card;

public class SearchCard extends Card{
	
	TextView title;
	String cardTitle;
	
	public SearchCard(String _title){
		super(_title);
		cardTitle = _title;
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_search, null);
		
		title = (TextView) view.findViewById(R.id.title);
		title.setText(cardTitle);
		
		return view;
	}

}
