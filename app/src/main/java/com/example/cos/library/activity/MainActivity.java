package com.example.cos.library.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.cos.library.R;
import com.example.cos.library.adapter.BooksAdapter;
import com.example.cos.library.model.Book;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

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

    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        books = Book.listAll(Book.class);

        rvBooks.setHasFixedSize(true);
        rvBooks.setAdapter(new BooksAdapter(this, books));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String a = "Этот роман безоговорочно признают лучшей книгой Стивена Кинга и миллионы фанатов писателя, и серьезные литературные критики. \n" +
////                        "…Убийство президента Кеннеди стало самым трагическим событием американской истории ХХ века.\n" +
////                        "Тайна его до сих пор не раскрыта.\n" +
////                        "Но что, если случится чудо? Если появится возможность отправиться в прошлое и предотвратить катастрофу?\n" +
////                        "Это предстоит выяснить обычному учителю из маленького городка Джейку Эппингу, получившему доступ к временному порталу.\n" +
////                        "Его цель - спасти Кеннеди.\n" +
////                        "Но какова будет цена спасения?";
////                Book book = new Book("Стивен Кинг. 11/22/63", 4 , R.drawable.book_11_22_63, a);
////                book.save();
////
////                a = "История маленького сонного городка на юге Америки, поведанная маленькой девочкой.\n" +
////                        "История ее брата Джима, друга Дилла и ее отца - честного, принципиального адвоката Аттикуса Финча, одного из последних и лучших представителей старой \"южной аристократии\".\n" +
////                        "История судебного процесса по делу чернокожего парня, обвиненного в насилии над белой девушкой.\n" +
////                        "Но прежде всего - история переломной эпохи, когда ксенофобия, расизм, нетерпимость и ханжество, присущие американскому югу, постепенно уходят в прошлое.\n" +
////                        "\"Ветер перемен\" только-только повеял над Америкой. Что он принесет?..";
////                book = new Book("Харпер Ли. Убить пересмешника", (float) 4.5, R.drawable.book_kill, a);
////                book.save();
//
////                List<Book> allBook = Book.listAll(Book.class);
////                Log.d("myLog", String.valueOf(allBook));
//
////                Book.deleteAll(Book.class);
//            }
//        });


    }

    @OnClick(R.id.tapBarMenu)
    public void onMenuButtonClick() {
        tapBarMenu.toggle();
    }

    @OnClick({ R.id.item1, R.id.item2})
    public void onMenuItemClick(View view) {
        tapBarMenu.close();
        switch (view.getId()) {
            case R.id.item1:
                Log.i("TAG", "Item 1 selected");
                break;
            case R.id.item2:
                Log.i("TAG", "Item 2 selected");
                break;
        }
    }


}
