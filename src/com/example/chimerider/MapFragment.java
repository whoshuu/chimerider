package com.example.chimerider;


import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MapFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.map_fragment, container);
	}
	
	@Override
	public void onResume() {
		MapView mapView = (MapView) getActivity().findViewById(R.id.mapview);
        mapView.setClickable(true);
        mapView.setUseDataConnection(false);
        mapView.setMinZoomLevel(8);
        mapView.setMaxZoomLevel(15);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(12);
        mapView.getController().setCenter(new GeoPoint(-29.302567, 28.483135));
        //return mapView;
        super.onResume();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
