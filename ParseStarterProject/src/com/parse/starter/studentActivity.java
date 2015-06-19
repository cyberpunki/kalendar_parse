package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Аким on 11.06.2015.
 */
public class studentActivity extends Activity {
    ListView infoList;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);

        infoList = (ListView) findViewById(R.id.listView);


        ParseQuery<ParseObject> query = ParseQuery.getQuery("info");
        query.selectKeys(Arrays.asList("name", "date", "info"));
        //List<ParseObject> results = query.find();
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("myl", "list log");
                    int k = list.size();
                    if (k != 0) {
                        Log.d("myl", "list is not empty");
                        String[] tmpArr = new String[k];
                        for (int i = 0; i < k; i++) {
                            tmpArr[i] = list.get(i).get("name").toString() + '\n'
                                    + list.get(i).get("date").toString()
                                    + '\n' + list.get(i).get("info").toString();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(studentActivity.this,
                                android.R.layout.simple_list_item_1, tmpArr);
                        infoList.setAdapter(adapter);
                    } else Log.d("myl", "list is empty");
                } else {
                    Log.d("myl", "Error: " + e.getMessage());
                }
            }
        });
    }
}
