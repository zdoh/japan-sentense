package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "006")
public class Init_006_Kanji {
    private Map<String, Kanji> kanjiMap;
    private Map<String, Language> languageMap;
    private Map<String, Word> wordsMap;

    public Init_006_Kanji() {
        kanjiMap = InitMaps.kanjiMap;
        languageMap = InitMaps.languageMap;
        wordsMap = InitMaps.wordsMap;
    }

    @ChangeSet(order = "001", id = "initialKanji", author = "zdoh", runAlways = true)
    public void initKanji(MongoTemplate template) {
        kanjiMap.put("一", template.save(
                new Kanji("一",
                        List.of(new TranslateEntity(languageMap.get("ru"), "один"), new TranslateEntity(languageMap.get("en"), "one")),
                        List.of("イチ", "イツ"), List.of("ひと"), List.of(wordsMap.get("一つ")), wordsMap.get("一月"))));

        kanjiMap.put("二", template.save(
                new Kanji("二",
                        List.of(new TranslateEntity(languageMap.get("ru"), "два"), new TranslateEntity(languageMap.get("en"), "two")),
                        List.of("ニ"), List.of("ふた"), List.of(wordsMap.get("二つ")), wordsMap.get("二月"))));

        kanjiMap.put("三", template.save(
                new Kanji("三",
                        List.of(new TranslateEntity(languageMap.get("ru"), "три"), new TranslateEntity(languageMap.get("en"), "three")),
                        List.of("サン"), List.of("み", "みっ"), List.of(wordsMap.get("三つ")), wordsMap.get("三月"))));

        kanjiMap.put("四", template.save(
                new Kanji("四",
                        List.of(new TranslateEntity(languageMap.get("ru"), "четыре"), new TranslateEntity(languageMap.get("en"), "four")),
                        List.of("シ"), List.of("よ", "よつ", "よん"), List.of(wordsMap.get("四つ")), wordsMap.get("四月"))));

        kanjiMap.put("五", template.save(
                new Kanji("五",
                        List.of(new TranslateEntity(languageMap.get("ru"), "пять"), new TranslateEntity(languageMap.get("en"), "five")),
                        List.of("ゴ"), List.of("いつ"), List.of(wordsMap.get("五つ")), wordsMap.get("五月"))));

        kanjiMap.put("六", template.save(
                new Kanji("六",
                        List.of(new TranslateEntity(languageMap.get("ru"), "шесть"), new TranslateEntity(languageMap.get("en"), "six")),
                        List.of("ロク"), List.of("むつ", "むい"), List.of(wordsMap.get("六つ")), wordsMap.get("六月"))));

        kanjiMap.put("七", template.save(
                new Kanji("七",
                        List.of(new TranslateEntity(languageMap.get("ru"), "семь"), new TranslateEntity(languageMap.get("en"), "seven")),
                        List.of("シチ"), List.of("なな", "なの"), List.of(wordsMap.get("七つ")), wordsMap.get("七月"))));

        kanjiMap.put("八", template.save(
                new Kanji("八",
                        List.of(new TranslateEntity(languageMap.get("ru"), "восемь"), new TranslateEntity(languageMap.get("en"), "eight")),
                        List.of("ハチ"), List.of("や", "やつ", "よう"), List.of(wordsMap.get("八つ")), wordsMap.get("八月"))));

        kanjiMap.put("九", template.save(
                new Kanji("九",
                        List.of(new TranslateEntity(languageMap.get("ru"), "девять"), new TranslateEntity(languageMap.get("en"), "nine")),
                        List.of("キュウ", "ク"), List.of("ここの"), List.of(wordsMap.get("九つ")), wordsMap.get("九月"))));

        kanjiMap.put("十", template.save(
                new Kanji("十",
                        List.of(new TranslateEntity(languageMap.get("ru"), "пять"), new TranslateEntity(languageMap.get("en"), "five")),
                        List.of("サン"), List.of("と"), List.of(wordsMap.get("十")), wordsMap.get("十日"))));

        kanjiMap.put("人", template.save(
                new Kanji("人",
                        List.of(new TranslateEntity(languageMap.get("ru"), "человек")),
                        List.of("ジン", "ニン"), List.of(wordsMap.get("人")), wordsMap.get("日本人"))));

        kanjiMap.put("名", template.save(
                new Kanji("名",
                        List.of(new TranslateEntity(languageMap.get("ru"), "имя")),
                        List.of("メイ", "ミョウ"), List.of(wordsMap.get("名")), wordsMap.get("有名"))));

        kanjiMap.put("方", template.save(
                new Kanji("方",
                        List.of(new TranslateEntity(languageMap.get("ru"), "направление; сторона")),
                        List.of("ホウ"), List.of("かた"), null, wordsMap.get("方法"))));

        kanjiMap.put("本", template.save(
                new Kanji("本",
                        List.of(new TranslateEntity(languageMap.get("ru"), "книга; основа; источник")),
                        List.of("ホン"), List.of("もと"), null, wordsMap.get("日本"))));

        kanjiMap.put("日", template.save(
                new Kanji("日",
                        List.of(new TranslateEntity(languageMap.get("ru"), "день, солнце, счетчик для дней")),
                        List.of("ニチ", "ジツ"), List.of("か"), List.of(wordsMap.get("日")), wordsMap.get("毎日"))));

        kanjiMap.put("何", template.save(
                new Kanji("何",
                        List.of(new TranslateEntity(languageMap.get("ru"), "что")),
                        List.of("カ"), List.of(wordsMap.get("何")),  null)));

        kanjiMap.put("大", template.save(
                new Kanji("大",
                        List.of(new TranslateEntity(languageMap.get("ru"), "большой")),
                        List.of("ダイ", "タイ"), List.of("おお"), List.of(wordsMap.get("大きい"), wordsMap.get("大いに")), wordsMap.get("大学"))));

        kanjiMap.put("学", template.save(
                new Kanji("学",
                        List.of(new TranslateEntity(languageMap.get("ru"), "учиться; учеба; наука")),
                        List.of("ガク"), List.of(wordsMap.get("学ぶ")), wordsMap.get("大学"))));

        kanjiMap.put("社", template.save(
                new Kanji("社",
                        List.of(new TranslateEntity(languageMap.get("ru"), "фирма")),
                        List.of("シャ"), List.of(wordsMap.get("社")), wordsMap.get("社員"))));

        kanjiMap.put("員", template.save(
                new Kanji("員",
                        List.of(new TranslateEntity(languageMap.get("ru"), "работник; сотрудник; член персонала; суффикс профессии")),
                        List.of("イン"), null, null, wordsMap.get("社員"))));

        kanjiMap.put("会", template.save(
                new Kanji("会",
                        List.of(new TranslateEntity(languageMap.get("ru"), "встреча")),
                        List.of("カイ", "エ"), List.of(wordsMap.get("会う")), wordsMap.get("会社"))));

        kanjiMap.put("先", template.save(
                new Kanji("先",
                        List.of(new TranslateEntity(languageMap.get("ru"), "впереди; перед")),
                        List.of("セン"), List.of(wordsMap.get("先")), wordsMap.get("先生"))));

        kanjiMap.put("生", template.save(
                new Kanji("生",
                        List.of(new TranslateEntity(languageMap.get("ru"), "жизнь")),
                        List.of("セイ", "ショウ"),
                        List.of(wordsMap.get("生きる"), wordsMap.get("生かす"), wordsMap.get("生ける"), wordsMap.get("生まれる"),
                                wordsMap.get("生む"), wordsMap.get("生える"), wordsMap.get("生やす"), wordsMap.get("生")),
                        wordsMap.get("先生"))));

        kanjiMap.put("行", template.save(
                new Kanji("行",
                        List.of(new TranslateEntity(languageMap.get("ru"), "идти")),
                        List.of("コウ", "ギョウ", "アン"),  List.of(wordsMap.get("行く"), wordsMap.get("行う")), wordsMap.get("銀行"))));

        kanjiMap.put("来", template.save(
                new Kanji("来",
                        List.of(new TranslateEntity(languageMap.get("ru"), "приходить")),
                        List.of("ライ"),  List.of(wordsMap.get("来る")), wordsMap.get("来年"))));

        kanjiMap.put("車", template.save(
                new Kanji("車",
                        List.of(new TranslateEntity(languageMap.get("ru"), "машина; автомобиль")),
                        List.of("シャ"),  List.of(wordsMap.get("車")), wordsMap.get("電車"))));

        kanjiMap.put("月", template.save(
                new Kanji("月",
                        List.of(new TranslateEntity(languageMap.get("ru"), "месяц (календарный); месяц; луна")),
                        List.of("ゲツ", "ガツ"), List.of(wordsMap.get("月")), wordsMap.get("月曜日"))));

        kanjiMap.put("木", template.save(
                new Kanji("木",
                        List.of(new TranslateEntity(languageMap.get("ru"), "дерево")),
                        List.of("ボク", "モク"), List.of("こ"), List.of(wordsMap.get("木")), wordsMap.get("木曜日"))));

        kanjiMap.put("山", template.save(
                new Kanji("山",
                        List.of(new TranslateEntity(languageMap.get("ru"), "гора")),
                        List.of("サン"),  List.of(wordsMap.get("山")), wordsMap.get("火山"))));

        kanjiMap.put("川", template.save(
                new Kanji("川",
                        List.of(new TranslateEntity(languageMap.get("ru"), "река")),
                        List.of("セン"), List.of(wordsMap.get("川")), wordsMap.get("河川"))));

        kanjiMap.put("田", template.save(
                new Kanji("田",
                        List.of(new TranslateEntity(languageMap.get("ru"), "рисовое поле")),
                        List.of("デン"), List.of(wordsMap.get("田")), wordsMap.get("水田"))));

        kanjiMap.put("口", template.save(
                new Kanji("口",
                        List.of(new TranslateEntity(languageMap.get("ru"), "рот")),
                        List.of("コウ", "ク"), List.of(wordsMap.get("口")), wordsMap.get("人口"))));

        kanjiMap.put("門", template.save(
                new Kanji("門",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ворота")),
                        List.of("モン"),List.of(wordsMap.get("門")), wordsMap.get("専門"))));

        kanjiMap.put("火", template.save(
                new Kanji("火",
                        List.of(new TranslateEntity(languageMap.get("ru"), "огонь")),
                        List.of("カ"), List.of("ほ"), List.of(wordsMap.get("火")), wordsMap.get("火曜日"))));

        kanjiMap.put("水", template.save(
                new Kanji("水",
                        List.of(new TranslateEntity(languageMap.get("ru"), "вода")),
                        List.of("スイ"), List.of(wordsMap.get("水")), wordsMap.get("水曜日"))));

        kanjiMap.put("金", template.save(
                new Kanji("金",
                        List.of(new TranslateEntity(languageMap.get("ru"), "золото; деньги; металл")),
                        List.of("キン", "コン"), List.of(wordsMap.get("金")), wordsMap.get("金曜日"))));

        kanjiMap.put("土", template.save(
                new Kanji("土",
                        List.of(new TranslateEntity(languageMap.get("ru"), "земля")),
                        List.of("ド", "ト"), List.of(wordsMap.get("土")), wordsMap.get("土曜日"))));

        kanjiMap.put("子", template.save(
                new Kanji("子",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ребенок")),
                        List.of("シ", "ス"), List.of(wordsMap.get("子")), wordsMap.get("女子"))));

        kanjiMap.put("女", template.save(
                new Kanji("女",
                        List.of(new TranslateEntity(languageMap.get("ru"), "женщина")),
                        List.of("ジョ", "ニョ", "ニョウ"), List.of(wordsMap.get("女")), wordsMap.get("女子"))));

        kanjiMap.put("私", template.save(
                new Kanji("私",
                        List.of(new TranslateEntity(languageMap.get("ru"), "я; свой; личный; приватный")),
                        List.of("シ"), List.of(wordsMap.get("私")), wordsMap.get("私立"))));


/*
        kanjiList.put("", template.save(
                new Kanji("",
                        List.of(new TranslateEntity(languageMap.get("ru"), "")),
                        List.of(""), List.of(wordsMap.get("")), wordsMap.get(""))));
*/



    }

}
