package com.whitebutter.birhtday.activities;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.whitebutter.birhtday.R;
import com.whitebutter.birhtday.adapter.NListLearnAboutVr;
import com.whitebutter.birhtday.models.NVideoModel;
import com.whitebutter.birhtday.utils.NUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by sonal on 08/12/17.
 */
@EActivity(R.layout.activity_all_videos)
public class NActivityAllVideos extends NAppcompatActivityTrackable {


    @ViewById
    ListView lv_vr_movie;


    @ViewById
    Toolbar toolbar;

    private ArrayList<NVideoModel> mList_videos;
    private NListLearnAboutVr mAdapter;


    @AfterViews
    public void afterView(){
        boolean nav_arrow = true;

        toolbar = NUtils.setToolbar(toolbar , nav_arrow ,  "All the videos");
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
         mList_videos = new ArrayList<NVideoModel>();
        mAdapter = new NListLearnAboutVr(this);
        creatingModels();
        long no_of_list_item = noOflistItemTObeShown();

        for(int i = 0 ; i < no_of_list_item ; i ++ ){
            mAdapter.addItem(mList_videos.get(i));
        }
        lv_vr_movie.setAdapter(mAdapter);
    }

    public long noOflistItemTObeShown(){

        long days_left = NUtils.calculateDate();
        long size_list = 0;
        if (days_left <= 7 ){
            size_list =(7- days_left);
        }
        return size_list;
    }



    public void creatingModels(){

        NVideoModel first = new NVideoModel("Meet some one Special", "https://img.youtube.com/vi/IEaCJqZiKK8/0.jpg" , "IEaCJqZiKK8");
        mList_videos.add(first);
        NVideoModel second  = new NVideoModel("The beautiful Journey Begin's", "https://img.youtube.com/vi/A3D1DYIL_IA/0.jpg" , "A3D1DYIL_IA");
        mList_videos.add(second);
        NVideoModel third = new NVideoModel("Love is in the Air", "https://img.youtube.com/vi/BYUIBnoJfaI/0.jpg" , "BYUIBnoJfaI");
        mList_videos.add(third);
        NVideoModel fourth = new NVideoModel("Two Person's Become One", "https://img.youtube.com/vi/_MG-Br3dYXI/0.jpg" , "_MG-Br3dYXI");
        mList_videos.add(fourth);
        NVideoModel fifth = new NVideoModel("Hard Times", "https://img.youtube.com/vi/uxR1eKwfTmw/0.jpg" , "uxR1eKwfTmw");
        mList_videos.add(fifth);
        NVideoModel sixth = new NVideoModel("Good Days", "https://img.youtube.com/vi/YUAyxSajTpE/0.jpg" , "YUAyxSajTpE");
        mList_videos.add(sixth);
        NVideoModel seventh = new NVideoModel("Becoming Practical", "https://img.youtube.com/vi/nypMO1AUgn0/0.jpg" , "nypMO1AUgn0");
        mList_videos.add(seventh);

    }

}
