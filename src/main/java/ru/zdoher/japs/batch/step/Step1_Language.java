package ru.zdoher.japs.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.batch.domain.H2Language;
import ru.zdoher.japs.batch.processor.H2LanguageProcessor;
import ru.zdoher.japs.batch.writer.H2LanguageWriter;
import ru.zdoher.japs.domain.Language;

import java.util.HashMap;

@Configuration
public class Step1_Language {
    private StepBuilderFactory stepBuilderFactory;

    private MongoTemplate mongoTemplate;

    public Step1_Language(StepBuilderFactory stepBuilderFactory, MongoTemplate mongoTemplate) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public MongoItemReader<Language> languageItemReader() {
        MongoItemReader<Language> reader = new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setQuery("{}");
        reader.setTargetType(Language.class);
        reader.setSort(new HashMap<>() {
            {
                put("_Id", Sort.Direction.DESC);
            }
        });

        return reader;
    }

    @Bean
    public H2LanguageProcessor languageProcessor() {
        return new H2LanguageProcessor();
    }

    @Bean
    public ItemWriter<H2Language> languageWriter() {
        return new H2LanguageWriter();
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("import language")
                .<Language, H2Language>chunk(5)
                .reader(languageItemReader())
                .processor(languageProcessor())
                .writer(languageWriter())
                .build();
    }

}
