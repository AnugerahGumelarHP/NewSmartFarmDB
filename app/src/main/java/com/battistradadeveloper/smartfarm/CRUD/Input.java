package com.battistradadeveloper.smartfarm.CRUD;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.smartfarm.Admin.SeluruhBeras;
import com.battistradadeveloper.smartfarm.Database.DataHelper;
import com.battistradadeveloper.smartfarm.R;

public class Input extends AppCompatActivity {
	protected Cursor cursor;
	DataHelper dbHelper;
	EditText no, name, price, description, penjual, alamat;
	Spinner type, year;
	TextView save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		dbHelper = new DataHelper(this);

		no = findViewById(R.id.edt_input_nomor);
		name = findViewById(R.id.edt_input_nama);
		price = findViewById(R.id.edt_input_harga);
		description = findViewById(R.id. edt_input_deskripsi);
		penjual = findViewById(R.id.edt_input_nama_penjual);
		alamat = findViewById(R.id.edt_input_alamat_penjual);

		type = findViewById(R.id.spinnerType);
		year = findViewById(R.id.spinnerYear);

		save = findViewById(R.id.fitur_input_simpan);
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(Input.this, "Simpan data",Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.execSQL("insert into biodata(no, nama, jenis, tahun, harga, deskripsi, penjual, alamat) values('" +
						no.getText().toString() + "','" +
						name.getText().toString() + "','" +
						type.getSelectedItem().toString() + "','" +
						year.getSelectedItem().toString() + "','" +
						price.getText().toString() + "','" +
						description.getText().toString() + "','" +
						penjual.getText().toString() + "','" +
						alamat.getText().toString() + "')");
				Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
				SeluruhBeras.ma.RefreshList();
				finish();
			}
		});

	}
}
