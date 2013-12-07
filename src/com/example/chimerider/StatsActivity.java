
package com.example.chimerider;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class StatsActivity extends Activity implements TabListener {

    private LinearLayout llStats;
    private ListView lvMotorInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        
        //GraphView
        llStats = (LinearLayout) findViewById(R.id.llStats);
        
        GraphView graphView = new LineGraphView(this,"");
        GraphViewData[] data = new GraphViewData[]{  
            new GraphViewData(1, 3.5d)  
            , new GraphViewData(2, 4.0d)  
            , new GraphViewData(3, 5.6d)  
            , new GraphViewData(4, 1.7d)  
            , new GraphViewData(5, 1.9d) 
            , new GraphViewData(6, 2.8d) 
            , new GraphViewData(7, 3.5d) 
            , new GraphViewData(8, 3.7d) 
            , new GraphViewData(9, 5.5d) 
            , new GraphViewData(9, 5.5d) 
            , new GraphViewData(10, 5.5d) 
            , new GraphViewData(11, 6.5d) 
            , new GraphViewData(12, 3.5d) 
            , new GraphViewData(13, 4.0d) 
            , new GraphViewData(14, 6.1d) 
            , new GraphViewData(15, 6.2d) 
            , new GraphViewData(16, 6.4d) 
            , new GraphViewData(17, 6.6d) 
            , new GraphViewData(18, 4.5d) 
            , new GraphViewData(19, 5.6d)
      };
         
        GraphViewSeriesStyle lineStyle = new GraphViewSeriesStyle(Color.rgb(90, 250, 00), 5);
        GraphViewSeries exampleSeries = new GraphViewSeries("",lineStyle,data); 
        graphView.addSeries(exampleSeries);      
        graphView.getGraphViewStyle().setGridColor(Color.TRANSPARENT);
        graphView.getGraphViewStyle().setNumHorizontalLabels(1);  
        graphView.getGraphViewStyle().setNumVerticalLabels(1);
        graphView.getGraphViewStyle().setTextSize(1); 
        
        ((LineGraphView) graphView).setDrawBackground(true);
        llStats.addView(graphView);
        
        //ListView
        MotorAdapter adapter = new MotorAdapter(getBaseContext(), Motor.motorInfoGen());
        lvMotorInfo = (ListView) findViewById(R.id.lvMotorInfo);
        lvMotorInfo.setAdapter(adapter);
        
        //tab
        setUpNavigationTabs();
    }

    
    
    
    
    private void setUpNavigationTabs() {
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
        	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        } else {
        	return;
        }
        //showing title bar option
        actionBar.setDisplayShowTitleEnabled(true);
        Tab tabStats = actionBar.newTab().setText("")
                .setTag("Stats")
                .setIcon(R.drawable.ic_launcher)
                .setTabListener((TabListener) this);
        Tab tabMap = actionBar.newTab().setText("")
                .setTag("Map")
                .setIcon(R.drawable.ic_launcher)
                .setTabListener((TabListener) this);
        Tab tabContacts = actionBar.newTab().setText("")
                .setTag("Contacts")
                .setIcon(R.drawable.ic_launcher)
                .setTabListener((TabListener) this);
                    
        
        actionBar.addTab(tabStats);
        actionBar.addTab(tabMap);
        actionBar.addTab(tabContacts);
        actionBar.selectTab(tabStats);
        
    }

    public void onTabSelected(Tab tab) {
        
        if(tab.getTag().equals("Stats")){
            
            Intent i = new Intent(getApplicationContext(),StatsActivity.class);
            startActivity(i);
            
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stats, menu);
        return true;
    }





    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }

}
