package com.jayesh.jack;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.opengl.GLSurfaceView;
import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.content.DialogInterface;
import android.widget.Toast;

import java.lang.Exception;


public class NewActivity extends Activity
{



    private FrameLayout mPublisherViewContainer;
    private FrameLayout mSubscriberViewContainer;

    String LOG_TAG = "Jayesh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("new_activity", "layout", package_name));
        init();
    }

    private void init()
    {
       int id =  getApplication().getResources().getIdentifier("btnClick","id",getApplication().getPackageName());
       Button bView = NewActivity.this.findViewById(id);

       int pContainerId =  getApplication().getResources().getIdentifier("publisher_container","id",getApplication().getPackageName());
       int sContainerId =  getApplication().getResources().getIdentifier("subscriber_container","id",getApplication().getPackageName());
       
       // initialize view objects from your layout
       mPublisherViewContainer = (FrameLayout)NewActivity.this.findViewById(pContainerId);
       mSubscriberViewContainer = (FrameLayout)NewActivity.this.findViewById(sContainerId);


       int disconnectBtnid =  getApplication().getResources().getIdentifier("btnDisconnect","id",getApplication().getPackageName());
       Button disconnectBtn = NewActivity.this.findViewById(disconnectBtnid);
       disconnectBtn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
            try
            {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(NewActivity.this);
                    builder1.setMessage("Conversation stopped successfully.");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
            }catch(Exception ex)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(NewActivity.this);
                builder1.setMessage("Error Disconnecting: " + ex.toString());
                builder1.setCancelable(true);
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
           }
        });

        bView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(NewActivity.this);
                    builder1.setMessage("Button Clicked");
                    builder1.setCancelable(true);
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
               
            }
        });
    }




    private void showConfigError(String alertTitle, final String errorMessage) {
        Log.e(LOG_TAG, "Error " + alertTitle + ": " + errorMessage);
        new AlertDialog.Builder(NewActivity.this)
                .setTitle(alertTitle)
                .setMessage(errorMessage)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        
                    }
                })                
                .show();
    }


}