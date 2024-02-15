package com.example.librarymanagementsystem;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class IssueInfoDialog extends Dialog {

    private String issueInfo;

    public IssueInfoDialog(@NonNull Context context, String issueInfo) {
        super(context);
        this.issueInfo = issueInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_info_dialog);

        TextView dialogTextDetails = findViewById(R.id.dialogTextDetails);
        Button dialogButtonOK = findViewById(R.id.dialogButtonOK);

        dialogTextDetails.setText(issueInfo);

        dialogButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
