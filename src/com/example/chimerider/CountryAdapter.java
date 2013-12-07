package com.example.chimerider;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryAdapter extends ArrayAdapter<Country>{

    public CountryAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
        // TODO Auto-generated constructor stub
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        
        Country countyInfo = getItem(position); 
        
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.country_item, null);
        }

        TextView tvCountry = (TextView) view.findViewById(R.id.tvCountry);
        TextView tvPopulation = (TextView) view.findViewById(R.id.tvPopulation);
        TextView tvMiles = (TextView) view.findViewById(R.id.tvMiles);
        tvCountry.setText(countyInfo.getName());
        tvPopulation.setText(countyInfo.getPopulation());
        tvMiles.setText(countyInfo.getMiles());
        return view;
    }
}
