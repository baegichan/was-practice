package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final Requestline requestline;;
    public HttpRequest(BufferedReader br) throws IOException {
        this.requestline = new Requestline(br.readLine());
    }
    public boolean isGetRequest() {
        return requestline.isGetRequset();
    }

    public boolean matchPath(String path) {
        return requestline.mathPath(path);
    }
    public QueryStrings getQueryStrings() {
        return null;
    }

    public boolean isGetRequset() {
        return  requestline.isGetRequset();
    }

    public boolean matching(String path) {
        return requestline.mathPath(path);
    }
}
