
package com.example.chimerider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class TypeActivity extends Activity {

    public ImageButton imangeButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        imangeButton1 = (ImageButton) findViewById(R.id.imangeButton1);
        imangeButton1.setOnClickListener(imgButtonHandler);
    }
    
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            imangeButton1.setBackgroundResource(R.drawable.health_selected);
            
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.type, menu);
        return true;
    }
    
    public void onRide(View v){
        Intent i = new Intent(this, CountryActivity.class);
        startActivity(i);
    }

}
