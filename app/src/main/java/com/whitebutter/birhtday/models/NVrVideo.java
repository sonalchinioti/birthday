package com.whitebutter.birhtday.models;

import android.support.annotation.Keep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by sonal on 27/09/17.
 */
@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
public class NVrVideo implements Serializable {

    String _id ;
    String type_of_video ;
    String url;
    String thumbnail;
    String title;
    String description;
    Long download_id;



    public Long getDownload_id() {
        return download_id;
    }

    public void setDownload_id(Long download_id) {
        this.download_id = download_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType_of_video() {
        return type_of_video;
    }

    public void setType_of_video(String type_of_video) {
        this.type_of_video = type_of_video;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
