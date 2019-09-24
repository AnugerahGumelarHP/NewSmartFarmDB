package com.battistradadeveloper.smartfarm.Pembeli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.battistradadeveloper.smartfarm.R;

public class Home extends Fragment {
	CardView cv_putih, cv_merah, cv_hitam, cv_semua;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		return view;
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		cv_semua = view.findViewById(R.id.cv_pembeli_semua);
		cv_semua.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent semua_pembeli = new Intent(getActivity(), Discover_Rice.class);
				startActivity(semua_pembeli);
			}
		});

	}
}
