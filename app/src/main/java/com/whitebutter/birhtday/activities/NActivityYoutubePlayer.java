package com.whitebutter.birhtday.activities;

import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.whitebutter.birhtday.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by sonal on 31/10/17.
 */
@EActivity(R.layout.activity_you_tube_player)
public class NActivityYoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {



    private String API_KEY = "AIzaSyBZjtuz8ARzUM7EN-G7WDVTEIebxqy2lFA";


    @Extra
    public String VIDEO_ID;

    @ViewById
    public YouTubePlayerView youtube_player_view;

    @AfterViews
    public void afterView(){
        // Initializing YouTube player view
        youtube_player_view.initialize(API_KEY, this);
    }




    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

        if(null== player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
            player.setFullscreen(true);
        }

        player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onAdStarted() { }

            @Override
            public void onError(YouTubePlayer.ErrorReason arg0) { }

            @Override
            public void onLoaded(String arg0) { }

            @Override
            public void onLoading() { }

            @Override
            public void onVideoEnded() { }

            @Override
            public void onVideoStarted() { }
        });



        player.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onBuffering(boolean arg0) { }

            @Override
            public void onPaused() { }

            @Override
            public void onPlaying() { }

            @Override
            public void onSeekTo(int arg0) { }

            @Override
            public void onStopped() { }
        });
    }



    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();

    }// Add listeners to YouTubePlayer instance








}
