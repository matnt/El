package com.elcom.trafficgoelcom.notificationstatus.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.elcom.trafficgoelcom.R;
import com.elcom.trafficgoelcom.notificationstatus.model.DataModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Set_date_time_activity extends Activity {
    private static final String TAG = "Set date time activity";
    //widget
    private Button btnCancel;
    private Button btnSave;
    private TextView tvDate;
    private TextView tvTime;
    private ImageButton btnDate;
    private ImageButton btnTime;
    private ImageButton btn2, btn3, btn4, btn5, btn6, btn7,btns;

    //
    private int mYear, mMonth, mDay, mHour, mMinute;
    private String mDate;
    private String time;
    private String date1;


    private SimpleDateFormat simpledateformat;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_date_time);

        initWidget();

        simpledateformat = new SimpleDateFormat("EEEE");
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        Date date = new Date(mYear, mMonth, mDay-1);
        mDate = simpledateformat.format(date);

        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        DataModel data = (DataModel) getIntent().getSerializableExtra("data");
        if(data != null){
            tvDate.setText(data.getDate1());
            tvTime.setText(data.getTime1());

        } else {
            tvDate.setText(mDate + ", " + mDay + " Th" + (mMonth + 1) + ", " + mYear);
            tvTime.setText(mHour + ":" + mMinute);
        }

        time = (String) tvTime.getText();
        date1 = (String) tvDate.getText();
        solve();
        setLapLai();

    }



    public void initWidget() {
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        btnDate = findViewById(R.id.img_date);
        btnTime = findViewById(R.id.img_time);
        btn2 = findViewById(R.id.img_2);
        btn3 = findViewById(R.id.img_3);
        btn4 = findViewById(R.id.img_4);
        btn5 = findViewById(R.id.img_5);
        btn6 = findViewById(R.id.img_6);
        btn7 = findViewById(R.id.img_7);
        btns = findViewById(R.id.img_cn);
    }

    public void solve(){

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Set_date_time_activity.this,Fragment_notificationEarly.class);
                startActivity(i);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel dataModel = new DataModel(time, date1, true);
                Intent intent = new Intent(Set_date_time_activity.this, Fragment_notificationEarly.class);
                intent.putExtra("DataModel", dataModel);
                startActivity(intent);

            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });
    }

    public void setDate(){

        final DatePickerDialog datePickerDialog = new DatePickerDialog(this,
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    //getDatePicker();

                    Date date = new Date(year, monthOfYear, dayOfMonth-1);
                    mDate = simpledateformat.format(date);
                    tvDate.setText(mDate + ", " + dayOfMonth + " Th" + (monthOfYear + 1) + ", " + year);

                }
            }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setTime(){

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    tvTime.setText(hourOfDay + ":" + minute);
                }
            }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void setLapLai(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
