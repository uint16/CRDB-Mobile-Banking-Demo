package com.crdb.mobilebanking.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentHandler extends Fragment{

	public abstract View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState);

}
