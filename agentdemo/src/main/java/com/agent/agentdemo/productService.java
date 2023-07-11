package com.agent.agentdemo;

import io.opentelemetry.api.trace.TracerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class productService {

    WebClient.Builder builder = WebClient.builder();



    public Long getPrice(Long id){
        String url = "localhost:8680/price?id=";
        url = url + id.toString();
        Long value = builder.build().get().uri(url).retrieve().bodyToMono(Long.class).block();
        return value;
    }

    /*public void traceGenerator(){
        TracerBuilder tracerBuilder =
    }*/
}
