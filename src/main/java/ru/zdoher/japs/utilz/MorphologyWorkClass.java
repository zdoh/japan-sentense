package ru.zdoher.japs.utilz;

import ru.zdoher.japs.domain.sentence.Sentence;

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
    }

}
