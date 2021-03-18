package com.laison.server.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.binarywang.wxpay.util.XmlConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/11 14:06
 */
@Configuration
public class WechatCompon {
    /**
     * 获取微信的配置
     */
    @Bean
    public WxPayService wxPayService() {
        final WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(Constant.WECHAT_PAY_APP_ID));
        payConfig.setMchId(StringUtils.trimToNull(Constant.WECHAT_PAY_MCH_ID));
        payConfig.setMchKey(StringUtils.trimToNull(Constant.WECHAT_PAY_MCH_KEY));
        payConfig.setKeyPath(this.getClass().getClassLoader().getResource("static/apiclient_cert.p12").getPath());
        XmlConfig.fastMode = false;
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }
}
