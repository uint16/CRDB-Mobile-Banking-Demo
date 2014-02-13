package com.crdb.mobilebanking.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crdb.mobilebanking.R;
import com.fima.cardsui.objects.Card;

public class MyImageCard extends Card {
	String email, phone, status,firstName,lastName;
	
	public MyImageCard(String title, int image){
		super(title, image);
	}
	
	public MyImageCard(String title, int image, String _email, String _phone, String _status){
		super(title, image);
		email = _email;
		phone = _phone;
		status = _status;
	}


	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_picture, null);

		((TextView) view.findViewById(R.id.title)).setText(title);
		((TextView) view.findViewById(R.id.phone)).setText(phone);
		((TextView) view.findViewById(R.id.email)).setText(email);
		((TextView) view.findViewById(R.id.status)).setText("Account status: " + status);
	
		((ImageView) view.findViewById(R.id.imageView1)).setImageResource(image);
		
		return view;
	}	
	
}
