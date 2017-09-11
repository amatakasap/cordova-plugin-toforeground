package com.cordova.plugins.toforeground;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;


public class ToForeground extends CordovaPlugin {
  private static final String TAG = ToForeground.class.getName();

  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    Log.d(TAG, "ToForeground [execute]");

    if (action.equals("toForeground")) {
      try {
        Intent it = new Intent("android.intent.action.MAIN");

        String className = args.getString(0);
        String packageName = args.getString(1);

        Activity activity = this.cordova.getActivity();
        it.setComponent(new ComponentName(packageName, packageName + "." + className));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Context context = activity.getApplicationContext();
        context.startActivity(it);
      }
      catch (Exception e) {
        return false;
      }
    }
    return true;
  }
};
