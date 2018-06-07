package com.coto.cesar.e_learning_beta_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class VideoPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {


    String claveYT = "AIzaSyBifkSN32cPx7NRTuzjcxsoeGbWIJeT_eI";
    YouTubePlayerView youTubePlayerView;
    String videoAReproducir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Bundle extras = getIntent().getExtras();
        videoAReproducir = extras.getString("IDVIDEO");



        youTubePlayerView = findViewById(R.id.yotubePlayer);
        youTubePlayerView.initialize(claveYT,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {
        if (!fueRestaurado){
            youTubePlayer.cueVideo(videoAReproducir);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String eror = "Error al inicializar el video" + youTubeInitializationResult.toString();
            Toast.makeText(this, eror, Toast.LENGTH_SHORT).show();
        }
    }
    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if (requestCode==1){
            getYoutubePlayerProvier().initialize(claveYT,this);
        }
    }
    protected YouTubePlayer.Provider getYoutubePlayerProvier(){

        return youTubePlayerView;
    }
}
