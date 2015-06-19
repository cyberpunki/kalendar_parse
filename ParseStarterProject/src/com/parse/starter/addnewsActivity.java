package com.parse.starter;

/**
 * Created by Аким on 13.06.2015.
 */
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.SignUpCallback;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Аким on 12.06.2015.
 */
public class addnewsActivity extends Activity implements View.OnClickListener {
    EditText name;
    EditText date;
    EditText info;
    //Button button;
    Button add;
    int DIALOG_DATE = 1;
    //int myear,mday,mmonth;
    Date myd;
    //java.sql.Date myd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("myl", "addnewsActivity - start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnews_activity);
        add = (Button) findViewById(R.id.add);
       // button = (Button) findViewById(R.id.button);
       // button.setOnClickListener(this);
        add.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        date = (EditText) findViewById(R.id.date);
        info = (EditText) findViewById(R.id.info);

        myd = new Date(2013,02,21);

        Log.d("myl",myd.getYear()+"/"+myd.getMonth()+"/"+myd.getDay());
        Log.d("myl",myd.toString());
    }

    public void ondateclick(View v){
        showDialog(DIALOG_DATE);
    }

   /* public void onclickbutton(View v){
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy hh:mm");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        if(name.getText().length() == 0 || date.getText().length() == 0 || info.getText().length() == 0)
            return;
        Log.d("myl", "info start");
        ParseObject addnews = new ParseObject("info");
        addnews.put("name", name.getText().toString());
        addnews.put("date", format1.format(myd) );
        Log.d("myl", "**");
        Log.d("myl", "**" + format2.format(myd));
        Log.d("myl", "##" );
        addnews.put("data", format2.format(myd));
        addnews.put("info", info.getText().toString() );
        addnews.saveInBackground();
        Log.d("myl", "info is updated");
    }*/
    @Override
        public void onClick(View v){
        SimpleDateFormat format1 = new SimpleDateFormat("yy.MM.dd hh:mm");
       // SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        if(name.getText().length() == 0 || date.getText().length() == 0 || info.getText().length() == 0)
            return;
        Log.d("myl", "info start");
        ParseObject addnews = new ParseObject("info");
        addnews.put("name", name.getText().toString());
        addnews.put("date", format1.format(myd) );

        //addnews.put("data", format2.format(myd) );
        addnews.put("info", info.getText().toString() );
        addnews.saveInBackground();
        Log.d("myl", "info is updated");
    }

    protected Dialog onCreateDialog(int id){
        Log.d("myl","onCreateDialog - start");
        if (id == DIALOG_DATE){
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myd.getYear(), myd.getMonth(), myd.getDay());
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Log.d("myl", "onDateSet - start");
            myd.setYear(year);
            myd.setMonth(monthOfYear);
            myd.setDate(dayOfMonth);
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy hh:mm");
            date.setText(format1.format(myd));
            Log.d("myl",format1.format(myd));
        }
    };
}