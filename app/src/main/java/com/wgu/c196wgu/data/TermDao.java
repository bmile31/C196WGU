package com.wgu.c196wgu.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.wgu.c196wgu.model.Term;

import java.util.List;

@Dao
public interface TermDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Term term);

    @Query("DELETE FROM term_table")
    void deleteAll();

    @Query("SELECT * FROM term_table ORDER BY term_name ASC")
    LiveData<List<Term>> getAllTerms();

    @Query("SELECT * FROM term_table WHERE term_table.term_id == :id")
    LiveData<Term> get(int id);

    @Update
    void update(Term term);

    @Delete
    void delete(Term term);
}
