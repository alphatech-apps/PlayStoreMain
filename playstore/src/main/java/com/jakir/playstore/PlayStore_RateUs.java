package com.jakir.playstore;

import android.content.Context;

import com.jakir.playstore.rateusdialog.Rate_DialogHelper;
import com.jakir.playstore.rateusdialog.Rate_Dialog_Material;

//
// Created by JAKIR HOSSAIN on 4/11/2025.
//
public class PlayStore_RateUs {

    public PlayStore_RateUs(Context context, int openCountThreshold) {
        // Check if the rate dialog should be shown based on app open count
        if (Rate_DialogHelper.shouldShowRateDialog(context, openCountThreshold)) {
             new Rate_Dialog_Material().showRateDialog(context);
        }
    }
}


