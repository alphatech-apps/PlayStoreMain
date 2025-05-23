package com.jakir.playstore.rateusdialog;

//
// Created by JAKIR HOSSAIN on 3/12/2025.
//

import android.content.Context;
import android.content.SharedPreferences;

import com.jakir.playstore.rateusdialog.extraclass.CheckInternet;
import com.jakir.playstore.tryourapps.AppOpenUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Rate_DialogHelper {

    private static final String PREF_NAME = "RateDialogPrefs";
    private static final String LAST_SHOWN_DATE = "last_shown_date";
    private static final String REMIND_ME_LATER_DATE = "remind_me_later_date";

    public static boolean shouldShowRateDialog(Context context, int openCountWant) {
         /*   int openCount = Util.getCountAppOpen(activity);
      if (openCount % 5 == 0 && new CheckInternet().isConnected(activity) {
            return true;
        } else return false;
        */
        return AppOpenUtil.getCountAppOpen(context) % openCountWant == 0 && new CheckInternet().isConnected(context);

    }

    public static void saveRateDialogShown(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LAST_SHOWN_DATE, getTodayDate());
        editor.remove(REMIND_ME_LATER_DATE);  // Remove remind me later date if it was set
        editor.apply();
    }

    public static void saveRemindMeLater(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(REMIND_ME_LATER_DATE, getTomorrowDate()); // Save next day's date
        editor.apply();
    }

    private static boolean isFriday(int friday) {
        Calendar calendar = Calendar.getInstance();
//        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
        return calendar.get(Calendar.DAY_OF_WEEK) == friday;
    }

    private static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }

    private static String getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(calendar.getTime());
    }
}
