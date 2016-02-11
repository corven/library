package com.example.cos.library.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cos.library.R;
import com.example.cos.library.adapter.BooksAdapter;
import com.example.cos.library.model.Book;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;
    @Bind(R.id.rvBooks)
    RecyclerView rvBooks;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private BooksAdapter adapter;
    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        books = Book.listAll(Book.class);

        rvBooks.setHasFixedSize(true);
        adapter = new BooksAdapter(this, books);
        rvBooks.setAdapter(adapter);
    }

    @OnClick(R.id.tapBarMenu)
    public void onMenuButtonClick() {
        tapBarMenu.toggle();
    }

    @OnClick({ R.id.itemTitle, R.id.itemStar})
    public void onMenuItemClick(View view) {
        tapBarMenu.close();
        switch (view.getId()) {
            case R.id.itemTitle:
                Collections.sort(books, Book.compSortTitle);
                adapter.notifyDataSetChanged();
                break;
            case R.id.itemStar:
                Collections.sort(books, Book.compSortRating);
                adapter.notifyDataSetChanged();
                break;
        }
    }

    // Удаление тестовых данных
    private void delData() {
        Book.deleteAll(Book.class);
        books.clear();
    }

    // Добавление тестовых данных
    private void setData() {
        String desc = getString(getResources().getIdentifier("desc_book_kill", "string", getPackageName()));
        Book book = new Book("Убить пересмешника", (float) 4, R.drawable.book_kill, desc, "Харпер Ли. Убить пересмешника");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_women", "string", getPackageName()));
        book = new Book("Женщины", (float) 4.4, R.drawable.book_women, desc, "Чарльз Буковски. Женщины");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_11_22_63", "string", getPackageName()));
        book = new Book("11/22/63", (float) 4.3, R.drawable.book_11_22_63, desc, "Стивен Кинг. 11/22/63");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_code_complete", "string", getPackageName()));
        book = new Book("Совершенный код", (float) 4.8, R.drawable.book_code_complete, desc, "Стив Макконелл. Совершенный код");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_design_patterns", "string", getPackageName()));
        book = new Book("Паттерны проектирования", (float) 4.5, R.drawable.book_design_patterns, desc, "Гамма, Хелм, Джонсон: Приемы объектно - ориентированного проектирования. Паттерны проектирования");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_ham_on_rye", "string", getPackageName()));
        book = new Book("Хлеб с ветчиной", (float) 3, R.drawable.book_ham_on_rye, desc, "Чарльз Буковски. Хлеб с ветчиной");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_martin_eden", "string", getPackageName()));
        book = new Book("Мартин Иден", (float) 5, R.drawable.book_martin_eden, desc, "Джек Лондон. Мартин Иден");
        book.save();
        books.add(book);

        desc = getString(getResources().getIdentifier("desc_book_thinking_java", "string", getPackageName()));
        book = new Book("Философия Java", (float) 4.5, R.drawable.book_thinking_java, desc, "Брюс Эккель. Философия Java");
        book.save();
        books.add(book);


    }

}
