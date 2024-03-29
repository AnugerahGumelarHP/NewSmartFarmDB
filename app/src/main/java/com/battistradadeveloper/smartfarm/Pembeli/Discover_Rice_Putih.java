package com.battistradadeveloper.smartfarm.Pembeli;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.battistradadeveloper.smartfarm.CRUD.LihatBeras;
import com.battistradadeveloper.smartfarm.Database.DataHelper;
import com.battistradadeveloper.smartfarm.R;

public class Discover_Rice_Putih extends AppCompatActivity {
	String[] daftar;
	ListView ListView01;
	protected Cursor cursor;
	DataHelper dbcenter;
	public static Discover_Rice_Putih ma;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discover__rice__putih);

		ma = this;
		dbcenter = new DataHelper(this);
		RefreshList();
	}

	public void RefreshList(){
		SQLiteDatabase db = dbcenter.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM biodata where jenis ='Beras Putih'",null);
		daftar = new String[cursor.getCount()];
		cursor.moveToFirst();
		for (int cc=0; cc < cursor.getCount(); cc++){
			cursor.moveToPosition(cc);
			daftar[cc] = cursor.getString(1);
		}
		ListView01 = findViewById(R.id.listView1);
		ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
		ListView01.setSelected(true);
		ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {


			public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
				final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
				final CharSequence[] dialogitem = {"Lihat Biodata"};
				AlertDialog.Builder builder = new AlertDialog.Builder(Discover_Rice_Putih.this);
				builder.setTitle("Pilihan");
				builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Intent i = new Intent(getApplicationContext(), LihatBeras.class);
							i.putExtra("nama", selection);
							startActivity(i);
						}
					}
				});
				builder.create().show();
			}});
		((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
	}

}
