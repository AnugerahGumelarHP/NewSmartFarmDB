package com.battistradadeveloper.smartfarm.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "biodataberas.db";
	private static final int DATABASE_VERSION = 1;
	public DataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table biodata(no integer primary key, nama text null, jenis text null, " +
				"tahun text null, harga text null, deskripsi text null, penjual text null, alamat text null);";
		Log.d("Data", "onCreate: " + sql);
		db.execSQL(sql);
		sql = "INSERT INTO biodata (no, nama, jenis, tahun, harga, deskripsi, penjual, alamat) " +
				"VALUES ('1', 'Cap Enak','Beras Merah', '2019', '30000','Enak','Aini','50');";
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
