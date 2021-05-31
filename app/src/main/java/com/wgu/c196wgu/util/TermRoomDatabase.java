package com.wgu.c196wgu.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.wgu.c196wgu.data.TermDao;
import com.wgu.c196wgu.model.Term;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Term.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class TermRoomDatabase extends RoomDatabase {

    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile TermRoomDatabase INSTANCE;
    private static final RoomDatabase.Callback  sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseWriteExecutor.execute(() -> {
                        TermDao termDao = INSTANCE.termDao();
                        termDao.deleteAll();

//                        Term term = new Term("Sprint 2021", null, null);
//                        termDao.insert(term);
//
//                        term = new Term("Fall 2021", null, null);
//                        termDao.insert(term);
                    });
                }
            };

    public static TermRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TermRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    TermRoomDatabase.class, "term_database")
                    .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract TermDao termDao();
}
