package com.example.librarymanagementsystem;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.example.librarymanagementsystem.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

    public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

        private List<Book> bookList;
        private OnItemClickListener listener;

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public BookAdapter(List<Book> bookList, OnItemClickListener listener) {
            this.bookList = bookList;
            this.listener = listener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Book book = bookList.get(position);
            holder.titleTextView.setText("Title: " + book.getTitle());
            holder.titleTextView.setTextColor(holder.itemView.getContext().getResources().getColor(android.R.color.black));
            holder.bind(book, listener);
        }

        @Override
        public int getItemCount() {
            return bookList.size();
        }

        public void updateDataset(List<Book> newBooks) {
            bookList = newBooks;
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView titleTextView;
            private TextView authorTextView;
            private TextView isbnTextView;
            private ImageView optionsMenu;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                authorTextView = itemView.findViewById(R.id.authorTextView);
                isbnTextView = itemView.findViewById(R.id.isbnTextView);
                optionsMenu = itemView.findViewById(R.id.optionsMenu);

                optionsMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupMenu(v, getAdapterPosition());
                    }
                });
            }

            public void bind(final Book book, final OnItemClickListener listener) {
                titleTextView.setText("Title: " + book.getTitle());
                authorTextView.setText("Author: " + book.getAuthor());
                isbnTextView.setText("ISBN: " + book.getIsbn());

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onItemClick(position);
                            }
                        }
                    }
                });
            }

            private void showPopupMenu(View view, final int position) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_book, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.menu_delete) {
                            // Handle delete option
                            deleteBook(position);
                            return true;
                        } else {
                            return false;
                        }
                    }
                });

                popupMenu.show();
            }

            private void deleteBook(int position) {
                if (position >= 0 && position < bookList.size()) {
                    // Remove the book from the list
                    bookList.remove(position);
                    // Notify the adapter about the item removal
                    notifyItemRemoved(position);
                }
            }
        }
    }