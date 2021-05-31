package com.wgu.c196wgu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wgu.c196wgu.model.Term;
import com.wgu.c196wgu.model.TermViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TermViewModel termViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        termViewModel.getAllTerms().observe(this, terms -> {
            StringBuilder builder = new StringBuilder();
            for (Term term : terms) {
                builder.append(" - ").append(term.getTerm_name()).append(" ").append(term.getTerm_start());

                Log.d("TAG", "onCreate:" + term.getTerm_name());

            }

          textView.setText(builder.toString());
        });
    }
}