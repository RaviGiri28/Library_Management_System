package com.example.librarymanagementsystem;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ReturnInfoDialog extends Dialog {

    private String returnInfo;

    public ReturnInfoDialog(@NonNull Context context, String returnInfo) {
        super(context);
        this.returnInfo = returnInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_info_dialog);

        TextView dialogTextDetailsReturn = findViewById(R.id.dialogTextDetailsReturn);
        TextView returnBookDetails = findViewById(R.id.returnBookDetails);
        Button dialogButtonOKReturn = findViewById(R.id.dialogButtonOKReturn);

        dialogTextDetailsReturn.setText("Return Book Information");
        returnBookDetails.setText(returnInfo);

        dialogButtonOKReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
