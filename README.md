Разработка приложения тренажера для формирования списка предложений, слов и иероглифов для перевода с русского языка 
    на японский. 

Готовность приложения ~15%;

Что сделано:
- каркас приложения, инициализация данных в БД через mongock 
- простой веб-интерфейс на reactJs, простой вывод рандомных данных (приложение, слово, иероглиф) 
- авторизация, с разделением на обычный пользователь и админ (данные авторизации: user/user admin/admin). для вывода
    каких-либо данных необходима авторизация
- добавлены данные (две главы первой минны, две главы basic bakji books, две главы kanji workbook)

Что надо сделать:
- регистрацию по e-mail
- в админ панели интерфейс для добавления данных
- в пользовательском интерфейсе возможность выбора главы и учебника, по которому происходит обучение
- анализ предложения на составные части, слово, иероглифы, грамматика и тд
- учет и анализ правильности данных ответов для подбора обучающей информации


что используется:
Spring Boot, Spring Security, Spring Webflux, RestAPI, MongoDB

