package com.whitebutter.birhtday.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.whitebutter.birhtday.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sonal on 08/12/17.
 */
@EActivity(R.layout.activity_main)
public class NActivityDaysLeft extends NAppcompatActivityTrackable {


    @ViewById
    public   TextView tv_date;


    @ViewById
    public  TextView tv_ic_arrow;


    @AfterViews
    public void afterView(){

        tv_ic_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NActivityFeeds_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK).start();


                finish();
            }
        });
        calculateDate();

    }



    public void calculateDate(){
        String current_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String target_date = "2017-12-21";
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = formater.parse(current_date);
            Date date2 = formater.parse(target_date);

            long elapsedDays = printDifference(date1 , date2    );

            tv_date.setText(String.valueOf(elapsedDays));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public long printDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();



        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;

        if (elapsedDays < 0 ){
            elapsedDays = 0;
        }

        return elapsedDays;
    }

}
