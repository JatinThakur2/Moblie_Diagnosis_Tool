package com.example.mobliediagnosis.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class DBStatic {

    private static TestsDAO testsDAO;
    private static TestsRoomDatabase testsDB;
    private static LiveData<List<Tests>> mAllTests;

    public static void initialize(Context context) {
        testsDB = TestsRoomDatabase.getDatabase(context);
        testsDAO = testsDB.testsDAO();
    }

    public static void insert(Tests tests, Context context) {
        initialize(context);
        new InsertAsyncTask(testsDAO).execute(tests);
    }

    public static void insert(String type, String extra, Context context) {
        initialize(context);
        String id = UUID.randomUUID().toString();;
        String time = Calendar.getInstance().getTime().toString();
        Tests tests = new Tests(id, time, type, extra);
        new InsertAsyncTask(testsDAO).execute(tests);
    }

    public static class InsertAsyncTask extends AsyncTask<Tests, Void, Void> {

        TestsDAO mTestsDao;

        public InsertAsyncTask(TestsDAO mTestsDao) {
            this.mTestsDao = mTestsDao;
        }

        @Override
        protected Void doInBackground(Tests... tests) {
            mTestsDao.insert(tests[0]);
            return null;
        }
    }

    public static void truncateTestsTable(Context context) {
        initialize(context);
        Thread thread = new Thread() {
            @Override
            public void run() {
                testsDAO.deleteAll();
            }
        };
        thread.start();
    }



}
