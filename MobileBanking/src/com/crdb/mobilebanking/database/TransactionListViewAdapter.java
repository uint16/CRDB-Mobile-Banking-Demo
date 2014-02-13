package com.crdb.mobilebanking.database;

import java.util.ArrayList;

import com.crdb.mobilebanking.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TransactionListViewAdapter extends ArrayAdapter<Transaction>{

	Context context;
	ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
	
	private int lastPosition=-1;


	public TransactionListViewAdapter(Context context, int resourceId, ArrayList<Transaction> transactionList) {

		super(context, resourceId, transactionList);
		this.context = context;	
		this.transactionList=transactionList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;

		ViewHolder holder = null;

		if(row == null)
		{
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.transaction_item, parent, false);
			holder = new ViewHolder();

			holder.id=(TextView) row.findViewById(R.id.tvTransactionID);
			holder.description = (TextView)row.findViewById(R.id.tvDescription);
			holder.date= (TextView)row.findViewById(R.id.tvDate);
			holder.balance= (TextView)row.findViewById(R.id.tvAvailableBalance);
			holder.amount= (TextView)row.findViewById(R.id.tvAmount);
			
			row.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)row.getTag();
			Animation animation = new TranslateAnimation(0, 0, (position > lastPosition) ? 100 : -200, 0);
			animation.setDuration(400);
			convertView.startAnimation(animation);
		}

		Transaction transaction = transactionList.get(position);


		holder.id.setText((Integer.toString(transaction.get_id())));
		holder.description.setText(transaction.getDescription());
		holder.date.setText("Date :"+transaction.getDate());
		holder.balance.setText("Balance :"+transaction.getBalance());
		holder.amount.setText("Amount :"+transaction.getAmount());

		lastPosition=position;
		return row;
	}

	private static class ViewHolder{

		TextView id;
		TextView description;
		TextView date;
		TextView balance;
		TextView amount;

	}
}


