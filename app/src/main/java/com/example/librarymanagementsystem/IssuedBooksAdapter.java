package com.example.librarymanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IssuedBooksAdapter extends RecyclerView.Adapter<IssuedBooksAdapter.ViewHolder> {

    private List<IssuedBook> issuedBooks;

    public IssuedBooksAdapter(List<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_issued_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IssuedBook issuedBook = issuedBooks.get(position);
        holder.studentIdTextView.setText("Student ID: " + issuedBook.getStudentId());
        holder.bookIdTextView.setText("Book ID: " + issuedBook.getBookId());
        holder.fromDateTextView.setText("From Date: " + issuedBook.getFromDate());
        holder.toDateTextView.setText("To Date: " + issuedBook.getToDate());
    }

    @Override
    public int getItemCount() {
        return issuedBooks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentIdTextView;
        private TextView bookIdTextView;
        private TextView fromDateTextView;
        private TextView toDateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentIdTextView = itemView.findViewById(R.id.editTextStudentId);
            bookIdTextView = itemView.findViewById(R.id.editTextBookId);
            fromDateTextView = itemView.findViewById(R.id.datePickerFrom);
            toDateTextView = itemView.findViewById(R.id.datePickerTo);
        }
    }
}
