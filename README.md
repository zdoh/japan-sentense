Разработка приложения помощника для формирования списка предложений для перевода с русского языка на японский. 

Общие:
- В зависимости от учебника, по которому производится обучение и главы в книге, выдаются определенные предложения
подходящие по уровню (грамматика, слова и кандзи). 
- Глава учебника и сам учебник выбирается в личной панели. 
- Учебники выбирается по 5 направлениям (грамматика, слова, кандзи, чтение, аудирование).
- Основной учебник это грамматика, остальные нужны для того чтобы определить знаешь ли ты слова и иероглифы.
- Предложения с японского переводятся пользователями (первый перевод делается тем кто добавляет, либо google translate).
- При добавление предложения автоматически производит морфологический разбор предложения, перевод кандзи на каны и 
        вычленение используемой грамматики (www.atilika.org). Полученые слова автоматически привязываются к словам в 
        таблице со словами. {очень сильно думать алгоритм, пока мысль делать с конца предложения в начало}
- Для того чтобы больше предложений довалось из более поздней грамматике у пользователей будет система левелов 
        {тут надо подумать}
- Перевод делается на доверие, то есть дается предложение на русском и три кнопки, "не перевел", "перевел" и "легкотня"
        в зависимости от ответа будет добавляться или уменьшаться кол-во

Перевод:
- Если ты не знаешь какое-то слово, то предложение в котором используется это слово имеет меньший приоритет для перевода.
- Если ты переводить предложения корректно, то слова использующиеся в предложение имеют меньший приоритет на попадает в повторение. 
- у каждого пользователя будет рейтинг по словам, иероглифом, грамматики и предложениям, в зависимости от правильности или 
        неправильности ответа рейтинг будет менять и шанс повторной выдачи слова, иероглифа и грамматики будет меняться
        (чаще будет выдаваться то, что хуже знаешь)
        
* При переводе на японский, после появление ответа, пользователь может добавить свой вариант перевода с японского.

** дальше надо думать

Сущности (плюс сделано, минус в процессе):
+ язык {id, полное название языка, краткое название}
+ слово {id, слово по словарю (если слово в основном используется без иероглифов, то будет писаться без иероглифов),
        произношение (пишется хираганой), список переводов на разных языков, список частей речи (для морфологичесокго разбора),
        показывать ли слово (нужен для иероглифов в случае если кун не слова)}
+ кадзи {id, кандзи, список значений на разных языках, список онов, список кунов, 
        якорь для запоминания онов (легкое слово в котором используется данный иерооглив)}
+ предложения {id, предложения на японском, список переводов (возможных переводов, будет сделан рейтинг по полезности перевода), 
        источник предложения, уровень вежливости, 
        маркер разговорной речи, список используемой грамматики (будет определяться самостоятельно), список используемых слов} 
+ грамматика {id, название, формирование грамматики, список комментариев по грамматики на рахных языка}
+ список учебников {id, название, английское название, серия учебника, маркер отображения для пользователей, список направления учебника,
        список уроков Хнаправление {название, список слов, список грамматики, список иероглифов}}


- пользователи (id, логин, email, хеш пароля, роль)