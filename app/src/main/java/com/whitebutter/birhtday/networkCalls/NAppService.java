package com.whitebutter.birhtday.networkCalls;

import android.content.Context;

import com.whitebutter.birhtday.NExceptionCodeMapper;
import com.whitebutter.birhtday.application.NApplication;
import com.whitebutter.birhtday.errorMapping.NErrorGeneric;
import com.whitebutter.birhtday.errorMapping.NErrorInternetUnavailable;
import com.whitebutter.birhtday.errorMapping.NErrorUnAuthorizedAlerts;
import com.whitebutter.birhtday.errorMapping.NGenericServerError;
import com.whitebutter.birhtday.models.NVrFbLogin;
import com.whitebutter.birhtday.models.NVrReachOut;
import com.whitebutter.birhtday.models.NVrVideoResponse;
import com.joanzapata.android.asyncservice.api.EnhancedService;
import com.joanzapata.android.asyncservice.api.annotation.ApplicationContext;
import com.joanzapata.android.asyncservice.api.annotation.AsyncService;
import com.joanzapata.android.asyncservice.api.annotation.ErrorManagement;
import com.joanzapata.android.asyncservice.api.annotation.Init;
import com.joanzapata.android.asyncservice.api.annotation.Mapping;

import java.util.HashMap;

/**
 * Created by User on 06-11-2016.
 */
@AsyncService(errorMapper = NExceptionCodeMapper.class)
public abstract class NAppService implements EnhancedService {


    static NRestClient restClient;
    static HashMap current_user;

    @ApplicationContext
    static Context applicationContext;


    @Init
    static void init() {
        // Initialize the rest client here
        if (!NApplication.isPointToProduction()) {
            restClient = new NRestClient("http://146.185.141.118");
        } else {
            restClient = new NRestClient("http://146.185.141.118");
        }
    }


    @ErrorManagement({@Mapping(on = 500, send = NGenericServerError.class),
            @Mapping(on = 999, send = NErrorGeneric.class),
            @Mapping(on = 401, send = NErrorUnAuthorizedAlerts.class),
            @Mapping(on= 101 , send = NErrorInternetUnavailable.class )})
    public NVrVideoResponse getVrList(int page_no )
    {
        NVrVideoResponse   video_response = restClient.getVrList(page_no);
        return video_response;
    }

    @ErrorManagement({@Mapping(on = 500, send = NGenericServerError.class),
            @Mapping(on = 999, send = NErrorGeneric.class),
            @Mapping(on = 401, send = NErrorUnAuthorizedAlerts.class),
            @Mapping(on= 101 , send = NErrorInternetUnavailable.class )})
    public NVrFbLogin fbLogin(HashMap params )
    {
        NVrFbLogin user = restClient.fb_login(params);
        return user;
    }


    @ErrorManagement({@Mapping(on = 500, send = NGenericServerError.class),
            @Mapping(on = 999, send = NErrorGeneric.class),
            @Mapping(on = 401, send = NErrorUnAuthorizedAlerts.class),
            @Mapping(on= 101 , send = NErrorInternetUnavailable.class )})
    public NVrVideoResponse getLearnMoreAboutVr(int page_no )
    {
        NVrVideoResponse video_response = restClient.getLearnMoreAboutVideo(page_no);
        return video_response;
    }

    @ErrorManagement({@Mapping(on = 500, send = NGenericServerError.class),
            @Mapping(on = 999, send = NErrorGeneric.class),
            @Mapping(on = 401, send = NErrorUnAuthorizedAlerts.class),
            @Mapping(on= 101 , send = NErrorInternetUnavailable.class )})
    public NVrReachOut sendReachOut()
    {
        NVrReachOut response = restClient.sendReachOut();
        return response;

    }
}
