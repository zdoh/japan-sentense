package ru.zdoher.japs.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.zdoher.japs.batch.domain.H2Language;
import ru.zdoher.japs.batch.domain.H2PartOfSpeech;
import ru.zdoher.japs.batch.domain.H2TranslateEntity;
import ru.zdoher.japs.batch.repositories.H2LanguageRepository;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.ArrayList;
import java.util.List;

public class H2PartOfSpeechProcessor implements ItemProcessor<PartOfSpeech, H2PartOfSpeech> {
    @Autowired
    private H2LanguageRepository h2LanguageRepository;

    @Override
    public H2PartOfSpeech process(PartOfSpeech item) throws Exception {
        H2PartOfSpeech h2PartOfSpeech = new H2PartOfSpeech();
        h2PartOfSpeech.setJapanName(item.getJapanName());
        h2PartOfSpeech.setShortName(item.getShortName());
        List<H2TranslateEntity> h2TranslateEntities = new ArrayList<>();
        for (TranslateEntity translateEntity : item.getTranslateName()) {
            H2Language language = h2LanguageRepository.findByShortName(translateEntity.getLanguage().getShortName());
            h2TranslateEntities.add(new H2TranslateEntity(language, translateEntity.getTranslate(), h2PartOfSpeech));
        }
        h2PartOfSpeech.setH2TranslateEntity(h2TranslateEntities);
        return h2PartOfSpeech;
    }
}
