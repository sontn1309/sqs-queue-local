package com.sontn.demo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfiguration {

    @Bean
    public AmazonSQS amazonSQS() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder
                .EndpointConfiguration("http://localhost:4566", Regions.US_EAST_1.getName())).build();
        ListQueuesResult lq_result = sqs.listQueues();
        return sqs;
    }
}
