package com.jayesh.jack;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import android.content.Context;
import android.content.Intent;

/**
 * This class echoes a string called from JavaScript.
 */
public class Jack extends CordovaPlugin 
{

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
       // Log.e("Inside execute", "Inside execute method");
        if (action.equals("callJack")) 
        {
            // String message1 = args.getString(0);
            // String message2 = args.getString(1);
            // this.jackMethod(message1, message2, callbackContext);
            //this.jackMethod(message1, callbackContext);

            this.jackMethod(args.getJSONObject(0) , callbackContext);
            return true;
        }
        return false;
    }

    //private void jackMethod(String message1, String message2, CallbackContext callbackContext) 
    //private void jackMethod(String message1, CallbackContext callbackContext) 
    private void jackMethod(JSONObject message1, CallbackContext callbackContext) 
    {
        //if (message1 != null && message1.length() > 0) 
        if (message1 != null ) 
        {
            String appId = "";
            String sessionId = "";
            String tokenId = "";
            String msgToReturn = "";

            try 
            {
                appId = message1.getString("appId");
                sessionId = message1.getString("sessionId");
                tokenId = message1.getString("tokenId"); 
                msgToReturn = " Android Details Are : " + appId + " \n " + sessionId + " \n " + tokenId ;
                Context context = cordova.getActivity().getApplicationContext();
                this.openNewActivity(context);
            } catch (Exception e) 
            {
                msgToReturn = ""+ e.toString();
            }
            

            callbackContext.success(msgToReturn);

        } else {
            callbackContext.error("somethis is wrong dude !!!");
        }
    }

    private void openNewActivity(Context context) 
    {
     

        Intent intent = new Intent(context, NewActivity.class);
        this.cordova.getActivity().startActivity(intent);
    }

}
