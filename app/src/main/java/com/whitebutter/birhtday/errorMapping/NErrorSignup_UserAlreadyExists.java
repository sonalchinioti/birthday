package com.whitebutter.birhtday.errorMapping;

import android.support.annotation.Keep;

/**
 * Created by sonal on 25/5/17.
 */
@Keep
public class NErrorSignup_UserAlreadyExists {

    private Throwable throwable;

    public NErrorSignup_UserAlreadyExists(Throwable throwable) {
        this.throwable = throwable;

    }
}
