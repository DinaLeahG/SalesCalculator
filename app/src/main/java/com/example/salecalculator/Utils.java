package com.example.salecalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

public class Utils {
    public final static int sREQUEST_CODE_SETTINGS = 100, sREQUEST_CODE_LOCATION_PERMISSION = 100;

    // background
    // ----------

    public static void showHideBackground (boolean usePicBackground, ImageView background)
    {
        int visibilityMode = usePicBackground ? View.VISIBLE : View.INVISIBLE;

        // Set the ImageView's visibility to be show or hidden as per the user preference
        assert background != null;
        background.setVisibility (visibilityMode);
    }
    //Dialog Box to Show about us.
    private static void showAlertDialog (Context context, String strTitle, String strMsg,
                                         DialogInterface.OnClickListener okListener,
                                         DialogInterface.OnClickListener cancelListener)
    {
        AlertDialog.Builder alertDialogBuilder = getDialogBasicsADB (context, strTitle, strMsg);

        if (okListener == null) {
            // create an OK button only and use a dummy listener for that button and the dialog
            alertDialogBuilder.setNeutralButton (context.getString (android.R.string.ok),
                    getNewEmptyOnClickListener ());
        }
        else {
            alertDialogBuilder.setPositiveButton (context.getString (android.R.string.ok),
                    okListener);
            alertDialogBuilder.setNegativeButton (context.getString (android.R.string.cancel),
                    cancelListener);
        }

        // Create and Show the Dialog
        alertDialogBuilder.show ();


}
