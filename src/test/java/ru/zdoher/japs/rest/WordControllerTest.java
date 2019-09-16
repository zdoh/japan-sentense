package ru.zdoher.japs.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.WordRepositories;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Class WordController")
@WebFluxTest(WordController.class)
class WordControllerTest {

    @Autowired
    private WordController wordController;

    @MockBean
    private WordRepositories wordRepositories;

    private ObjectMapper mapper = new ObjectMapper();

    @DisplayName(" get existing Word by id - success")
    @Test
    void getExistingWordById() throws JsonProcessingException {

        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        given(wordRepositories.findById(word.getId())).willReturn(Mono.just(word));

        WebTestClient
                .bindToController(wordController)
                .build().get().uri("/api/word/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(mapper.writeValueAsString(word));

    }

    @DisplayName(" get not existing Word by id - success")
    @Test
    void getNotExistingWordById() throws JsonProcessingException {

        WebTestClient
                .bindToController(wordController)
                .build().get().uri("/api/word/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }


    @DisplayName(" get all Word - success")
    @Test
    void getAll() throws JsonProcessingException {

        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word1 = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        Word word2 = new Word("2", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        Flux<Word> words = Flux.just(word1, word2);

        given(wordRepositories.findAll()).willReturn(words);

        WebTestClient
                .bindToController(wordController)
                .build().get().uri("/api/word/")
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(mapper.writeValueAsString(List.of(word1, word2)));
    }

    @DisplayName(" delete word by id - success")
    @Test
    void deleteWordById() throws Exception {

/*        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);*/

        WebTestClient
                .bindToController(wordController)
                .build().delete().uri("/api/word/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

/*    @DisplayName(" insert word by id - success")
    @Test
    void insertWordById() throws Exception {

        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        when(wordRepositories.save(any(Word.class))).thenReturn(word);

        mockMvc.perform(put("http://localhost:8080/api/word/")
                .content(mapper.writeValueAsString(WordDto.toDto(word)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(wordRepositories, times(1)).save(any(Word.class));
    }*/
}