package com.whitebutter.birhtday.activities;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.whitebutter.birhtday.R;
import com.whitebutter.birhtday.utils.NUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by sonal on 08/12/17.
 */
@EActivity(R.layout.activity_evolving)
public class NActivityEvolving extends NAppcompatActivityTrackable {



    @ViewById
    public Toolbar toolbar ;


    @AfterViews
    public void afterView(){
        boolean nav_arrow = true;

        toolbar = NUtils.setToolbar(toolbar , nav_arrow ,  "Sampada");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //finishing
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
