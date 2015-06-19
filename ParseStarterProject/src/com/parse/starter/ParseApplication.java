package com.parse.starter;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.PushService;
import com.parse.SaveCallback;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Parse.initialize(getApplicationContext(), "MlNrgyCjZ2VVG14hqOAkmTTcCEcqCzFrLRjkOLrZ", "fwcLweqHH9EvvWb7kC8iB9PMijgEAuRJtZpiREZg");
    //ParseInstallation.getCurrentInstallation().saveInBackground();
    //PushService.setDefaultPushCallback(this, ParseApp.class);
    ParsePush.subscribeInBackground("", new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
        } else {
          Log.e("com.parse.push", "failed to subscribe for push", e);
        }
      }
    });

      }
}
