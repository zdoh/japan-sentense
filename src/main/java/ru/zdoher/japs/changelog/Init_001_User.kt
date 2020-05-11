package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.security.crypto.bcrypt.BCrypt
import ru.zdoher.japs.domain.user.User

@ChangeLog(order = "001")
class Init_001_User {
    @ChangeSet(order = "001", id = "initialUser", author = "zdoh", runAlways = true)
    fun initUser(template: MongoTemplate) {
        template.save(
            User(
                username ="admin",
                password = BCrypt.hashpw("admin", BCrypt.gensalt()),
                roles = mutableListOf("ROLE_USER", "ROLE_ADMIN")
            )
        )
        template.save(
            User(
                username = "user",
                password = BCrypt.hashpw("user", BCrypt.gensalt()),
                roles = mutableListOf("ROLE_USER")
            )
        )
    }
}