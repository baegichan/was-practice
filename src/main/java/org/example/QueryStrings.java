package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
public QueryStrings(String s){
   String[] querystringTokens = s.split("&");

    Arrays.stream(querystringTokens)
            .forEach(querystring->{
                String[] value = querystring.split("=");
                if(value.length != 2){
                    throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다");
                }
                queryStrings.add(new QueryString(value[0], value[1]));
            });
}

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
