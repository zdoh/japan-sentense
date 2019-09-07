package ru.zdoher.japs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.repositories.WordRepositories;
import ru.zdoher.japs.rest.dto.WordDto;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Class WordController")
@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordRepositories wordRepositories;

    private ObjectMapper mapper = new ObjectMapper();

    @DisplayName(" get Word by id - success")
    @Test
    void getById() throws Exception {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        given(wordRepositories.findById(word.getId())).willReturn(java.util.Optional.of(word));

        mockMvc.perform(get("http://localhost:8080/api/word/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(word)));

    }

    @DisplayName(" get all Word - success")
    @Test
    void getAll() throws Exception {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word1 = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        Word word2 = new Word("2", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        List<Word> words = List.of(word1, word2);

        given(wordRepositories.findAll()).willReturn(words);

        mockMvc.perform(get("http://localhost:8080/api/words")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(words)));

    }

    @DisplayName(" delete word by id - success")
    @Test
    void deleteWordById() throws Exception {
        doNothing().when(wordRepositories).deleteById(any());

        mockMvc.perform(delete("http://localhost:8080/api/word/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(wordRepositories, times(1)).deleteById(any(String.class));
    }

    @DisplayName(" insert word by id - success")
    @Test
    void insertWordById() throws Exception {

        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Word word = new Word("1", NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
                List.of(translateEntity), List.of(partOfSpeech), false);

        when(wordRepositories.save(any(Word.class))).thenReturn(word);

        mockMvc.perform(post("http://localhost:8080/api/word")
                .content(mapper.writeValueAsString(WordDto.toDto(word)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(wordRepositories, times(1)).save(any(Word.class));
    }
}