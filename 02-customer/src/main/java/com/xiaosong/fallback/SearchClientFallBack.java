package com.xiaosong.fallback;

import com.xiaosong.client.SearchClient;
import com.xiaosong.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class SearchClientFallBack implements SearchClient {
    @Override
    public String search() {
        return "出现问题啦！";
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer getCustomer(Integer id, String name) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }
}
