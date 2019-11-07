package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.zdoher.japs.domain.user.User;

import java.util.List;

@ChangeLog(order = "001")
public class Init_001_User {

    @ChangeSet(order = "001", id = "initialUser", author = "zdoh", runAlways = true)
    public void initUser(MongoTemplate template) {
        template.save(new User("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), List.of("ROLE_USER", "ROLE_ADMIN")));
        template.save(new User("user", BCrypt.hashpw("user", BCrypt.gensalt()), List.of("ROLE_USER")));
    }
}
