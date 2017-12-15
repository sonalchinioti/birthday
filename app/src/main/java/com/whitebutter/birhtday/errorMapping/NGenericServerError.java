package com.whitebutter.birhtday.errorMapping;

import android.support.annotation.Keep;

/**
 * Created by sonal on 24/5/17.
 */
@Keep
public class NGenericServerError {


    private Throwable throwable;

    public NGenericServerError(Throwable throwable) {
        this.throwable = throwable;

    }
}
