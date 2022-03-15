package com.aviation.util;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class AlipayConfig {


//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119623924";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCfFxZy8klxsp2szZP1V23DZEEc8ai3GzngKvTquiOIeOgxieteIOpw/V5woRsF51Nq/mnMvJSpBvhmPXgECuyhsOsvCuNjGSl+6ZmHSR2TGfrL9iZCr4LNDxcqpmRwIsJGmJHVkA06M4n9PG0B0olq+VLosBb+1ZUe8+ZiJOmLznmBeSzKYMav5b4HfPZ46Iy02DM0DAlKxoNr5esro3H5o7s5+X+YA9UaRYEQUAtHCrYzj8K7yERW15df/oYsL3cHE8f9Q4DH/+kZ9xTxD/HFx5oZJSuc/TgnsgOJ5LBPZruc4Y505rytdqDFKbjvx4Z0J/tfDkuDbwih4NI+3jvnAgMBAAECggEACA1OGJFEwFlu+5EIHRHIv2vyk7lzdZkOK9dgwASdycl8zw0Q+Zmm5AMe5Ypx6LGVmkO4LSGaUJfGuL4BtgqrgV+H98CQU7KxU/gUyjEcKxbUh8A0nYlukFxkKsdzK+3GcXZFY07ALKLxJ/0H82Cpjd2Cob5P26QJwSBNF8iQfX/oVEulL5a3S2phrgfUTYTx9BWwaHwEIOeq/AcmjXx1t27dX+54jaeetVcyXEPD5dngYKJfTaq1YV6P0pB2Fuiv1djyePVUPWMlYa2N1Yo4fjFDlBDeGfcohyLQQbtZ4irs5YgGnFEwsPVC90cMHXzsnNx+J4yUmAOFhz3gDlxJEQKBgQDW+W/xzWVV49RyfTpWvALLHrIrPwi9bDXFqAconfbOAG2jpteX93kOsrUfaB2tgwFd9T/qVbRhwqFs8Sq2GcpRsm6sEsOxBgqwxRIP5q7VsyZ8HiRhDGLNibuSg1TWoBX0eZfL+TtxLDvTaABTVkMHTV2NxCbOi0/mKryszZOImQKBgQC9c25zdu5oENu534C6B1r0DwmDqQlsXhRWrbWoCDt7TxDUcgjwVqtQ8UHWUJb+evdYNDiK1OeUxv/RSEsoLkYQEL61HzoueicEjwPGNdOP9maiPQh/BTMJbVBmpERmVzFchQBt8k6uNEllDfnTJsAly7ZcUF7fK9J0cmb1pqw4fwKBgHQw8b6Bw4m+0G7pHIUQrXnXp3kUYsbvG8kvXl8nseP5+0h+vvxWN8on8Rl+jrvfmPeNvPQNSqekKNfXKbyvB9lMVeEPa1Hc8B5HBdIuXsUGRYDEUelaZnStQwKXlV1DvVob9l264dPzkopbJgHlF+l0eWJMaKUuSwsegkfr/RfRAoGAW4be/62ftGsgnIYcPMO871gsco1B3jb9gHrf3lRL2GD0co69Ps/AaJSGCDJbIIrr4JMqFfiSAVC62rMgjEL+2lgcqohxpW6iVxN48VOj6FNUdmEiL6ulYpKLW2tVGFRbpqUi9fswg/0C0G2WGqsH/bqTWboCe7NCM7vpfhiN76UCgYBEsndJ3c4F4WvXW8Mw21BloRqv4Z9MkKsFPrZKmGQSBTBPE+3ckPtnNYilmPvyZWpTaPGjJZMQZj9wsuT98oOeyknPfOFAI5XMIc+PpdAo/rZCGwNri7AE+oYycsm5Z0x+3QgB+M8qQOCFCBk1F/ti2j86zArizNhZhkvXsQRU1Q==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhLvgY0OVOKVeOwm/45gZAE51K7SWgS4ltfLanqmn32wLqNchsX0gukYpPDlVImjilCHtZ9SUx6T1cLNxmae4J8KU5LM7yPU70nmfKhSL69rNoIE+39LBPIRvoClGmMQKiaitqYndny1n8o61XcTYatNLUpZ49PXkD5/jjpNVmNiguJQ1U8aBCFz2LiSj6x/INlvH/rR5enUgm4F4i4YA+Re8u653cEOYdrtyfRtb147h64KkqTd0bvEMS0BSLploknt0Yi+aiLYncbfPAmff/0BZzHLbFdzm3HP5UUbx/LijkTTOwvz/OmUhZ+h9nIvOfAwWlrg9xDYfQmfwmtiJZwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，
    public static String notify_url = "http://localhost:8081/aviation/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/aviation/return_url";

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
