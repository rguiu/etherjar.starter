package com.ethereumclassic.etherjar.starter;

import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ethereumclassic.etherjar.starter.ethereum.EthProxy;

@Configuration
public class Config {

    @Bean
    EthProxy ethereumBean() throws Exception {
        EthProxy ethProxy = new EthProxy();
        Executors.newSingleThreadExecutor().submit(ethProxy::start);

        return ethProxy;
    }
}
