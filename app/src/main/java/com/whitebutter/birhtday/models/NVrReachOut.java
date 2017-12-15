package com.whitebutter.birhtday.models;

import android.support.annotation.Keep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by sonal on 15/11/17.
 */
@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
public class NVrReachOut  implements Serializable{


    boolean success;
    String info ;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
