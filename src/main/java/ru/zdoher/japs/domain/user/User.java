package ru.zdoher.japs.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Indexed(unique = true)
    private String username;

    private String password;

    private List<String> roles;

    public MyUserDetails toUserDetails() {
        return new MyUserDetails(username, password, roles);
    }
}
