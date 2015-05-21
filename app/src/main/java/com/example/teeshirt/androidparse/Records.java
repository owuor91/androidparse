package com.example.teeshirt.androidparse;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class Records extends ActionBarActivity {
    private TextView cname, cemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);



        ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, "Contact");
        adapter.setTextKey("name");
        //adapter.setTextKey("email");

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }


}



//Retrieving single object
        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        query.getInBackground("xJJSATOH03", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, ParseException e) {
                if (e == null) {
                    String name = contact.getString("name");
                    String email = contact.getString("email");

                    cname.setText(name);
                    cemail.setText(email);
                }
            }
        });*/