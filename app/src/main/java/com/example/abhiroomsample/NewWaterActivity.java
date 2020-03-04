package com.example.abhiroomsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewWaterActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.waterlistsql.REPLY";

    private EditText mEditWaterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_water);
        mEditWaterView = findViewById(R.id.edit_water);
        final Button save = findViewById(R.id.button_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWaterView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String water = mEditWaterView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, water);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }


}
