package com.wgu.c196wgu.model;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.wgu.c196wgu.MainActivity;
import com.wgu.c196wgu.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTerm extends AppCompatActivity {
    private EditText enterTermName;
    private EditText enterTermStartDate;
    private EditText enterTermEndDate;
    private Button saveTerm;

    private TermViewModel termViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        //create a date string
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_term);
        enterTermName = findViewById(R.id.enterTermName);
        enterTermStartDate = findViewById(R.id.enterTermStartDate);
        enterTermEndDate = findViewById(R.id.enterTermEndDate);
        saveTerm = findViewById(R.id.saveTermButton);

        termViewModel = new ViewModelProvider.AndroidViewModelFactory(NewTerm.this
                .getApplication())
                .create(TermViewModel.class);

        saveTerm.setOnClickListener(v -> {
            try {
                String dtStart = enterTermStartDate.toString();
                String dtEnd = enterTermEndDate.toString();
                Date startDate = sdf.parse(dtStart);
                Date endDate = sdf.parse(dtEnd);

                Term term = new Term(
                        enterTermName.getText().toString(),
                        startDate,
                        endDate);

                TermViewModel.insert(term);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

}
