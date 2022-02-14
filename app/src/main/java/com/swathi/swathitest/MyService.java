package com.swathi.swathitest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyService extends android.app.Service {

    MediaPlayer mediaPlayer;




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("####", "Service started");
        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(MyService.this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null)
        mediaPlayer.stop();
        Log.e("####", "Service started");
        Toast.makeText(this,"Service stopped",Toast.LENGTH_SHORT).show();
    }
}
