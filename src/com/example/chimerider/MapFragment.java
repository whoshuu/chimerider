package com.example.chimerider;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chimerider.util.PathUtil;

public class MapFragment extends Fragment {
	public MapView mapView;
	public Button btnStart;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.map_fragment, container);
	}
	
	@Override
	public void onResume() {
		btnStart = (Button) getActivity().findViewById(R.id.btnStart);
		mapView = (MapView) getActivity().findViewById(R.id.mapview);
        mapView.setClickable(true);
        //mapView.setUseDataConnection(false);
        mapView.setMinZoomLevel(8);
        mapView.setMaxZoomLevel(15);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(12);
        mapView.getController().setCenter(new GeoPoint(-29.302567, 28.483135));
        mapView.getOverlays().addAll(PathUtil.defaultRoads(getActivity()));
        mapView.getOverlays().add(PathUtil.defaultVillages(getActivity(), mapView));
        mapView.getOverlays().add(PathUtil.location1(getActivity(), mapView));
        
        btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				btnStart.setVisibility(View.INVISIBLE);
				((Button) getActivity().findViewById(R.id.btnPause)).setVisibility(View.VISIBLE);
				((Button) getActivity().findViewById(R.id.btnStop)).setVisibility(View.VISIBLE);
				final Handler handle = new Handler();
		        handle.postDelayed(new Runnable() {
			          @Override
			          public void run() {
			              mapView.getOverlays().add(0, PathUtil.constructRoad1(getActivity()));
			              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.rconstructRoad1(getActivity()));
			              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.dconstructRoad1(getActivity()));
			              mapView.getOverlays().remove(mapView.getOverlays().size() - 1);
			              mapView.getOverlays().add(PathUtil.location2(getActivity(), mapView));
			              mapView.getController().setCenter(new GeoPoint(-29.422567, 28.531135));
			              mapView.invalidate();
			          }
			        }, 2000);

				final Handler handler = new Handler();
		        handler.postDelayed(new Runnable() {
		          @Override
		          public void run() {
		              mapView.getOverlays().add(0, PathUtil.constructRoad2(getActivity()));
		              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.rconstructRoad2(getActivity()));
		              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.dconstructRoad2(getActivity()));
		              mapView.getOverlays().remove(mapView.getOverlays().size() - 1);
		              mapView.getOverlays().add(PathUtil.location3(getActivity(), mapView));
		              mapView.getController().setCenter(new GeoPoint(-29.402567, 28.503135));
		              mapView.invalidate();
		          }
		        }, 4000);
		        
		        final Handler handler2 = new Handler();
		        handler2.postDelayed(new Runnable() {
		          @Override
		          public void run() {
		              mapView.getOverlays().add(0, PathUtil.constructRoad3(getActivity()));
		              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.rconstructRoad3(getActivity()));
		              mapView.getOverlays().add(mapView.getOverlays().size() - 6, PathUtil.dconstructRoad3(getActivity()));
		              mapView.getOverlays().remove(mapView.getOverlays().size() - 1);
		              mapView.getOverlays().add(PathUtil.location4(getActivity(), mapView));
		              mapView.getController().setCenter(new GeoPoint(-29.362567, 28.483135));
		              mapView.invalidate();
		          }
		        }, 6000);
			}
        	
        });
        super.onResume();
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
