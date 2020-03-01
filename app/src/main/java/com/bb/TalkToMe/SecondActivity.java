package com.bb.TalkToMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.bb.twoactivities.extra.REPLY";

    private EditText mReply;
    private ImageView iReplyImageView;
    private ImageView iMainImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);
        iMainImageView = findViewById(R.id.imageView_main);
        Glide.with(this)
                .load(R.drawable.bugs_bunny)
                .into(iMainImageView);

        iReplyImageView = findViewById(R.id.imageView_reply);
        Glide.with(this)
                .load(R.drawable.audirs7)
                .into(iReplyImageView);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {

        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);

        finish();

    }
}
