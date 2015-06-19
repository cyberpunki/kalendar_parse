package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Аким on 11.06.2015.
 */
public class regsactivity extends Activity implements View.OnClickListener{
    Button reg;
    EditText log;
    EditText pass;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regs_activity);
        reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(this);
        log = (EditText) findViewById(R.id.log);
        pass = (EditText) findViewById(R.id.pass);


    }
    //@Override
    public void onClick(View v){

        Log.d("myl", "onClick start");
        if(log.getText().length() == 0 || pass.getText().length() == 0){
            Toast.makeText(this, "zasdmfk", Toast.LENGTH_LONG).show();
            return;
        }


        ParseObject users = new ParseObject("Users");
        users.put("login", log.getText().toString());
        users.put("pass", pass.getText().toString());
        users.saveInBackground();
        Toast.makeText(this, "вы зарегестрированы", Toast.LENGTH_LONG).show();


        /*ParseUser user = new ParseUser();

        user.setUsername("my name");
        user.setPassword("my pass");
        user.setEmail("email@google.com");

        Log.d("myl", "onclick middle");
        user.signUpInBackground(new SignUpCallback() {
            //@Override
            public void done(ParseException e) {
                Log.d("myl","done method");
                if (e == null) {
                    Log.d("myl","Success");
                    // Hooray! Let them use the app now.
                } else {
                    Log.d("myl",e.getMessage());
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });*/

    }
}
