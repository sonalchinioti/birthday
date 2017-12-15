package com.whitebutter.birhtday.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import com.whitebutter.birhtday.R;
import com.whitebutter.birhtday.application.NApplication;
import com.whitebutter.birhtday.models.NVrUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 07-11-2016.
 */
public class NUtils {




    public static Toolbar setToolbar(Toolbar toolbar, boolean arrow, String screen_title) {

        //toolbar.setLogo(R.drawable.logo);
        if (arrow) {
            toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        }

//        toolbar.setTitle(screen_title);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(screen_title);
        toolbar.setLogoDescription(R.string.app_name);
        return toolbar;
    }


    public static Toolbar setToolbar(Toolbar toolbar, String screen_title) {
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText(screen_title);
        toolbar.setLogoDescription(R.string.app_name);
        return toolbar;
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public static int getAndroidSDKVersion(){
        return android.os.Build.VERSION.SDK_INT;
    }

    public static String getDeviceID(Context context){
        return   Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }



    public static String getFromSharedPref(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        String value = null;
        value = pref.getString(key, value);
        return value;
    }

    public static boolean getFromSharedPref(Context context, String key, boolean defaultValue) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        return pref.getBoolean(key, defaultValue);
    }

    public static int getFromSharedPref(Context context, String key, int defaultValue) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        return pref.getInt(key, defaultValue);
    }

    public static void writeToSharedPref(Context context, String key, String value) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void writeToSharedPref(Context context, String key, boolean value) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

    public static void writeToSharedPref(Context context, String key, int value) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();

    }

    public static void clearSharedRef(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();

    }
    public static Boolean setCurrentUserDetails(Context context, NVrUser user) {
        SharedPreferences pref = context.getSharedPreferences("NiceVr", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        String current_user_login_id =  user.getId();
        String current_user_name =  user.getName();
        String current_user_email = user.getEmail();
        String current_user_url = user.getUrl();
        String current_user_uid = user.getUid();
        String current_user_avatar = user.getAvatar();

        if (null != current_user_login_id && !current_user_login_id.isEmpty()) {
            editor.putString("NiceVr:current_user_login_id", current_user_login_id);
        }
        if (null != current_user_name && !current_user_name.isEmpty()) {
            editor.putString("NiceVr:current_user_name", current_user_name);
        }
        if (null != current_user_email && !current_user_email.isEmpty()) {
            editor.putString("NiceVr:current_user_email", current_user_name);
        }
        if (null != current_user_url && !current_user_url.isEmpty()) {
            editor.putString("NiceVr:current_user_url", current_user_url);
        }
        if (null != current_user_uid && !current_user_uid.isEmpty()) {
            editor.putString("NiceVr:current_user_uid", current_user_uid);
        }
        if (null != current_user_avatar && !current_user_avatar.isEmpty()) {
            editor.putString("NiceVr:current_user_avatar", current_user_avatar);
        }
        return editor.commit();

    }
    public static String getCurrentUserId() {
        return getFromSharedPref(NApplication.context, "NiceVr:current_user_login_id");
    }


    public static long  calculateDate(){
        String current_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String target_date = "2017-12-21";
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        long elapsedDays = 0;

        try {
            Date date1 = formater.parse(current_date);
            Date date2 = formater.parse(target_date);

             elapsedDays = printDifference(date1 , date2 );



        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  elapsedDays;
    }


    public static long printDifference(Date startDate, Date endDate) {
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
