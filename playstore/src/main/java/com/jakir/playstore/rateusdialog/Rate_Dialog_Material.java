package com.jakir.playstore.rateusdialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jakir.playstore.R;
import com.jakir.playstore.tryourapps.AppOpenUtil;

//
// Created by JAKIR HOSSAIN on 8/6/2025.
//
public class Rate_Dialog_Material {

    public void showRateDialog(@NonNull Context context) {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        View view = View.inflate(context, R.layout.rate_us_dialog_material, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        ImageView s1 = view.findViewById(R.id.star01);
        ImageView s2 = view.findViewById(R.id.star02);
        ImageView s3 = view.findViewById(R.id.star03);
        ImageView s4 = view.findViewById(R.id.star04);
        ImageView s5 = view.findViewById(R.id.star05);

        s1.setOnClickListener(v -> setRatingStars(s1, s2, s3, s4, s5, 1));
        s2.setOnClickListener(v -> setRatingStars(s1, s2, s3, s4, s5, 2));
        s3.setOnClickListener(v -> setRatingStars(s1, s2, s3, s4, s5, 3));
        s4.setOnClickListener(v -> openPlayStore(dialog, context));
        s5.setOnClickListener(v -> openPlayStore(dialog, context));

        TextView rateText = view.findViewById(R.id.rate_txt_btn);
        rateText.setOnClickListener(v -> openPlayStore(dialog, context));
        TextView remindLaterBtn = view.findViewById(R.id.btnRemindLater);
        remindLaterBtn.setOnClickListener(v -> dialog.dismiss());

        // Increment app open count to avoid showing the dialog again
        AppOpenUtil.countAppOpen(context);
    }

    private void setRatingStars(ImageView s1, ImageView s2, ImageView s3, ImageView s4, ImageView s5, int rating) {
        ImageView[] stars = {s1, s2, s3, s4, s5};
        for (int i = 0; i < rating; i++) {
            stars[i].setImageResource(R.drawable.ic_star_fill);
        }
        for (int i = rating; i < stars.length; i++) {
            stars[i].setImageResource(R.drawable.ic_star_outline);
        }
    }

    private void openPlayStore(AlertDialog builder, Context context) {
        builder.dismiss();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName())));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }
}
