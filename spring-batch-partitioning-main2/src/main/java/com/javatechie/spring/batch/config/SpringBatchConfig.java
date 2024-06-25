package com.javatechie.spring.batch.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.javatechie.spring.batch.entity.GenericEntity;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public GenericEntityWriter writer;

    @Autowired
    public ItemProcessor<Map<String, String>, GenericEntity> processor;

    @Bean
    @StepScope
    public FlatFileItemReader<Map<String, String>> reader(@Value("#{jobParameters['filePath']}") String filePath) {
        FlatFileItemReader<Map<String, String>> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(filePath));
        reader.setLinesToSkip(1); // Skip header row
        reader.setLineMapper(lineMapper(filePath));
        return reader;
    }

    private LineMapper<Map<String, String>> lineMapper(String filePath) {
        DefaultLineMapper<Map<String, String>> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer(filePath));
        lineMapper.setFieldSetMapper(new DynamicFieldSetMapper());
        return lineMapper;
    }

    private DelimitedLineTokenizer lineTokenizer(String filePath) {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(DelimitedLineTokenizer.DELIMITER_COMMA);
        tokenizer.setNames(getColumnNames(filePath));
        return tokenizer;
    }

    private String[] getColumnNames(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            return headerLine.split(",");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the CSV file header", e);
        }
    }

    public static class DynamicFieldSetMapper implements FieldSetMapper<Map<String, String>> {
        @Override
        public Map<String, String> mapFieldSet(FieldSet fieldSet) throws BindException {
            Map<String, String> map = new HashMap<>();
            for (String name : fieldSet.getNames()) {
                map.put(name, fieldSet.readString(name));
            }
            return map;
        }
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Map<String, String>, GenericEntity>chunk(10)
                .reader(reader(null))
                .processor(processor)
                .writer(writer)
                .build();
    }

    
    
    
    @Bean
    public Job importCsvToDBJob() {
        return jobBuilderFactory.get("importCsvToDBJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
