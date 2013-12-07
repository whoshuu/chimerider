package com.example.chimerider;


import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup parent, Bundle savedInstanceState ) {
		ResourceProxyImpl mResourceProxy = new ResourceProxyImpl(getActivity());
        MapView mapView = new MapView(getActivity(), 256, mResourceProxy);
        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setClickable(true);
        mapView.setUseDataConnection(false);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(10);
        mapView.getController().setCenter(new GeoPoint(28.393135, -29.302567));
        return mapView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
