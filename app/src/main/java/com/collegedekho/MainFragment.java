package com.collegedekho;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    View view;
    Context mContext;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = container.getContext();
        Uri uri = Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4");
        MediaController mediaController = new MediaController(mContext);
        final VideoView simpleVideoView = (VideoView) view.findViewById(R.id.videoplayframe); // initiate a video view
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.v(" video ", " video + : onprepared");
                mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT);
                //       mp.isLooping() = true;
                mp.setScreenOnWhilePlaying(false);
                mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    @Override
                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
                        if (percent == 100) {
                            view.findViewById(R.id.progressbar).setVisibility(View.GONE);
                            //video have completed buffering
                        }
                    }
                });
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                        Log.v(" video ", " video + : OnInfo");
                        view.findViewById(R.id.progressbar).setVisibility(View.GONE);

                        if (i == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                            Log.v(" video ", " video + : onInfo start");

}
                        return false;
                    }
                });

            }
        });

        simpleVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(simpleVideoView);
        simpleVideoView.start();

        return view;
    }

}
