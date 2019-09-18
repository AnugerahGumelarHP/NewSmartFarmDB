package com.battistradadeveloper.smartfarm.Admin;

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
import android.widget.Button;
import android.widget.ListView;

import com.battistradadeveloper.smartfarm.CRUD.LihatBeras;
import com.battistradadeveloper.smartfarm.CRUD.UpdateBeras;
import com.battistradadeveloper.smartfarm.Database.DataHelper;
import com.battistradadeveloper.smartfarm.R;

public class BerasMerah extends AppCompatActivity {
	String[] daftar;
	ListView ListView01;
	protected Cursor cursor;
	DataHelper dbcenter;
	public static BerasMerah ma;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beras_merah);

		ma = this;
		dbcenter = new DataHelper(this);
		RefreshList();
	}

	public void RefreshList(){
		SQLiteDatabase db = dbcenter.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM biodata where jenis ='Beras Merah'",null);
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
				final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
				AlertDialog.Builder builder = new AlertDialog.Builder(BerasMerah.this);
				builder.setTitle("Pilihan");
				builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch(item){
							case 0 :
								Intent i = new Intent(getApplicationContext(), LihatBeras.class);
								i.putExtra("nama", selection);
								startActivity(i);
								break;
							case 1 :
								Intent in = new Intent(getApplicationContext(), UpdateBeras.class);
								in.putExtra("nama", selection);
								startActivity(in);
								break;
							case 2 :
								SQLiteDatabase db = dbcenter.getWritableDatabase();
								db.execSQL("delete from biodata where nama = '"+selection+"'");
								RefreshList();
								break;
						}
					}
				});
				builder.create().show();
			}});
		((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
	}

}
