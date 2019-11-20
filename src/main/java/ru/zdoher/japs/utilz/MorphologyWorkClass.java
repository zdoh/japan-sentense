package ru.zdoher.japs.utilz;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.stereotype.Service;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.domain.morphology.KuramojiPartOfSpeech;
import ru.zdoher.japs.domain.morphology.KuramojiTypeOfSpeech;
import ru.zdoher.japs.domain.morphology.MyKuramojiToken;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.repositories.WordRepositories;
import ru.zdoher.japs.repositories.morphology.KuramojiPartOfSpeechRepository;
import ru.zdoher.japs.repositories.sentence.SentenceRepository;
import ru.zdoher.japs.service.log.MorphologyLogService;

import javax.naming.ldap.PagedResultsControl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MorphologyWorkClass {
    private KuramojiPartOfSpeechRepository kuramojiPartOfSpeechRepository;
    private WordRepositories wordRepositories;
    private MorphologyLogService morphologyLogService;
    private SentenceRepository sentenceRepository;

    public MorphologyWorkClass(KuramojiPartOfSpeechRepository kuramojiPartOfSpeechRepository,
                               WordRepositories wordRepositories,
                               MorphologyLogService morphologyLogService,
                               SentenceRepository sentenceRepository) {
        this.kuramojiPartOfSpeechRepository = kuramojiPartOfSpeechRepository;
        this.wordRepositories = wordRepositories;
        this.morphologyLogService = morphologyLogService;
        this.sentenceRepository = sentenceRepository;
    }

    public void doWork() {
        otstup("начинаю");
        morphologyTest();
    }

    public void otstup(String msg) {
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println("///  " + msg);
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println();
    }


    public void morphologyTest() {
        Sentence sentence = new Sentence();
        //sentence.setSentence("私は会社員ですか。");
        sentence.setSentence("ミラーさんはIMCの社員です。");
        //sentence.setSentence("朝ご飯を食べます。");
        //sentence.setSentence("本当のことを話そうか話すまいか迷ったが、結局全部話した。");
        //sentence.setSentence("お忙しい。忙しい");

        /*List<Sentence> sentenceList = sentenceRepository.findAll().collectList().block();
        otstup("определяю слова");
        for (Sentence sentence : sentenceList) {
            System.out.print(sentence.getSentence() + ": ");
            boolean sentenceHasMissingData = getWordMap(sentence);

            if (!sentenceHasMissingData) {
                System.out.println("sentence got correct morphology");
            } else {
                System.out.println("found some error!");
            }
        }*/

        otstup("определяю слова");
        boolean sentenceHasMissingData = getWordMap(sentence);
        System.out.println(sentence);

    }

    private boolean getWordMap(Sentence sentence) {

        List<MyKuramojiToken> myKuramojiTokens = new Tokenizer().tokenize(sentence.getSentence())
                .stream()
                .map(MyKuramojiToken::new)
                .collect(Collectors.toList());

        /*for (MyKuramojiToken token : myKuramojiTokens) {
            System.out.println(token.getToken().getSurface() + "\t" +
                    token.getToken().getPartOfSpeechLevel1() + "|" +
                    token.getToken().getPartOfSpeechLevel2() + "|" +
                    token.getToken().getPartOfSpeechLevel3() + "|" +
                    token.getToken().getPartOfSpeechLevel4() + "|" +
                    token.getToken().getConjugationType() + "|" +
                    token.getToken().getConjugationForm() + "|" +
                    token.getToken().getBaseForm() + "|" +
                    token.getToken().getAllFeatures());
        }*/

        boolean sentenceHasMissingData;

        sentenceHasMissingData = fillKuramojiPartOfSpeech(myKuramojiTokens, sentence.getSentence());
        if (sentenceHasMissingData) return true;

        sentenceHasMissingData = fillSentenceByWord(myKuramojiTokens, sentence);
        if (sentenceHasMissingData) return true;

        System.out.println(sentence);
        //sentenceRepository.save(sentence).block();

        //System.out.println(sentence);
        //myKuramojiTokens.forEach(k -> System.out.println(k.getToken().getSurface() + ": " + k.getKuramojiPartOfSpeeches()));

        //stringKuramojiPartOfSpeechMap.forEach((k, v ) -> System.out.println(k + " - " + v));


            /*for (String kuramojiPartOfSpeech : havedKuramojiPartOfSpeech) {
                if (isMainPartOfSpeech(kuramojiPartOfSpeech) == KuramojiTypeOfSpeech.MAIN) {
                    wordMap.putIfAbsent(tokenList.get(i).getSurface(), getWordFromDb(tokenList.get(i).getBaseForm()));
                }

                int previousId = i - 1;
                if (isMainPartOfSpeech(kuramojiPartOfSpeech) == KuramojiTypeOfSpeech.SUFFIX && previousId > 0) {
                    List<String> previousKuramojiPartOfSpeechList = normalizeKuramojiPartOfSpeech(tokenList.get(previousId));

                    for (String previousKuramojiPartOfSpeech : previousKuramojiPartOfSpeechList) {
                        if (isMainPartOfSpeech(previousKuramojiPartOfSpeech) == KuramojiTypeOfSpeech.MAIN) {
                            wordMap.putIfAbsent(tokenList.get(previousId).getSurface() + tokenList.get(i).getSurface(),
                                    getWordFromDb(tokenList.get(previousId).getBaseForm() + tokenList.get(i).getSurface()));

                            break;
                        }
                    }
                }
            }*/

        return false;
    }

    private boolean fillKuramojiPartOfSpeech(List<MyKuramojiToken> myKuramojiToken, String sentence) {
        boolean sentenceHasMissingData = false;
        for (MyKuramojiToken kuramojiToken : myKuramojiToken) {
            List<String> wordHavedKuramojiPartOfSpeech = normalizeKuramojiPartOfSpeech(kuramojiToken.getToken());

            for (String kuramojiPartOfSpeech : wordHavedKuramojiPartOfSpeech) {
                KuramojiPartOfSpeech resultKuramojiPartOfSpeech = kuramojiPartOfSpeechRepository.findByName(kuramojiPartOfSpeech).block();

                if (resultKuramojiPartOfSpeech == null) {
                    sentenceHasMissingData = true;
                    morphologyLogService.missingKuramojiPartOfSpeech(sentence, kuramojiToken.getToken().getSurface(), kuramojiPartOfSpeech);
                }

                kuramojiToken.getKuramojiPartOfSpeeches().add(resultKuramojiPartOfSpeech);
            }
        }

        return sentenceHasMissingData;
    }

    private List<String> normalizeKuramojiPartOfSpeech(Token token) {
        List<String> havedKuramojiPartOfSpeech = new ArrayList<>();

        if (!token.getPartOfSpeechLevel1().equals("*")) {
            if (token.getPartOfSpeechLevel1().contains("／")) {
                havedKuramojiPartOfSpeech.addAll(List.of(token.getPartOfSpeechLevel1().split("／")));
            } else {
                havedKuramojiPartOfSpeech.add(token.getPartOfSpeechLevel1());
            }
        }

        if (!token.getPartOfSpeechLevel2().equals("*"))
            if (token.getPartOfSpeechLevel2().contains("／")) {
                havedKuramojiPartOfSpeech.addAll(List.of(token.getPartOfSpeechLevel2().split("／")));
            } else {
                havedKuramojiPartOfSpeech.add(token.getPartOfSpeechLevel2());
            }

        if (!token.getPartOfSpeechLevel3().equals("*"))
            if (token.getPartOfSpeechLevel3().contains("／")) {
                havedKuramojiPartOfSpeech.addAll(List.of(token.getPartOfSpeechLevel3().split("／")));
            } else {
                havedKuramojiPartOfSpeech.add(token.getPartOfSpeechLevel3());
            }

        if (!token.getPartOfSpeechLevel4().equals("*"))
            if (token.getPartOfSpeechLevel4().contains("／")) {
                havedKuramojiPartOfSpeech.addAll(List.of(token.getPartOfSpeechLevel4().split("／")));
            } else {
                havedKuramojiPartOfSpeech.add(token.getPartOfSpeechLevel4());
            }

        return havedKuramojiPartOfSpeech;
    }

    private boolean fillSentenceByWord(List<MyKuramojiToken> myKuramojiToken, Sentence sentence) {
        boolean sentenceHasMissingData = false;

        for (MyKuramojiToken kuramojiToken : myKuramojiToken) {


            for (KuramojiPartOfSpeech kuramojiPartOfSpeech : kuramojiToken.getKuramojiPartOfSpeeches()) {
                if (kuramojiPartOfSpeech.getType() != null &&
                        kuramojiPartOfSpeech.getType() == (KuramojiTypeOfSpeech.MAIN)) {

                    Word tmpWord = getWordFromDb(kuramojiToken.getToken().getBaseForm());
                    if (tmpWord == null) {
                        sentenceHasMissingData = true;
                        morphologyLogService.missingWord(sentence.getSentence(), kuramojiToken.getToken().getSurface());
                    } else {
                        if (sentence.getWords() == null) {
                            sentence.setWords(new ArrayList<>(List.of(tmpWord)));
                        } else {
                            sentence.getWords().add(tmpWord);
                        }
                    }

                    break;
                }
            }
        }

        System.out.println(sentence);

        return sentenceHasMissingData;
    }

    private Word getWordFromDb(String word) {
        Word tmp = wordRepositories.findByWordKanji(word).block();
        if (tmp == null) wordRepositories.findByPronunciation(word).block();
        return tmp;
    }

}
