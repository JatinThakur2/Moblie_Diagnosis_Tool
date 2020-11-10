package com.example.mobliediagnosis.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TestsDAO {

    @Insert
    void insert(Tests tests);

    @Query("SELECT * FROM tests")
    LiveData<List<Tests>> getAllTests();

    @Query("DELETE FROM tests")
    void deleteAll();

}
