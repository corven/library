package com.example.cos.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cos.library.R;
import com.example.cos.library.adapter.BooksAdapter;
import com.hannesdorfmann.swipeback.Position;
import com.hannesdorfmann.swipeback.SwipeBack;
import com.hannesdorfmann.swipeback.transformer.SlideSwipeBackTransformer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BookActivity extends AppCompatActivity {

    @Bind(R.id.tvCurrDesc)
    TextView tvDesc;
    @Bind(R.id.tvCurrTitle)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBack.attach(this, Position.LEFT)
                .setDrawOverlay(true)
                .setSwipeBackTransformer(new SlideSwipeBackTransformer())
                .setContentView(R.layout.activity_book)
                .setSwipeBackView(R.layout.swipeback_default);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitle.setText(intent.getStringExtra(BooksAdapter.TITLE));
        tvDesc.setText(intent.getStringExtra(BooksAdapter.DESC));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
