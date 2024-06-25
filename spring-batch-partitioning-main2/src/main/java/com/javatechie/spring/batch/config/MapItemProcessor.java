package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.GenericEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MapItemProcessor implements ItemProcessor<Map<String, String>, GenericEntity> {
    @Override
    public GenericEntity process(Map<String, String> item) {
        GenericEntity entity = new GenericEntity();
        entity.setFields(item);
        return entity;
    }
}
