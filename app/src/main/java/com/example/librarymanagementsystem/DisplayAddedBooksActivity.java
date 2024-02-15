package com.example.librarymanagementsystem;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DisplayAddedBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_added_books);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve added books from BookManager
        List<Book> addedBooks = BookManager.getInstance().getBooks();

        // Initialize and set up the adapter
        bookAdapter = new BookAdapter(addedBooks, new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click (open UpdateBookActivity)
                openUpdateBookActivity(position);
            }
        });
        UpdateBook updateBookActivity = new UpdateBook();
        updateBookActivity.setBookAdapter(bookAdapter);
        recyclerView.setAdapter(bookAdapter);
    }

    private void openUpdateBookActivity(int position) {
        Intent intent = new Intent(this, UpdateBook.class);
        intent.putExtra("bookPosition", position);
        startActivity(intent);
    }
}
