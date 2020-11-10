package com.example.mobliediagnosis.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Tests.class, version = 1)
public abstract class TestsRoomDatabase extends RoomDatabase {

    public abstract TestsDAO testsDAO();

    public static volatile TestsRoomDatabase testRoomInstance;

    public static TestsRoomDatabase getDatabase(final Context context) {
        if (testRoomInstance == null) {
            synchronized (TestsRoomDatabase.class) {
                if (testRoomInstance == null) {
                    testRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            TestsRoomDatabase.class, "tests_database").build();
                }
            }
        }
        return testRoomInstance;
    }

}
