package com.swathi.swathitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I am in active state", Toast.LENGTH_SHORT).show();
      Intent impIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/viewer?ie=UTF8&oe=UTF8&t=m&vpsrc=0&msa=0&mid=1EKrvpydeECY7QwBRk_IUBcax79Y&ll=17.0019203185456%2C82.25789857950068&z=1"));
        impIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(impIntent);

     /*   Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ""));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent2);*/
    }
}
