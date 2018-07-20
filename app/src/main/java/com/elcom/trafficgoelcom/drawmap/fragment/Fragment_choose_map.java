package com.elcom.trafficgoelcom.drawmap.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.elcom.trafficgoelcom.R;
import com.elcom.trafficgoelcom.drawmap.interfaces.iMap;
import com.elcom.trafficgoelcom.notificationstatus.activities.Fragment_notificationEarly;


public class Fragment_choose_map extends DialogFragment {
    private static final String TAG = "FragmentChooseMap";

    // widget
    private ImageButton img_define;
    private ImageButton img_satelite;
    private ImageButton img_traffic;
    private ImageButton img_density;
    private ImageButton img_car;
    private ImageButton img_bike;
    private ImageButton img_walk;
    private Button btnDistance;
    private Button btnClock;

    public static iMap iMap;
    private int s;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_map, container, false);
        initWidget(view);

        choose_kind_map();
        choose_vehicle();

        henGio();

        return view;
    }
    private void initWidget(View view){
        img_define = view.findViewById(R.id.img_define);
        img_density = view.findViewById(R.id.img_density);
        img_satelite = view.findViewById(R.id.img_satelite);
        img_traffic = view.findViewById(R.id.img_traffic);

        img_bike =  view.findViewById(R.id.img_bike);
        img_car = view.findViewById(R.id.img_car);
        img_walk = view.findViewById(R.id.img_walk);

        btnClock = view.findViewById(R.id.btnClock);
        btnDistance = view.findViewById(R.id.btnDistance);

    }

    public void choose_kind_map(){

        img_define.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 1;
                getDialog().cancel();
                iMap.selectTypeMap(s);
            }
        });
        // density map will be designed by dev with density of traffic
        img_density.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 2;
                getDialog().cancel();
                iMap.selectTypeMap(s);
            }
        });
        img_satelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 3;
                getDialog().cancel();
                iMap.selectTypeMap(s);
            }
        });
        // traffic map will be designed by dev with signpost
        img_traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 4;
                getDialog().cancel();
                iMap.selectTypeMap(s);
            }
        });
    }


    public void choose_vehicle(){
        img_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        img_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getDialog().dismiss();
    }

    public void henGio(){
        btnClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
                Intent i= new Intent(getContext(),Fragment_notificationEarly.class);
                startActivity(i);

            }
        });
    }
}
