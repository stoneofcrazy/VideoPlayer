package com.example.zhaowei.videoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.example.zhaowei.videoplayer.media.AndroidMediaController;
import com.example.zhaowei.videoplayer.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity {
    private IjkVideoView ijkVideoView;
    private AndroidMediaController mMediaController;
    private TableLayout mHudView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        ijkVideoView = (IjkVideoView) findViewById(R.id.video);
        ijkVideoView.setVideoURI(Uri.parse("http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear1/fileSequence0.ts"));
        ijkVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
                ijkVideoView.start();
            }
        });
    }
}
