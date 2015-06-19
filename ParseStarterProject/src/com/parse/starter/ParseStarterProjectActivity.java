package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.PushService;

public class ParseStarterProjectActivity extends Activity implements View.OnClickListener{
	Button admin;
	Button student;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		/*Parse.initialize(this, "MlNrgyCjZ2VVG14hqOAkmTTcCEcqCzFrLRjkOLrZ", "fwcLweqHH9EvvWb7kC8iB9PMijgEAuRJtZpiREZg");
		ParseInstallation.getCurrentInstallation().saveInBackground();
		PushService.setDefaultPushCallback(this, ParseStarterProjectActivity.class);
		ParsePush.subscribeInBackground("", new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null) {
					Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
				} else {
					Log.e("com.parse.push", "failed to subscribe for push", e);
				}
			}
		});*/


		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ParseAnalytics.trackAppOpenedInBackground(getIntent());

		Log.d("myl", "first log");
		admin = (Button) findViewById(R.id.adm);
		student = (Button) findViewById(R.id.stud);

		admin.setOnClickListener(this);
		student.setOnClickListener(this);


	}
	@Override
	public void onClick(View v){
		Log.d("myl","asdwq");
		switch (v.getId()){
			case R.id.adm:
				Intent ins = new Intent(this, adminActivity.class);
				startActivity(ins);
				break;
			case R.id.stud:
                Intent stu = new Intent(this, studentActivity.class);
               startActivity(stu);
				break;

			default:
				break;

		}
	};

}
