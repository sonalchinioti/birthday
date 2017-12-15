package com.whitebutter.birhtday.networkCalls;

import com.whitebutter.birhtday.models.NVrFbLogin;
import com.whitebutter.birhtday.models.NVrReachOut;
import com.whitebutter.birhtday.models.NVrVideoResponse;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by User on 07-11-2016.
 */
public class NRestClient {




    public String root_url;

    RestTemplate restTemplate;

    public NRestClient(String m_root_url) {

        root_url = m_root_url;

        SimpleClientHttpRequestFactory httpRequestFactory = new  SimpleClientHttpRequestFactory ();
        httpRequestFactory.setConnectTimeout(30 * 1000);
        httpRequestFactory.setReadTimeout(30 * 1000);
        restTemplate = new RestTemplate(httpRequestFactory);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add (new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add (new GsonHttpMessageConverter());
        restTemplate.getMessageConverters().add (new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add (new ByteArrayHttpMessageConverter());

    }

        public NVrVideoResponse getVrList(int page_no){

            final String url = root_url + "/vr_videos.json?page=" +page_no+"&usage=nice_vr";
            NVrVideoResponse signed_in_user_details = (NVrVideoResponse)restTemplate.getForObject(url,NVrVideoResponse.class);
            return signed_in_user_details;
        }


        public NVrFbLogin fb_login(HashMap params){
            final String url ="http://aardvark.emailapp.c66.me/creating_nice_user.json";

            NVrFbLogin signed_in_user_details = (NVrFbLogin)restTemplate.postForObject(url, params,NVrFbLogin.class);

            return signed_in_user_details;
        }

    public NVrVideoResponse getLearnMoreAboutVideo(int page_no){

        final String url = root_url + "/normal_videos.json?page=" +page_no +"&type_of_video=normal_video&usage=learn_more_about_vr";
        NVrVideoResponse signed_in_user_details = (NVrVideoResponse)restTemplate.getForObject(url,NVrVideoResponse.class);
        return signed_in_user_details;
    }


    public NVrReachOut sendReachOut(){

        final String url = "http://aardvark.emailapp.c66.me/test.json?\n";
        NVrReachOut response = (NVrReachOut)restTemplate.getForObject(url,NVrReachOut.class);
        return response;
    }

}
