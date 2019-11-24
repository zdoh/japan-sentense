package ru.zdoher.japs.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.batch.domain.H2PartOfSpeech;
import ru.zdoher.japs.batch.processor.H2PartOfSpeechProcessor;
import ru.zdoher.japs.batch.writer.H2PartOfSpeechWriter;
import ru.zdoher.japs.domain.PartOfSpeech;

import java.util.HashMap;

@Configuration
public class Step2_PartOfSpeech {
    private StepBuilderFactory stepBuilderFactory;

    private MongoTemplate mongoTemplate;


    public Step2_PartOfSpeech(StepBuilderFactory stepBuilderFactory, MongoTemplate mongoTemplate) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.mongoTemplate = mongoTemplate;
    }


    @Bean
    public MongoItemReader<PartOfSpeech> partOfSpeechItemReader() {
        MongoItemReader<PartOfSpeech> reader = new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setQuery("{}");
        reader.setTargetType(PartOfSpeech.class);
        reader.setSort(new HashMap<>() {
            {
                put("_Id", Sort.Direction.DESC);
            }
        });

        return reader;
    }


    @Bean
    public H2PartOfSpeechProcessor partOfSpeechProcessor() {
        return new H2PartOfSpeechProcessor();
    }

    @Bean
    public ItemWriter<H2PartOfSpeech> partOfSpeechWriter() {
        return new H2PartOfSpeechWriter();
    }


    @Bean
    public Step step2() {
        return stepBuilderFactory.get("import part of speech")
                .<PartOfSpeech, H2PartOfSpeech>chunk(5)
                .reader(partOfSpeechItemReader())
                .processor(partOfSpeechProcessor())
                .writer(partOfSpeechWriter())
                .build();
    }





}
