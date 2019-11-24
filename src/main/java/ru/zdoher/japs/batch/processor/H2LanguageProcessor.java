package ru.zdoher.japs.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import ru.zdoher.japs.batch.domain.H2Language;
import ru.zdoher.japs.domain.Language;

public class H2LanguageProcessor implements ItemProcessor<Language, H2Language> {

    @Override
    public H2Language process(Language item) throws Exception {
        return new H2Language(item.getShortName(), item.getFullName());
    }
}
