package org.example;

public class QueryString {
    private final String key;
    private final String value;

    public QueryString(String s, String s1) {
       this.key = s;
       this.value = s1;
    }

    public boolean exists(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }
}
