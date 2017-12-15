package com.whitebutter.birhtday.models;

import android.support.annotation.Keep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by sonal on 09/12/17.
 */
@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
public class NVideoModel implements Serializable {



    public String title;
    public String thumbnail;
    public String video_id;

    public NVideoModel(String title, String thumbnail , String video_id){

        this.title = title;
        this.thumbnail = thumbnail;
        this.video_id = video_id;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }



}
