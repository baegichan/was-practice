package org.example;

import jdk.jfr.Frequency;

import java.util.Objects;

public class Requestline {
    public Requestline(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;

    }
    private final String method;
    private final String urlPath;

    private String queryString;
    public Requestline(String url){
     String[] tokens =  url.split(" ");
     this.method = tokens[0];

     String[] tmp_urlPath = tokens[1].split("\\?");
        this.urlPath = tmp_urlPath[0];
     if(tmp_urlPath.length ==2) {
         this.queryString = tmp_urlPath[1];
     }
    }

    public boolean isGetRequset(){
        return "GET".equals(this.method);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requestline that = (Requestline) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }


    public boolean mathPath(String path) {
        return urlPath.equals(path);
    }
}
