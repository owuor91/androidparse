package com.example.teeshirt.androidparse;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {
    private EditText etName, etEmail;
    private Button save, see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "bOGl1QdNcltdgq34tsZq9BnvHGH9wcUoLfc0wLnH", "nhP3nptOFZHFAHmd1Zlhm1RjQvitC8iHBG3R8V0Z");

        etName = (EditText)findViewById(R.id.name);
        etEmail = (EditText)findViewById(R.id.email);
        save = (Button)findViewById(R.id.save);
        see = (Button)findViewById(R.id.see);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                ParseObject contact = new ParseObject("Contact");
                contact.put("name", name);
                contact.put("email",email);
                contact.saveInBackground();
            }
        });







        see.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Records.class);
                        startActivity(intent);
                    }
                }
        );
    }


}
