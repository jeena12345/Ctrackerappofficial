package com.sruthy.call;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extras
                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG", phoneNumber);

                if (Objects.equals(phoneNumber, "+917902302463")) {
                    Toast.makeText(context,phoneNumber,Toast.LENGTH_LONG).show();
                    // Toast.makeText(context,phoneNumber+"ok",Toast.LENGTH_LONG).show();
                    MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.child);
                    mediaPlayer.start();
                }


            }

        }

    }

}