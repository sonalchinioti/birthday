package com.whitebutter.birhtday.errorMapping;

import android.support.annotation.Keep;

/**
 * Created by sonal on 24/5/17.
 */
@Keep
public class NErrorGeneric {


    private Throwable throwable;

    public NErrorGeneric(Throwable throwable) {
        this.throwable = throwable;

    }
}
