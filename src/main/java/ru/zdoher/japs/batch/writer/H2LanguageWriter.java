package ru.zdoher.japs.batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.zdoher.japs.batch.domain.H2Language;
import ru.zdoher.japs.batch.repositories.H2LanguageRepository;

import java.util.List;

public class H2LanguageWriter implements ItemWriter<H2Language> {

    @Autowired
    private H2LanguageRepository h2LanguageRepository;

    @Override
    public void write(List<? extends H2Language> items) throws Exception {
        for (H2Language item : items) {
            h2LanguageRepository.save(item);
        }
    }
}
