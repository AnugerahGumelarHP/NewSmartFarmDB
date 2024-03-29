package com.battistradadeveloper.smartfarm.Pembeli;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.battistradadeveloper.smartfarm.R;

public class PembeliActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pembeli);

		// kita set default nya HomeAdmin Fragment
		loadFragment(new Home());
		// inisialisasi BottomNavigaionView
		BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
		// beri listener pada saat item/menu bottomnavigation terpilih
		bottomNavigationView.setOnNavigationItemSelectedListener(this);
	}
	private boolean loadFragment(Fragment fragment) {
		if (fragment != null) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fl_container, fragment)
					.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
		Fragment fragment = null;
		switch (menuItem.getItemId()){
			case R.id.home:
				fragment = new Home();
				break;
			case R.id.account_menu:
				fragment = new Login();
				break;
		}
		return loadFragment(fragment);

	}

}
