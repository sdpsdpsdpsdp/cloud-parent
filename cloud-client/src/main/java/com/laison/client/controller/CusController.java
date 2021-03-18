package com.laison.client.controller;

import com.laison.entity.Admin;
import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/5 15:34
 */
@RestController
@RequestMapping("/cus")
public class CusController {
    @Autowired
    private RestTemplate restTemplate;
    //    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RibbonLoadBalancerClient client;

    @GetMapping("/list")
    public List<Admin> list() {
        String url = "http://" + "localhost:8001" + "/admin/list";
        //动态获取服务器端口
        //第一种，获取第一个可用实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("myshop-server");
//        ServiceInstance instanceInfo = instances.get(0);
        //第二种，负载均衡 随机，轮询，hash
        //ribben
//        ServiceInstance instanceInfo = client.choose("myshop-server");
//        url = "http://" + instanceInfo.getHost() + ":" + instanceInfo.getPort() + "/admin/list";
        //第三种
        url = "http://myshop-server/admin/list";
        return restTemplate.getForObject(url, List.class);
    }
}
