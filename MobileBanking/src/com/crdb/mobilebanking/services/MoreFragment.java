package com.crdb.mobilebanking.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crdb.mobilebanking.R;
import com.crdb.mobilebanking.support.FragmentHandler;

public class MoreFragment extends FragmentHandler {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View more = inflater.inflate(R.layout.activity_more, container,
				false);
		return more;
	}

}
