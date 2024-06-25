package com.javatechie.spring.batch;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javatechie.spring.batch.config.MapItemProcessor;
import com.javatechie.spring.batch.entity.GenericEntity;

@SpringBootApplication(scanBasePackages = "com.javatechie.spring.batch")
public class SpringBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }
    
    @Bean
    public ItemProcessor<Map<String, String>, GenericEntity> processor() {
        return new MapItemProcessor();
    }
}
