package com.wgu.c196wgu.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.wgu.c196wgu.model.Term;
import com.wgu.c196wgu.util.TermRoomDatabase;

import java.util.List;

public class TermRepository {
    private TermDao termDao;
    private LiveData<List<Term>> allTerms;

    public TermRepository(Application application) {
        TermRoomDatabase db = TermRoomDatabase.getDatabase(application);
        termDao = db.termDao();

        allTerms = termDao.getAllTerms();
    }
    public LiveData<List<Term>> getAllData() { return allTerms; }
    public void insert(Term term) {
        TermRoomDatabase.databaseWriteExecutor.execute(() -> termDao.insert(term));
    }
    public LiveData<Term> get(int term_id) { return termDao.get(term_id); }
    public void update(Term term) {
        TermRoomDatabase.databaseWriteExecutor.execute(() -> termDao.update(term));
    }
    public void delete(Term term) {
        TermRoomDatabase.databaseWriteExecutor.execute(() -> termDao.delete(term));
    }
}
