package com.example.chimerider;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chimerider.util.PathUtil;

public class MapFragment extends Fragment {
	public MapView mapView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.map_fragment, container);
	}
	
	@Override
	public void onResume() {
		mapView = (MapView) getActivity().findViewById(R.id.mapview);
        mapView.setClickable(true);
        //mapView.setUseDataConnection(false);
        mapView.setMinZoomLevel(8);
        mapView.setMaxZoomLevel(15);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(12);
        mapView.getController().setCenter(new GeoPoint(-29.302567, 28.483135));
        mapView.getOverlays().addAll(PathUtil.defaultRoads(getActivity()));
        //mapView.getOverlays().add(new ScaleBarOverlay(getActivity()));
        mapView.getOverlays().add(PathUtil.defaultVillages(getActivity(), mapView));
        //caleBarOverlay scale = new ScaleBarOverlay(getActivity(), new ResourceProxyImpl(getActivity()));
        //scale.setScaleBarOffset(10,  10);
        //mapView.getOverlays().add(scale);
        
        //Animate this
        mapView.getOverlays().add(0, PathUtil.constructRoad1(getActivity()));
        mapView.getOverlays().add(mapView.getOverlays().size() - 5, PathUtil.rconstructRoad1(getActivity()));
        
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
          @Override
          public void run() {
              mapView.getOverlays().add(0, PathUtil.constructRoad2(getActivity()));
              mapView.getOverlays().add(mapView.getOverlays().size() - 5, PathUtil.rconstructRoad2(getActivity()));
              mapView.invalidate();
          }
        }, 2000);
        
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
          @Override
          public void run() {
              mapView.getOverlays().add(0, PathUtil.constructRoad3(getActivity()));
              mapView.getOverlays().add(mapView.getOverlays().size() - 5, PathUtil.rconstructRoad3(getActivity()));
              mapView.invalidate();
          }
        }, 4000);
        //mapView.getOverlays().add( 0, PathUtil.constructRoad3(getActivity()));
        //mapView.getOverlays().add(mapView.getOverlays().size() - 5, PathUtil.rconstructRoad3(getActivity()));
        super.onResume();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
