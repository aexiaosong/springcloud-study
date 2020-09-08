package com.xiaosong.client;

import com.xiaosong.entity.Customer;
import com.xiaosong.factory.SearchClientFallBackFactory;
import com.xiaosong.fallback.SearchClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "SEARCH", fallback = SearchClientFallBack.class)   // 指定服务名称
@FeignClient(value = "SEARCH", fallbackFactory = SearchClientFallBackFactory.class)   // 指定服务名称
public interface SearchClient {
    // value -> 目标服务的请求路径， method -> 映射请求方式
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search();

    @GetMapping("/search/{id}")
//    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    Customer findById(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
    Customer getCustomer(@RequestParam Integer id, @RequestParam String name);

    // 虽然这个的请求方式是GET，而Search模块中的接口写的是POST
    // 但是在调用的时候feign会自动把参数复杂的请求转换成POST
    // 在正常编写的情况下还是写POST好，这里只是为了测试
    @RequestMapping(value = "/save", method = RequestMethod.GET)   // 会自动转换为POST请求
    Customer save(Customer customer);
}
