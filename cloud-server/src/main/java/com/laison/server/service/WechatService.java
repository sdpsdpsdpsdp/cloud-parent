package com.laison.server.service;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/11 14:05
 */
public interface WechatService {
    Object refund(String outTradeNo, int totalFee) throws Exception;
}
