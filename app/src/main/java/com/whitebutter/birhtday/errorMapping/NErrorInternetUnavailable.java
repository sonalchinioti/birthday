package com.whitebutter.birhtday.errorMapping;

import android.support.annotation.Keep;

/**
 * Created by sonal on 24/5/17.
 */
@Keep
public class NErrorInternetUnavailable {

    private Throwable throwable;

    public NErrorInternetUnavailable(Throwable throwable) {
        this.throwable = throwable;

    }
}
