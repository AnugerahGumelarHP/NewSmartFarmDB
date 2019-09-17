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

import com.battistradadeveloper.smartfarm.Database.DataHelper;
import com.battistradadeveloper.smartfarm.R;

public class UpdateBeras extends AppCompatActivity {
	protected Cursor cursor;
	DataHelper dbHelper;
	TextView update_beras;
	EditText no, name, price, description, penjual, alamat;
	Spinner type, year;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_beras);
		dbHelper = new DataHelper(this);

		no = findViewById(R.id.edt_input_nomor);
		name = findViewById(R.id.edt_input_nama);
		price = findViewById(R.id.edt_input_harga);
		description = findViewById(R.id. edt_input_deskripsi);
		penjual = findViewById(R.id.edt_input_nama_penjual);
		alamat = findViewById(R.id.edt_input_alamat_penjual);

		type = findViewById(R.id.spinnerType);
		year = findViewById(R.id.spinnerYear);

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
				getIntent().getStringExtra("nama") + "'",null);
		cursor.moveToFirst();
		if (cursor.getCount()>0)
		{
			cursor.moveToPosition(0);
			no.setText(cursor.getString(0));
			name.setText(cursor.getString(1));

			//TODO belum tau fitur apa yang digunakan untuk memanggil data spinner, ini penyebab force close
			type.getParent();
			year.getParent();

			price.setText(cursor.getString(4));
			description.setText(cursor.getString(5));
			penjual.setText(cursor.getString(6));
			alamat.setText(cursor.getString(7));
		}

		update_beras = findViewById(R.id.fitur_input_simpan);
		update_beras.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.execSQL("update biodata set nama='"+
						name.getText().toString() +"', jenis='" +
						type.getSelectedItem().toString()+"', tahun='"+
						year.getSelectedItem().toString() +"', harga='" +
						price.getText().toString() +"', deskripsi='" +
						description.getText().toString() +"', penjual='" +
						penjual.getText().toString() +"', alamat='" +
						alamat.getText().toString() + "' where no='" +
						no.getText().toString()+"'");
				Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
				SeluruhBeras.ma.RefreshList();
				finish();
			}
		});
	}
}
