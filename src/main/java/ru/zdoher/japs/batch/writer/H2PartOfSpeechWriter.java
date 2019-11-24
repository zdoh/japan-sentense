package ru.zdoher.japs.batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.zdoher.japs.batch.domain.H2PartOfSpeech;
import ru.zdoher.japs.batch.repositories.H2PartOfSpeechRepository;

import java.util.List;

public class H2PartOfSpeechWriter implements ItemWriter<H2PartOfSpeech> {

    @Autowired
    private H2PartOfSpeechRepository h2PartOfSpeechRepository;

    @Override
    public void write(List<? extends H2PartOfSpeech> items) throws Exception {
        for (H2PartOfSpeech item : items) {
            h2PartOfSpeechRepository.save(item);
        }
    }
}
