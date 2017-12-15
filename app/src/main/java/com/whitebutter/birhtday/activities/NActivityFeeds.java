package com.whitebutter.birhtday.activities;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.whitebutter.birhtday.R;
import com.whitebutter.birhtday.networkCalls.NAppService;
import com.whitebutter.birhtday.utils.NUtils;
import com.joanzapata.android.asyncservice.api.annotation.InjectService;
import com.joanzapata.android.asyncservice.api.internal.AsyncService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.Date;

import pl.droidsonroids.gif.GifImageView;


/**
 * Created by User on 06-11-2016.
 */
@EActivity(R.layout.activity_feeds)
public class NActivityFeeds extends NAppcompatActivityTrackable {

      @ViewById
      public LinearLayout ll_today_message;


     @ViewById
     public LinearLayout ll_birthday_message;


     @ViewById
     public LinearLayout ll_all_videos;

     @ViewById
     public GifImageView heart;

    @InjectService
    NAppService appService;


    @AfterViews
    public  void afterViews() {
        AsyncService.inject(this);
        appService.sendReachOut();
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NActivityEvolving_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
            }
        });

        ll_birthday_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (NUtils.calculateDate() == 0) {

                    NActivityYoutubePlayer_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).VIDEO_ID("5PhZOJU6ryY").start();
                }else{

                    String message = "Be Patient " + NUtils.calculateDate() + " days are left in your birthday message";
                    Toast.makeText(NActivityFeeds.this,message,Toast.LENGTH_LONG ).show();
                }
            }
        });



        ll_today_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NActivityYoutubePlayer_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).VIDEO_ID(getMessageId()).start();

            }
        });

        ll_all_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NActivityAllVideos_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();

            }
        });
    }

    public String getMessageId(){
         String array[] = {"IEaCJqZiKK8" , "A3D1DYIL_IA", "BYUIBnoJfaI" , "_MG-Br3dYXI" , "uxR1eKwfTmw" ,"YUAyxSajTpE" ,"nypMO1AUgn0"};
        String current_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());




               if (current_date.equals("2017-12-14"))    {
                   return array[0];
               }else if (current_date.equals("2017-12-15")){
                   return array[1];
               }else if (current_date.equals("2017-12-16")) {
                   return array[2];
               }else if (current_date.equals("2017-12-17")) {
                   return array[3];
               }else if (current_date.equals("2017-12-18")) {
                   return array[4];
               }else if (current_date.equals("2017-12-19")) {
                   return array[5];
               }else if (current_date.equals("2017-12-20")) {
                   return array[6];
               }else{
                   return array[6];
               }


    }

}
