package com.example.teeshirt.androidparse;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Records extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);



        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Contact");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> results, ParseException e) {

                if (e == null) {
                    ArrayList<HashMap<String, String>> details = new ArrayList<HashMap<String, String>>();
                    for (ParseObject result : results) {
                        HashMap<String, String> detail = new HashMap<String, String>();
                        detail.put("name", result.getString("name"));
                        detail.put("email", result.getString("email"));
                        detail.put("imgUrl", result.getString("imgUrl"));
                        details.add(detail);


                        String[] from = {"name", "email"};
                        int[] to = {R.id.name, R.id.email};
                        SimpleAdapter adapter = new SimpleAdapter(Records.this, details, R.layout.list_items, from, to);
                        setListAdapter(adapter);


                    }
                }
            }
        });







    }


}



