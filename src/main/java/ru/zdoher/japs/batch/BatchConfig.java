package ru.zdoher.japs.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.zdoher.japs.batch.step.Step1_Language;
import ru.zdoher.japs.batch.step.Step2_PartOfSpeech;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private Step1_Language step1_language;
    private Step2_PartOfSpeech step2_partOfSpeech;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, Step1_Language step1_language, Step2_PartOfSpeech step2_partOfSpeech) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step1_language = step1_language;
        this.step2_partOfSpeech = step2_partOfSpeech;
    }

    @Bean
    public Job languageImport() {
        return jobBuilderFactory.get("import two entity from mongo")
                .start(step1_language.step1())
                .next(step2_partOfSpeech.step2())
                .build();
    }
}
