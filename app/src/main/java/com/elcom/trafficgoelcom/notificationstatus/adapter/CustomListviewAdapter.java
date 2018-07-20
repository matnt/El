package com.elcom.trafficgoelcom.notificationstatus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.elcom.trafficgoelcom.R;
import com.elcom.trafficgoelcom.notificationstatus.model.DataModel;

import java.util.ArrayList;


public class CustomListviewAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataSet;
    private Context context;

    public static class ViewHolder {
        TextView textTime;
        TextView textDate;
        Switch swTurn;
    }
    public CustomListviewAdapter(ArrayList<DataModel> arr, Context context){
        super(context, R.layout.custom_listview_alarm, arr);
        this.dataSet = arr;
        this.context = context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        DataModel dataModel = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.custom_listview_alarm, parent, false);
            viewHolder.textDate =  convertView.findViewById(R.id.textview_date);
            viewHolder.textTime =  convertView.findViewById(R.id.textview_time);
            viewHolder.swTurn =  convertView.findViewById(R.id.sw_turn);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        lastPosition = position;
        viewHolder.textTime.setText(dataModel.getTime1());
        viewHolder.textDate.setText(dataModel.getDate1());
        viewHolder.swTurn.setChecked(dataModel.isCheck1());

        return convertView;
    }





}
