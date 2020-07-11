package com.denosauro.cardcontroller.service.salto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "client.config")
public class SaltoProperties {

    private String host;

    private Integer port;
}
