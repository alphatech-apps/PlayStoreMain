package com.jakir.playstoremain;

import android.content.Context;

import com.jakir.playstore.PlayStore_RateUs;
import com.jakir.playstore.PlayStore_TryOurApps;
import com.jakir.playstore.PlayStore_Update;

import java.util.Calendar;

//
// Created by JAKIR HOSSAIN on 3/16/2025.
//
public class DoRemoteJob {
    Context context;

    public DoRemoteJob(Context context) {
        this.context = context;

        PlayStore_updateFromPlayStore(context);
        PlayStore_tryOurOtherAppsLoad(context);
        PlayStore_RateUs(context);
    }

    private void PlayStore_updateFromPlayStore(Context context) {
        new PlayStore_Update(context);
    }

    private void PlayStore_tryOurOtherAppsLoad(Context context) {
        String developerName = context.getString(R.string.developerName);
        new PlayStore_TryOurApps(context, developerName, 2);
    }

    private void PlayStore_RateUs(Context context) {
        new PlayStore_RateUs(context, Calendar.FRIDAY);
    }
}