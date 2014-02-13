package com.crdb.mobilebanking.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.crdb.mobilebanking.CRDBApplication;
import com.crdb.mobilebanking.R;
import com.crdb.mobilebanking.database.TransactionListViewAdapter;
import com.crdb.mobilebanking.support.FragmentHandler;

public class StatementsFragment extends FragmentHandler {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.listview_fragment_statement,
				container, false);

		TransactionListViewAdapter adapter = new TransactionListViewAdapter(
				getActivity(), R.layout.transaction_item,
				CRDBApplication.transactionList);
		ListView clientListView = (ListView) v
				.findViewById(R.id.list_view_transaction);
		clientListView.setAdapter(adapter);

		return v;

	}

}
