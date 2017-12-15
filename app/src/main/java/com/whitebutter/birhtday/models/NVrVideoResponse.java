package com.whitebutter.birhtday.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sonal on 27/09/17.
 */

public class NVrVideoResponse implements Serializable {

    boolean success;
    String info ;
    List<NVrVideo> video;

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

    public List<NVrVideo> getVideo() {
        return video;
    }

    public void setVideo(List<NVrVideo> video) {
        this.video = video;
    }


}
