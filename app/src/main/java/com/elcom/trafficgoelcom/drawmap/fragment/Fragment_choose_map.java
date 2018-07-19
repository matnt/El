package com.elcom.trafficgoelcom.drawmap.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elcom.trafficgoelcom.MapsActivity;
import com.elcom.trafficgoelcom.R;


public class Fragment_choose_map extends Fragment {

    private LinearLayout linear_define;
    private LinearLayout linear_satelite;
    private LinearLayout linear_traffic;
    private LinearLayout linear_density;
    private LinearLayout linear_car;
    private LinearLayout linear_bike;
    private LinearLayout linear_walk;
    private int s;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind_map, container, false);
        initWidget(view);
//        String action = getArguments().getString("choose");
//        if (action.equals("kindMap")) {
//            choose_kind_map();
//            choose_vehicle();
//        }
        choose_kind_map();
        choose_vehicle();

        return view;
    }
    private void initWidget(View view){
        linear_define = view.findViewById(R.id.li_define);
        linear_density = view.findViewById(R.id.li_density);
        linear_satelite = view.findViewById(R.id.li_satelite);
        linear_traffic = view.findViewById(R.id.li_traffic);

        linear_bike =  view.findViewById(R.id.li_bike);
        linear_car = view.findViewById(R.id.li_car);
        linear_walk = view.findViewById(R.id.li_walk);

    }

    public void choose_kind_map(){

        linear_define.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 1;
            }
        });
        // density map will be designed by dev with density of traffic
        linear_density.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 2;
                //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        linear_satelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 3;
                //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        // traffic map will be designed by dev with signpost
        linear_traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = 4;
                //mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        MapsActivity mapsActivity = new MapsActivity();
        mapsActivity.chooseKindMap(s);

    }


    public void choose_vehicle(){
        linear_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        linear_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        linear_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
