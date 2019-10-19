package ru.zdoher.japs.service.log;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.log.MorphologyLog;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.repositories.log.MorphologyLogRepository;

import java.time.LocalDateTime;

@Service
public class MorphologyLogServiceImpl implements MorphologyLogService {
    private MorphologyLogRepository morphologyLogRepository;

    public MorphologyLogServiceImpl(MorphologyLogRepository morphologyLogRepository) {
        this.morphologyLogRepository = morphologyLogRepository;
    }

    public void missingKuramojiPartOfSpeech(String sentence, String word, String kuramojiPartOfSpeech) {
        String message = "В предложение \"" +
                sentence +
                "\" присутствует неизвестный kuramojiPartOfSpeech. " +
                " В слове " +
                word +
                " - " +
                kuramojiPartOfSpeech;

        morphologyLogRepository.insert(Mono.just(new MorphologyLog(LocalDateTime.now(), message))).blockFirst();
    }

    public void missingWord(String sentence, String word) {
        String message = "В предложение \"" +
                sentence +
                "\" присутствует неизвестное слово - " +
                word;

        morphologyLogRepository.insert(Mono.just(new MorphologyLog(LocalDateTime.now(), message))).blockFirst();
    }

    @Override
    public void cannotAddSentence(String sentence) {
        String message = "Не смог добавить предложение \"" +
                sentence +
                "\"";

        morphologyLogRepository.insert(Mono.just(new MorphologyLog(LocalDateTime.now(), message))).blockFirst();
    }
}
