package com.xiaosong.controller;

import com.xiaosong.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/search")
    public String search() {
        int i = 1/0;
        return "search: " + port;
    }

    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        return new Customer(1, "张三", 23);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        return new Customer(id, name, 23);
    }

    @PostMapping("/save") // 参数过于复杂要用post方式请求
    public Customer save(@RequestBody Customer customer) {// 没加RequestBody注解feign调用传参接收不到
        return customer;
    }
}
