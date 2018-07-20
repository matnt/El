package com.elcom.trafficgoelcom.notificationstatus.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.elcom.trafficgoelcom.R;
import com.elcom.trafficgoelcom.notificationstatus.adapter.CustomListviewAdapter;
import com.elcom.trafficgoelcom.notificationstatus.model.DataModel;

import java.util.ArrayList;


public class Fragment_notificationEarly extends Activity {

    private static final String TAG = "Fragment_notificationEarly";

    // widget
    private FloatingActionButton btnAdd;
    private ListView listView;

    //
    ArrayList<DataModel> arrDataModel = new ArrayList<>();
    DataModel dataModel = new DataModel();
    private static CustomListviewAdapter adapter;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_early_warning_time);

        //arrDataModel = new ArrayList<>();
        btnAdd = findViewById(R.id.add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Fragment_notificationEarly.this,Set_date_time_activity.class);
                startActivity(i);
            }
        });

        listView = findViewById(R.id.list_view);

        dataModel = (DataModel) getIntent().getSerializableExtra("DataModel");

        //arrDataModel.add(dataModel);
        arrDataModel.add(new DataModel("14:05","Thứ 2, 23, Th 7, 2018", false));
        arrDataModel.add(new DataModel("14:19","Thứ 4, 25, Th 7, 2018", true));
        arrDataModel.add(new DataModel("14:20","Thứ 5, 26, Th 7, 2018", false));
        arrDataModel.add(new DataModel("14:56","Thứ 6, 27, Th 7, 2018", true));
        adapter = new CustomListviewAdapter(arrDataModel, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel dataModel = arrDataModel.get(position);
                Intent intent = new Intent(Fragment_notificationEarly.this, Set_date_time_activity.class);
                intent.putExtra("data", dataModel);
                startActivity(intent);
            }
        });

    }



}
