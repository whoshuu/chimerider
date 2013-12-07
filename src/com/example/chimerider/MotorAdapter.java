package com.example.chimerider;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MotorAdapter extends ArrayAdapter<Motor>{

    public MotorAdapter(Context context, List<Motor> motors) {
        super(context, 0, motors);
        // TODO Auto-generated constructor stub
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        
        Motor motorInfo = getItem(position); 
        
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.motor_item, null);
        }

        TextView tvCat = (TextView) view.findViewById(R.id.tvCat);
        TextView tvTime = (TextView) view.findViewById(R.id.tvTime);
        tvCat.setText(motorInfo.getCategory());
        tvTime.setText(motorInfo.getTime());
        return view;
    }


}
