package com.example.erik.coglog;



public class Favourite {
    public Favourite(String name, String url){
        setName(name);
        setUrl(url);
    }
    private String name;
    private String url;
    public void setName(String n){
        name = n;
    }
    public void setUrl(String u){
        url = u;
    }
    public String getName() {
        return name;
    }
    public String getUrl() { return url; }
    public String toString() { return getName(); }
}
