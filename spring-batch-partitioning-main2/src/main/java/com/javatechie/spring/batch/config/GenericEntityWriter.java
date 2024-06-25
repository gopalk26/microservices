package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.GenericEntity;
import com.javatechie.spring.batch.repository.GenericEntityRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericEntityWriter implements ItemWriter<GenericEntity> {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Override
    public void write(List<? extends GenericEntity> list) throws Exception {
        System.out.println("Thread Name : -" + Thread.currentThread().getName());
        genericEntityRepository.saveAll(list);
    }
}
