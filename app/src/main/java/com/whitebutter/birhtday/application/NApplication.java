package com.whitebutter.birhtday.application;

import android.app.Application;
import android.content.Context;


import org.androidannotations.annotations.EApplication;

import uk.co.chrisjenx.calligraphy.BuildConfig;

/**
 * Created by User on 07-11-2016.
 */
@EApplication
public class NApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext() ;
        //calligraph api for including desired font .
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                        .setDefaultFontPath("fonts/Lato-Regular.ttf")
//                        .setFontAttrId(R.attr.fontPath)
//                        .build()
//        );


    }

    public static boolean isPointToProduction() {
        boolean result = false;
        if (BuildConfig.BUILD_TYPE.equals("release") || BuildConfig.BUILD_TYPE.equals("prerelease") ) {
            result = true;
        }
        return result;
    }
}
