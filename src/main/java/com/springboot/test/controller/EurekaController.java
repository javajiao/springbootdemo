package com.springboot.test.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Jerry on 16/9/7.
 */
@Controller
@RequestMapping("/v1")
@Api
public class EurekaController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping(value = "eureka/list", method = RequestMethod.GET)
        @ResponseBody
        public Object test01() {
                List<ServiceInstance> list = discoveryClient.getInstances("SPRINGBOOTDEMO");

                if (list == null || list.isEmpty()){
                        return list;
                }
                list.forEach(s -> System.out.println(s.getUri()));
                ServiceInstance serviceInstance = list.get(0);
                String result = (new RestTemplate()).getForObject(serviceInstance.getUri(),String.class);

                return result;
        }
}
