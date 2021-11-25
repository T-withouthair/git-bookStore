package com.atguigu.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 沙箱支付
 * @author tyjstart
 * @create 2021-11 -09 17:57
 */
public class AlipayServlet extends BaseServlet {

    protected void pay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "2021";
        //付款金额，必填
        String total_amount = "9999";
        //订单名称，必填
        String subject = "支付宝测试";
        //商品描述，可空
        String body = "商品描述";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            resp.setContentType("text/html;charset=" + AlipayConfig.charset);
            resp.getWriter().write(result);//直接将完整的表单html输出到页面
            resp.getWriter().flush();
            resp.getWriter().close();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            resp.getWriter().write("捕获异常出错");
            resp.getWriter().flush();
            resp.getWriter().close();
        }
    }
}




