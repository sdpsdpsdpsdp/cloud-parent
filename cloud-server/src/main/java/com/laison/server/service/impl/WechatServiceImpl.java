package com.laison.server.service.impl;

import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.laison.server.config.WechatCompon;
import com.laison.server.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/11 14:05
 */
@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    private WechatCompon wechatCompon;


    public Object refund(String outTradeNo, int totalFee) throws Exception {
        return wechatCompon.wxPayService().refund(WxPayRefundRequest.newBuilder()
                .outRefundNo(outTradeNo)
                .outTradeNo(outTradeNo)
                .totalFee(totalFee)
                .refundFee(totalFee)
                .refundDesc("{purchase.water.failed}")
                .build());
    }
}
