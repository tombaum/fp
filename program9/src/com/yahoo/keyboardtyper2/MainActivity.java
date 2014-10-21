package com.yahoo.keyboardtyper2;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.yahoo.keyboardtyper2.program9.R;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private final LatLng CS = new LatLng(35.654009, -97.472958);
	private final LatLng LIBRARY = new LatLng(35.658353, -97.473679);
	private final LatLng NUC = new LatLng(35.655340, -97.471528);
	
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map  = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.addMarker(new MarkerOptions().position(CS).title("Computer Science"));
		map.addMarker(new MarkerOptions().position(LIBRARY).title("UCO Library"));
		map.addMarker(new MarkerOptions().position(NUC).title("NUC"));

		
		Button buttonCS = (Button) findViewById(R.id.button_cs);
		Button buttonLibrary = (Button) findViewById(R.id.button_library);
		Button buttonNUC = (Button) findViewById(R.id.button_NUC);

		buttonNUC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				// zoom level 2 ~ 21
				CameraUpdate update = CameraUpdateFactory.newLatLngZoom(NUC, 19);
				map.animateCamera(update);				
			}
		});
		
		buttonCS.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				// zoom level 2 ~ 21
				CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CS, 19);
				map.animateCamera(update);				
			}
		});
		
		buttonLibrary.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LIBRARY, 19);
				map.animateCamera(update);				
			}
		});
		
	}

}
