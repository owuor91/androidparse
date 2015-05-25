package com.example.teeshirt.androidparse;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Contact")
public class Contact extends ParseObject {
    public Contact(){

    }

    public String getName() {
        return getString("name");
    }
    public void setName(String name) {
        put("name",name);
    }

    public String getEmail() {
        return getString("email");
    }
    public void setEmail(String email) {
        put("email",email);
    }

    public ParseFile getPhotoFile() {
        return getParseFile("image");
    }

    public void setPhotoFile(ParseFile image) {
        put("image", image);
    }
}
