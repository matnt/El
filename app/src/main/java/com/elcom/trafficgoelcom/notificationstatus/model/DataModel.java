package com.elcom.trafficgoelcom.notificationstatus.model;

import java.io.Serializable;

public class DataModel implements Serializable {
    private String time1;
    private String date1;
    private boolean check1;

    public DataModel() {
    }

    public DataModel(String time, String date, boolean check) {
        this.time1 = time;
        this.date1 = date;
        this.check1 = check;
    }

    public String getTime1() {
        return time1;
    }

    public String getDate1() {
        return date1;
    }

    public boolean isCheck1() {
        return check1;
    }


}
