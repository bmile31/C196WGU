package com.wgu.c196wgu.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "term_table")
public class Term {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "term_id")
    private int term_id;
    @ColumnInfo(name = "term_name")
    private String term_name;
    @ColumnInfo(name = "term_start")
    private Date term_start;
    @ColumnInfo(name = "term_end")
    private Date term_end;

    public Term(@NonNull String term_name, Date term_start, Date term_end) {
        this.term_name = term_name;
        this.term_start = term_start;
        this.term_end = term_end;
    }

    public void setTerm_id(int term_id) { this.term_id = term_id; }

    public void setTerm_name(String term_name) { this.term_name = term_name; }

    public void setTerm_start(Date term_start) { this.term_start = term_start; }

    public void setTerm_end(Date term_end) { this.term_end = term_end; }

    public int getTerm_id() {return  term_id; }

    public String getTerm_name() { return term_name; }

    public Date getTerm_start() { return term_start; }

    public Date getTerm_end() { return term_end; }
}
