package com.grpc.demo.config;

import io.grpc.netty.NettyServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.server.ServerBuilderCustomizer;

import java.util.concurrent.TimeUnit;

@Configuration
public class GrpcServerKeepAliveConfig {


    @Bean
    ServerBuilderCustomizer<NettyServerBuilder> nettySeverBuilderCustomizer() {

        return severBuilder -> severBuilder.permitKeepAliveTime(10, TimeUnit.SECONDS).
                permitKeepAliveWithoutCalls(true);

    }


}
