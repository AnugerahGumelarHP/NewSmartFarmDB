package com.battistradadeveloper.smartfarm.CRUD;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.battistradadeveloper.smartfarm.Database.DataHelper;
import com.battistradadeveloper.smartfarm.R;

public class LihatBeras extends AppCompatActivity {
	protected Cursor cursor;
	DataHelper dbHelper;
	TextView no, name, price, description, penjual, alamat, type, year;
	Button back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lihat_beras);

		dbHelper = new DataHelper(this);
		no = findViewById(R.id.txt_detail_no);
		name = findViewById(R.id.txt_detail_nama);
		type = findViewById(R.id.txt_detail_jenis);
		year = findViewById(R.id.txt_detail_tahun);
		price = findViewById(R.id.txt_detail_harga);
		description = findViewById(R.id.txt_detail_deskripsi);
		penjual = findViewById(R.id.txt_detail_penjual);
		alamat = findViewById(R.id.txt_detail_alamat);

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
				getIntent().getStringExtra("nama") + "'",null);
		cursor.moveToFirst();
		if (cursor.getCount()>0)
		{
			cursor.moveToPosition(0);
			no.setText(cursor.getString(0));
			name.setText(cursor.getString(1));
			type.setText(cursor.getString(2));
			year.setText(cursor.getString(3));
			price.setText(cursor.getString(4));
			description.setText(cursor.getString(5));
			penjual.setText(cursor.getString(6));
			alamat.setText(cursor.getString(7));
		}
		back = (Button) findViewById(R.id.btn_back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}
}
