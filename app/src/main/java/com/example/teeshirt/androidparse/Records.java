package com.example.teeshirt.androidparse;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class Records extends ActionBarActivity {
    private TextView cname, cemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        cname = (TextView)findViewById(R.id.contactname);
        cemail = (TextView)findViewById(R.id.contactemail);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        query.getInBackground("JgrWk0aenO", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, ParseException e) {
                if (e == null) {
                    String name = contact.getString("name");
                    String email = contact.getString("email");

                    cname.setText(name);
                    cemail.setText(email);
                }
            }
        });

    }


}
