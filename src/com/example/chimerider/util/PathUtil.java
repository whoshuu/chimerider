package com.example.chimerider.util;

import java.util.ArrayList;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.bonuspack.overlays.ExtendedOverlayItem;
import org.osmdroid.bonuspack.overlays.ItemizedOverlayWithBubble;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.PathOverlay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.example.chimerider.R;

public class PathUtil {
	public static ArrayList<Overlay> defaultRoads(Context context) {
        PathOverlay path12 = new PathOverlay(Color.rgb(50, 50, 50), context);
        PathOverlay path23 = new PathOverlay(Color.rgb(50, 50, 50), context);
        PathOverlay path34 = new PathOverlay(Color.rgb(50, 50, 50), context);
        PathOverlay path45 = new PathOverlay(Color.rgb(50, 50, 50), context);
        PathOverlay path51 = new PathOverlay(Color.rgb(50, 50, 50), context);

        PathOverlay rPath12 = new PathOverlay(Color.rgb(255, 255, 255), context);
        PathOverlay rPath23 = new PathOverlay(Color.rgb(255, 255, 255), context);
        PathOverlay rPath34 = new PathOverlay(Color.rgb(255, 255, 255), context);
        PathOverlay rPath45 = new PathOverlay(Color.rgb(255, 255, 255), context);
        PathOverlay rPath51 = new PathOverlay(Color.rgb(255, 255, 255), context);
        GeoPoint gp1 = new GeoPoint(-29.422567, 28.403135);
        GeoPoint gp2 = new GeoPoint(-29.362567, 28.483135);
        GeoPoint gp3 = new GeoPoint(-29.392567, 28.353135);
		GeoPoint gp4 = new GeoPoint(-29.407567, 28.453135);
		GeoPoint gp5 = new GeoPoint(-29.452567, 28.533135);
        Paint paint = path12.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path12.setAlpha(255);
        path12.addPoint(gp1);
        path12.addPoint(gp4);
        
        
        paint = path23.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path23.setAlpha(255);
        path23.addPoint(gp2);
        path23.addPoint(gp3);

        
        paint = path34.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path34.setAlpha(255);
        path34.addPoint(gp3);
        path34.addPoint(gp1);

        
        paint = path45.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path45.setAlpha(255);
        path45.addPoint(gp4);
        path45.addPoint(gp5);

        paint = path51.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path51.setAlpha(255);
        path51.addPoint(gp4);
        path51.addPoint(gp2);

        paint = rPath12.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath12.setAlpha(255);
        rPath12.addPoint(gp1);
        rPath12.addPoint(gp4);

        paint = rPath23.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath23.setAlpha(255);
        rPath23.addPoint(gp2);
        rPath23.addPoint(gp3);

        paint = rPath34.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath34.setAlpha(255);
        rPath34.addPoint(gp3);
        rPath34.addPoint(gp1);

        paint = rPath45.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath45.setAlpha(255);
        rPath45.addPoint(gp4);
        rPath45.addPoint(gp5);

        paint = rPath51.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath51.setAlpha(255);
        rPath51.addPoint(gp4);
        rPath51.addPoint(gp2);
        
        ArrayList<Overlay> paths = new ArrayList<Overlay>();
        paths.add(path12);
        paths.add(path23);
        paths.add(path34);
        paths.add(path45);
        paths.add(path51);
        paths.add(rPath12);
        paths.add(rPath23);
        paths.add(rPath34);
        paths.add(rPath45);
        paths.add(rPath51);
        return paths;
	}
	
	public static Overlay defaultVillages(Context context, MapView map) {
		Drawable marker = context.getResources().getDrawable(R.drawable.marker_poi_default);
		ItemizedOverlayWithBubble<ExtendedOverlayItem> overlay = new ItemizedOverlayWithBubble<ExtendedOverlayItem>(context, new ArrayList<ExtendedOverlayItem>(), map);
				//new ItemizedOverlayWithBubble<OverlayItem>(
				//new ArrayList<OverlayItem>(), marker, null, new DefaultResourceProxyImpl(context));
		GeoPoint gp = new GeoPoint(-29.422567, 28.403135);
		ExtendedOverlayItem item = new ExtendedOverlayItem("Hello", "World", gp, context);
		item.setMarker(marker);
		GeoPoint gp2 = new GeoPoint(-29.362567, 28.483135);
		ExtendedOverlayItem item2 = new ExtendedOverlayItem("Hi", "World", gp2, context);
		item2.setMarker(marker);
		GeoPoint gp3 = new GeoPoint(-29.392567, 28.353135);
		ExtendedOverlayItem item3 = new ExtendedOverlayItem("Hello", "World", gp3, context);
		item3.setMarker(marker);
		GeoPoint gp4 = new GeoPoint(-29.407567, 28.453135);
		ExtendedOverlayItem item4 = new ExtendedOverlayItem("Hi", "World", gp4, context);
		item4.setMarker(marker);
		GeoPoint gp5 = new GeoPoint(-29.452567, 28.533135);
		ExtendedOverlayItem item5 = new ExtendedOverlayItem("Hi", "World", gp5, context);
		item5.setMarker(marker);
		overlay.addItem(item);
		overlay.addItem(item2);
		overlay.addItem(item3);
		overlay.addItem(item4);
		overlay.addItem(item5);
		
		return overlay;
	}
	
	public static Overlay location1(Context context, MapView map) {
		Drawable marker = context.getResources().getDrawable(R.drawable.marker_poi_default);
		ItemizedIconOverlay<OverlayItem> overlay = new ItemizedIconOverlay<OverlayItem>(new ArrayList<OverlayItem>(), marker, null, new DefaultResourceProxyImpl(context));
		GeoPoint gp = new GeoPoint(-29.452567, 28.533135);
		OverlayItem item = new OverlayItem(null, null, gp);
		item.setMarker(marker);
		overlay.addItem(item);
		
		return overlay;
	}
	
	public static Overlay location2(Context context, MapView map) {
		Drawable marker = context.getResources().getDrawable(R.drawable.marker_poi_default);
		ItemizedIconOverlay<OverlayItem> overlay = new ItemizedIconOverlay<OverlayItem>(new ArrayList<OverlayItem>(), marker, null, new DefaultResourceProxyImpl(context));
		GeoPoint gp = new GeoPoint(-29.422567, 28.531135);
		OverlayItem item = new OverlayItem(null, null, gp);
		item.setMarker(marker);
		overlay.addItem(item);
		
		return overlay;
	}
	
	public static Overlay location3(Context context, MapView map) {
		Drawable marker = context.getResources().getDrawable(R.drawable.marker_poi_default);
		ItemizedIconOverlay<OverlayItem> overlay = new ItemizedIconOverlay<OverlayItem>(new ArrayList<OverlayItem>(), marker, null, new DefaultResourceProxyImpl(context));
		GeoPoint gp = new GeoPoint(-29.402567, 28.503135);
		OverlayItem item = new OverlayItem(null, null, gp);
		item.setMarker(marker);
		overlay.addItem(item);
		
		return overlay;
	}
	

	public static Overlay location4(Context context, MapView map) {
		Drawable marker = context.getResources().getDrawable(R.drawable.marker_poi_default);
		ItemizedIconOverlay<OverlayItem> overlay = new ItemizedIconOverlay<OverlayItem>(new ArrayList<OverlayItem>(), marker, null, new DefaultResourceProxyImpl(context));

        GeoPoint gp = new GeoPoint(-29.362567, 28.483135);
		OverlayItem item = new OverlayItem(null, null, gp);
		item.setMarker(marker);
		overlay.addItem(item);
		
		return overlay;
	}
	
	public static Overlay constructRoad1(Context context) {
        PathOverlay path = new PathOverlay(Color.rgb(50, 50, 50), context);
        GeoPoint end = new GeoPoint(-29.422567, 28.531135);
		GeoPoint start = new GeoPoint(-29.452567, 28.533135);
        Paint paint = path.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path.setAlpha(255);
        path.addPoint(start);
        path.addPoint(end);
        return path;
	}
	
	public static Overlay rconstructRoad1(Context context) {
        PathOverlay rPath = new PathOverlay(Color.rgb(255, 255, 255), context);
        GeoPoint end = new GeoPoint(-29.422567, 28.531135);
		GeoPoint start = new GeoPoint(-29.452567, 28.533135);
        Paint paint = rPath.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath.setAlpha(255);
        rPath.addPoint(start);
        rPath.addPoint(end);
		return rPath;
	}
	

	
	public static Overlay constructRoad2(Context context) {
        PathOverlay path = new PathOverlay(Color.rgb(50, 50, 50), context);
        GeoPoint end = new GeoPoint(-29.402567, 28.503135);
        GeoPoint start = new GeoPoint(-29.422567, 28.531135);
        Paint paint = path.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path.setAlpha(255);
        path.addPoint(start);
        path.addPoint(end);
        return path;
	}
	
	public static Overlay rconstructRoad2(Context context) {
        PathOverlay rPath = new PathOverlay(Color.rgb(255, 255, 255), context);
        GeoPoint end = new GeoPoint(-29.402567, 28.503135);
        GeoPoint start = new GeoPoint(-29.422567, 28.531135);
        Paint paint = rPath.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath.setAlpha(255);
        rPath.addPoint(start);
        rPath.addPoint(end);
		return rPath;
	}
	

	public static Overlay constructRoad3(Context context) {
        PathOverlay path = new PathOverlay(Color.rgb(50, 50, 50), context);
        GeoPoint end = new GeoPoint(-29.362567, 28.483135);
        GeoPoint start = new GeoPoint(-29.402567, 28.503135);
        Paint paint = path.getPaint();
        paint.setStrokeWidth(10.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        path.setAlpha(255);
        path.addPoint(start);
        path.addPoint(end);
        return path;
	}
	
	public static Overlay rconstructRoad3(Context context) {
        PathOverlay rPath = new PathOverlay(Color.rgb(255, 255, 255), context);
        GeoPoint end = new GeoPoint(-29.362567, 28.483135);
        GeoPoint start = new GeoPoint(-29.402567, 28.503135);
        Paint paint = rPath.getPaint();
        paint.setStrokeWidth(8.0f);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rPath.setAlpha(255);
        rPath.addPoint(start);
        rPath.addPoint(end);
		return rPath;
	}
}
