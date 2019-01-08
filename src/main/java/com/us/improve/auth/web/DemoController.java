package com.us.improve.auth.web;

import com.sun.media.sound.SoftTuning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DemoController
 * @Desciption TODO
 * @Author loren
 * @Date 2019/1/8 5:38 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public String demo1() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            instances.forEach(instance -> {
                System.out.println(instance.getHost() + ":" + instance.getPort());
                System.out.println("serviceId: " + instance.getServiceId());
                System.out.println("scheme: " + instance.getScheme());
                System.out.println("host: " + instance.getHost());
                System.out.println("port: " + instance.getPort());
                System.out.println("uri: " + instance.getUri());
                System.out.println("metadata: " + instance.getMetadata());
            });
        });
        return "OK";
    }


}
