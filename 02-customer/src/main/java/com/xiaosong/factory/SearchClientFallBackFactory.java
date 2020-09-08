package com.xiaosong.factory;

import com.xiaosong.fallback.SearchClientFallBack;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchClientFallBackFactory implements FallbackFactory<SearchClientFallBack> {

    @Autowired
    private SearchClientFallBack searchClientFallBack;

    @Override
    public SearchClientFallBack create(Throwable throwable) {
        throwable.printStackTrace();
        return searchClientFallBack;
    }
}
