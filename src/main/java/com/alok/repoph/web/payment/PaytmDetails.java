package com.alok.repoph.web.payment;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PaytmDetails {
    private String merchantId;
    private String merchantKey;
    private String channelId;
    private String Website;
    private String industryTypeId;
    private String paytmUrl;
    private Map<String,String> details;
}
