package com.laison.server.controller;

import com.laison.server.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/11 14:05
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {
    @Autowired
    private WechatService wechatService;

    @PostMapping("/refund")
    public Object refund(@RequestParam String tradeNo, @RequestParam int fee) throws Exception {
        return wechatService.refund(tradeNo, fee);
    }
}
