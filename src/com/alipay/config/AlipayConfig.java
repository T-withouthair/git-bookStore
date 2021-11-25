package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000118649139";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCGzRDRiXoy/QmuwgzCuW6jF9Ifujg9SlyJLQQe0UiUCkYVB1apg1qHL/Xtwt0h9APy6etnq9gOu1fvBDg8JYlDzEhXVW0oqjdnmIioeSc7ppF4h+iozotYHpBK2s4oiIWrVh3Q+5pLv2SxL/MCgftVb+X/IeutDoCbhgba/UQKt4TmWHD6nJqcPdrhh27Rhg5RaqYPtq9sifd/5LiQEEZRFAc/19jaijbeDsrCfcuG8Mrw0BYirfwFUFaqzqmnWvgANTDklXFq3/Cyh7UJcvXcEbIv6UiWGAPWGhbmsQNcpoD1rB79+63MEOw0Y3ML5L/2Q3N/NLczCd8Z+cPp4PKJAgMBAAECggEAISvPKrDY2Dk6K73mo/g7iHixJUuO0U4+LSddrzOy13Mbwcr3gWkoWsHrk6FzBwrj+d+kJPO9jAp/3fo82FgoSf24A32rCemxDpYTctm1VNFtVKqlDv0cfweuXC0xs/m8YugjGC0B0Af+ADgbZY+UyHZrs3emZgR+k0bM4xCVsMkR+1YPxw0Hcq1PWQQYoUvbSfirbB9W5/hxLtSZxhQdHuS8vfn2nx/OCoX3RYDbxjq+KBrdw0PpWEPrC+HtAkCYog7l1dgAiDEuiJytsGMP0iQSVf/+SXgKWGtxUkaGY3pt26feLoKPxddvjef3AkBa4o0p2VvlK7G8FFzke2gjMQKBgQDT8YC8jHviJZiQs4FFV+creP0YmVGL0GNfDn1JLTsqdNEDtWIQOG7NQC9q2aBL9amlTf7BUYEBw6tFnRPUr5ciZJJhBJbORGGhNOrNM83wvkDZBYoqYcBW4PTdQ9AAzPmfCBeb0l07YTkIyxdL9JRDd0o9F2bilumOrixSjgJc5QKBgQCi0nV1dMxHYbpCSQTJXh6A+BTTmNx+yQlyyRhvvYnMpiZJpR4Bwyp1X8X6wMgEMYB6T3J0W0zwKGKU063VM/9Iy5EpbKABpSwmqoBPzubxADp3YWrYJSln5f01/Vz5tBfaIe/anT/FGT9lejoOxMeaRu//zncaOU/kYZBxBVCI1QKBgDpv/kT+nzHNl/Fd7SjHge/UnkRoEbnxLVUKU7UXiZa9OtxA6Nb8GGDzb5+Qfcgz5iC0DqgS5vUrlE/PbaZY+9z5yfqCH2qkJB8kzhDiVcgpTQwJoPzqkvPhduKDThjKa5FT096c9CPpPKaWCMhimXa4r3mEuFOFtMQodgQVL8WZAoGAOtihhw/tfKb/cFF/n1+a2rXOoSMQHep+tbOkV05DbWlnURqSG8TzpXQ104i1QX66lnn8Pb15sxqFdpCCtRmT3DVmg3g05CNUL61TroRyxwt0Fg1pVjEoI9rlhwvI/J5wOHAnhfVrRMr5NK3WKdxI36Nfvi5asWmhTENOtupazvkCgYBIu6PgJ+gXXA0x+6br5pNrDYnpl+ky5Szth1KuNjSwM7ibXLcv1Wx82ifWw5jGE0yQTwvJ2aQzOrxrjtG+KPxGk1roZgPVv6Jkv2HiTqgM5a36ipG059mdATAUtJBcsg/1SuUXGoBVH2OPRACV+WHIOWhBALia4gBHBqtO0ipkZg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnGJkjwly5EfMuxeNl+Yyqc8uc1DKZlUq2aZkuE8JABtnHCT0uz4+c6RxiBmxty/xcTVkWEqnXM/V+jOhKUDTqP8TkwX2YonuTjw55XW2e170v7kzWBrKWq2R3AswHZtHrmMuirE2wmRJ+AoPpfOSNBRvwjzQ+lkpy1XLrV5qNcIYi5OLL7ZhfG8WHeKSVj6OvlB7Gi52/Cv8qgUv+TgIHlgcyjFz22XJTVFToLzHEs/fHM+iw4cRH22sMFPKVE4k6iCsgHHuB9suIYU5Yp6Yz7/LHYVSYXgIQao/9ip1A3ATEYJA6XXHWL/b7SnHrVUjznzF7Uw2WAIp2IOi8GUSrQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/book/pages/manager/alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 付款结束后跳转的页面
	public static String return_url = "http://localhost:8080/book/pages/cart/checkout.jsp";


	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

