package com.xbb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {

    // 自己的appId
    public static String appId = "9021000142664723";
    // 应用私有秘钥
    public static String appPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQD2rj9DihTd8SwRm1Vs58XyL7xMbWuRP43+Bp0lfT+XKBw7/dlKYEATN09aNzTaEmNWEvBl3d5zfopscEbpyD8Nqb6u2q0bJi/e5lAvOiMscnFDgKBv4krGrklmLRyd72sfafuTDiQD4t8nBaAvHUTcv7bqAHK0tKkDHJYyC+GdMtTRP4t3xNlZ9mO0yLMtJ6ss8vylwo3yCnU7o3+x3kiGSaS1zmFfKQZdyOpehMCExEKngwqk091kNeUKwORmIL3dAOFFXsZRgkcRMjQYWsrcUNSm6hixC3+8Oyw80OOq02K5XhVlYmd/RP3lHgYzEGWOolejBIJj8GW9bGXQd1jxAgMBAAECggEBAK9IEVwEed9ax12bapAAAP+eO8Zy2cRTzKl8OZ2x6cWWkrluH0BiNCVzX8dTAxMRjdRTkM5RYQfgGqwC++CSkXs76mqEqAxqjglszf1A6k1i5Gh6tYXK3idfIHiiBXuT7CJeRIyxt5WrV7V6od/YhF33PBn6R4dv98hmP7NADgiL+Njr8d4YT3uE2zSE1ymruYS1NYLVgWxh7HTE9i/+MOV2twtJBw2SxtB0QLe0WgbmsqCzekCg4icnu1OlzVUyuUwrbJCvr1jGAN1Bs8453+j5GcCFYdQ6l92mkZcdXIMooL48BaisAegVjp0XZN6j9uuaPOxcIDuNI7I3rSYUQSECgYEA/Uy/lTITc3Sz7uYywlvxCUlBL99Sy3ZxmCrwT7sDbtB6wPoVh/iW5cyBn6bmXtgztatXgpGxZe9CHX+ICcIifLMjNOEddXk/7WkbqbyfIkRyNOsZNKbiUA0EEUe45hUhE5hSsbAb+Fa7FhGBRbViITkQrI3KSq82gHNuQFsuvxsCgYEA+U9vaSIlbVnSweTh9am/pwhV9c6ZmqCyXdeQVwi66sD7G3y+gnZkoQ40gas7mIqnMPwi8IBnirgkL7X2kqGHsj0lh9KeSV2pQFnV+VElnQ4fbv8QbVUThreJLHlBZggDS+GDV4tPb4gbe3LTfp8k2M8IJN4dyDjDwEMzlXv17OMCgYB1UGN25R9vHMDtR36A1/ZV17CyTFtbUnsf/9sXAkV/wFzqHal1NSQmQEZUvAb8LGQeosG//lxMGrjjUpqd8mTonksTBaQQMVzzRvgB8BM/2rWOXshow1YTv0OAAVjYbzbHjYfXNfpuVTUG7oqRz4UoX/aiBHWJi4bRjSSl99U5uwKBgFciHSUYaw5J23Aqx5Jtjm8ZabmsSGETkuNbaLYSdgmAAwM7WPYN3OOxLEa5iu2oYACtzqRRrF5+Nx95sEDVNbDk0A4lXW70zieQfklRxBydB/1qJdqgZl+qG8YwZtv7JvPJUHczWEL5xekiW6qggmdIDGeePbhxpnC2y/uNxIjTAoGBAOr4mu8qPf204bJlh0Gp4UhclAhbsrEaUyroYYvEpFyKzODfROUuIW2z7Ie+nPluF8Cxw09lOZsHpmQ7+AXW6fgd14P8fFO/t3R26k8vFTNu4+BznVc5e0cC9m5n2XxGcYDoJ7Me+vXs9jWafgW+fKCzdHjaBdOtTrIjm7qzLeQv";
    // 支付宝公钥
    public static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnr2KxcPAum5HOgOzdHFyFDqms07lv46bqVbJrqcjQgEJU+Ru+Urj437qjK3eRtkt7V7LgUbFvIo/1ZfY8XNDxVyHoNrlGMHnOUwKvQUoY+qLHNsJMzXNtGTnR6fBXoB6PbJX8ZPr1b9zpfeD5cYpCRoeUEAMRkR4mn6tpnqg7W69hJSgeZ0TZE67XubEHmgp4g56rpkUdwDLXsJAbjyZn/Fxw4ZrYXw6KVCfnskh7EE9C4JNzx93mXFhmnC/2b4fhIKrVTNpNYXNGR8BhOKHmEkXHvrFGm+4hfni6XMDh9fDsjtrMrQ39wH9LEhROFVkFngZcIQzMmu+jyuG1iC8MwIDAQAB";
    // 异步回调地址
    public static String notifyUrl = "http://localhost:8088/alipay/notifyNotice";
    // 同步回调地址
    public static String returnUrl = "http://localhost:8088/alipay/returnNotice";
    // 推荐使用这个秘钥
    public static String signType = "RSA2";
    // 使用的编码格式
    public static String charset = "utf-8";
    // 支付宝默认网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

}
