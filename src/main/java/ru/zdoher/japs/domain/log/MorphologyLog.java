package ru.zdoher.japs.domain.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class MorphologyLog {

    @Id
    private String id;

    private LocalDateTime dateTime;

    private String message;

    public MorphologyLog(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }
}
