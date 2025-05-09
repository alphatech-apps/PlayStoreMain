package com.jakir.playstore;

import android.app.Activity;
import android.content.Context;

import com.jakir.playstore.update.AppUpdateHelper;

//
// Created by JAKIR HOSSAIN on 4/11/2025.
//
public class PlayStore_Update {
    public PlayStore_Update(Context context) {
        // Check if the rate dialog should be shown
        AppUpdateHelper updateHelper = new AppUpdateHelper(context);
        updateHelper.checkForUpdate((Activity) context);
    }
}
