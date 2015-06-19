package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by Аким on 11.06.2015.
 */
public class adminActivity extends Activity implements View.OnClickListener {
    Button register;
    Button vxod;
    EditText login;
    EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_avtivity);
        register = (Button) findViewById(R.id.regs);
        vxod = (Button) findViewById(R.id.vxod);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        register.setOnClickListener(this);
        vxod.setOnClickListener(this);

    }




    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.regs:
                Intent res = new Intent(this, regsactivity.class);
                startActivity(res);
                break;
            case R.id.vxod:
                if(login.getText().length() == 0 || password.getText().length() == 0)
                    return;
                ParseQuery<ParseObject> vod = ParseQuery.getQuery("Users");
                vod.whereEqualTo("login", login.getText().toString());
                vod.whereEqualTo("pass", password.getText().toString());
                vod.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        if (e == null) {
                           // Log.d("score", "Retrieved " + list.size() + " scores");
                            if (!list.isEmpty()) {
                                Intent tes = new Intent(adminActivity.this, vxodActivity.class);
                                startActivity(tes);
                            }
                        } else {
                           // Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });


                break;

            default:
                break;
        }

    };




}
