package com.mesut.beyaztas.cat.facts.utils;

import android.content.Context;
import android.content.Intent;

import com.mesut.beyaztas.cat.facts.R;

/**
 * Created by Mesut on 04/11/2017.
 */

public class ShareUtils {

    public static void shareText(Context context, String body) {
        Intent txtIntent = new Intent(android.content.Intent.ACTION_SEND);
        txtIntent.setType("text/plain");
        String appName = context.getString(R.string.app_name);
        txtIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(txtIntent, appName));
    }

}
