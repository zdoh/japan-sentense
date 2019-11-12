package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

@ChangeLog(order = "000")
public class Init_000_DB {

    @ChangeSet(order = "000", id = "dropDB", author = "zdoh", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }
}
