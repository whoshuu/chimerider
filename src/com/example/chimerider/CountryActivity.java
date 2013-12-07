
package com.example.chimerider;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class CountryActivity extends Activity {
    private ListView lvCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        CountryAdapter adapter = new CountryAdapter(getBaseContext(), Country.countryInfoGen());
        lvCountry = (ListView) findViewById(R.id.lvCountry);
        lvCountry.setAdapter(adapter);
        lvCountry.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
                Intent i = new Intent(getBaseContext(), StatsActivity.class);
              startActivity(i);
            }
           
            
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.country, menu);
        return true;
    }

}
