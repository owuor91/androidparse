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
import java.util.HashMap;
import java.util.List;


public class Records extends ListActivity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    private ImageView[] imgs;
    public static int i;

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
                        details.add(detail);

                        String[] from = {"name", "email"};
                        int[] to = {R.id.name, R.id.email};
                        SimpleAdapter adapter = new SimpleAdapter(Records.this, details, R.layout.list_items, from, to);
                        setListAdapter(adapter);


                    }
                }
            }
        });


        imgs = new ImageView[6];
        imageView1 = (ImageView)findViewById(R.id.imgView1);
        imageView2 = (ImageView)findViewById(R.id.imgView2);
        imageView3 = (ImageView)findViewById(R.id.imgView3);
        imageView4 = (ImageView)findViewById(R.id.imgView4);
        imageView5 = (ImageView)findViewById(R.id.imgView5);
        imageView6 = (ImageView)findViewById(R.id.imgView6);

        imgs[0]=imageView1;
        imgs[1]=imageView2;
        imgs[2]=imageView3;
        imgs[3]=imageView4;
        imgs[4]=imageView5;
        imgs[5]=imageView6;



        ParseQuery imgQuery = new ParseQuery("Contact");
        imgQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> images, ParseException e) {
                for (i = 0; i<5; i++){
                    ParseObject image = images.get(i);
                    ParseFile fileObject = (ParseFile)image.get("picture");
                    fileObject.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] bytes, ParseException e) {
                                    if(e==null){
                                        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                        imgs[i].setImageBitmap(bmp);
                                    }
                                }
                            }
                    );
                }

            }
        });




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


//Retrieving one column in a listview
/*ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, "Contact");
        adapter.setTextKey("name");

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);*/


//Retrieving one image
/*ParseQuery imgQuery = new ParseQuery("Contact");
        imgQuery.getInBackground("v1ZfUKi6Ji", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e==null){
                    final ParseFile img = (ParseFile)parseObject.get("picture");
                    img.getDataInBackground(new GetDataCallback() {
                        @Override
                        public void done(byte[] imgBytes, ParseException e) {
                            ImageView imgView = (ImageView)findViewById(R.id.imgView);

                            Bitmap bmp = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
                            imgView.setImageBitmap(bmp);
                        }
                    });
                }
            }
        });*/