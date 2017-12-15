package com.whitebutter.birhtday.models;

import android.support.annotation.Keep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by sonal on 31/10/17.
 */
@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
public class NVrFbLogin implements Serializable {

   public boolean success;
   public String info;
   public NVrUser user;
   public  String speaker_note;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public NVrUser getUser() {
        return user;
    }

    public void setUser(NVrUser user) {
        this.user = user;
    }

    public String getSpeaker_note() {
        return speaker_note;
    }

    public void setSpeaker_note(String speaker_note) {
        this.speaker_note = speaker_note;
    }
}
