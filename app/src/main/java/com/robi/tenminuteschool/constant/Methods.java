package com.robi.tenminuteschool.constant;

import android.content.Context;
import android.widget.Toast;

public class Methods {

    //variable to hold context
    private Context context;

    //save the received context via constructor in a local variable
    public Methods(Context context) {
        this.context = context;
    }

    public void showToast(String message) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            //don't do anything here...
        }
    }
}
