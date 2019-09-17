package com.battistradadeveloper.smartfarm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.battistradadeveloper.smartfarm.CRUD.Input;
import com.battistradadeveloper.smartfarm.CRUD.SeluruhBeras;

public class MainActivity extends AppCompatActivity {
	GridLayout mainGrid;
	CardView cd_rekomendasi, cd_semua,
			cd_putih, cd_merah,
			cd_hitam, cd_input,
			cd_about, cd_logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mainGrid = findViewById(R.id.mainGrid);

		cd_rekomendasi = findViewById(R.id.card_rekomendasi);
		cd_semua = findViewById(R.id.card_semua);
		cd_semua.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent all_beras = new Intent(MainActivity.this, SeluruhBeras.class);
				startActivity(all_beras);
			}
		});
		cd_putih = findViewById(R.id.card_putih);
		cd_merah = findViewById(R.id.card_merah);
		cd_hitam = findViewById(R.id.card_hitam);

		cd_input = findViewById(R.id.card_input);
		cd_input.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent menu_input = new Intent(MainActivity.this, MenuInput.class);
				startActivity(menu_input);
			}
		});

		cd_about = findViewById(R.id.card_about);

		cd_logout = findViewById(R.id.card_logout);
		cd_logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setMessage("Apakah anda yakin ingin keluar?")
						.setCancelable(false)
						.setPositiveButton("Yakin", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent logoutproses = new Intent(MainActivity.this, MainActivity.class);
								startActivity(logoutproses);
							}
						})
						.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});

	}


}
