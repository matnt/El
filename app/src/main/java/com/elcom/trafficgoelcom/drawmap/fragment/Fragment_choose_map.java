package com.elcom.trafficgoelcom.drawmap.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elcom.trafficgoelcom.MapsActivity;
import com.elcom.trafficgoelcom.R;
import com.google.android.gms.maps.GoogleMap;

public class Fragment_choose_map extends Fragment {
    public GoogleMap mMap;
    private LinearLayoutManager linearManager;
    private LinearLayout linear_define;
    private LinearLayout linear_satelite;
    private LinearLayout linear_traffic;
    private LinearLayout linear_density;
    private LinearLayout linear_car;
    private LinearLayout linear_bike;
    private LinearLayout linear_walk;
    private String s;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initWidget(view);

        String action = getArguments().getString("choose");
        if (action == "kindMap") {
            choose_kind_map();
            choose_vehicle();
        }


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
        Bundle bundle = new Bundle();
        s = "";


        linear_define.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "MAP_TYPE_NORMAL";
                //mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        // density map will be designed by dev with density of traffic
        linear_density.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "MAP_TYPE_HYBRID";
                //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        linear_satelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "MAP_TYPE_SATELLITE";
                //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        // traffic map will be designed by dev with signpost
        linear_traffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "MAP_TYPE_NORMAL";
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        bundle.putString("kindMap", s);
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
