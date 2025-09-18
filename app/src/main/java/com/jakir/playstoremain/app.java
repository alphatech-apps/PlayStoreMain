package com.jakir.playstoremain;

import android.app.Application;
import android.os.Build;

import com.google.android.material.color.DynamicColors;

//
// Created by JAKIR HOSSAIN on 9/18/2025.
//
public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Apply dynamic colors for all activities
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            DynamicColors.applyToActivitiesIfAvailable(this);
        }

    }
}