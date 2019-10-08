package ru.zdoher.japs.utilz;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import ru.zdoher.japs.domain.sentence.Sentence;

import java.util.List;

public class MorphologyWorkClass {


    public void doWork() {

        otstup();
        morphologyTest();
    }

    public void otstup() {
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println("begin");
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println();
    }


    public void morphologyTest() {
        Sentence sentence = new Sentence();
        sentence.setSentence("私は会社員です。");
        System.out.println(sentence);

        getAllToken(sentence);

    }


    private void getAllToken(Sentence sentence) {
        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize(sentence.getSentence());



        for (Token token : tokens) {
            System.out.println(token.getSurface() + "\t" +
                    token.getPartOfSpeechLevel1() + "|" +
                    token.getPartOfSpeechLevel2() + "|" +
                    token.getPartOfSpeechLevel3() + "|" +
                    token.getPartOfSpeechLevel4() + "|" +
                    token.getConjugationType() + "|" +
                    token.getAllFeatures());
        }
    }
}
