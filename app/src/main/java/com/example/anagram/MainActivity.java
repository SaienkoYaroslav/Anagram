package com.example.anagram;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv_convertText;
    private EditText ed_inputText;
    private EditText ed_ignoreText;
    private TextView tv_convertTextWatcher;
    Reverser rev = new Reverser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ed_inputText.addTextChangedListener(convertWatcher);
        ed_ignoreText.addTextChangedListener(convertWatcher);
    }

    public void onClickConvert(View view) {
        convert(tv_convertText);
    }

    private final TextWatcher convertWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            convert(tv_convertTextWatcher);
        }
    };

    private void init() {
        tv_convertText = findViewById(R.id.tvConvertText);
        ed_inputText = findViewById(R.id.etInputText);
        ed_ignoreText = findViewById(R.id.etIgnore);
        tv_convertTextWatcher = findViewById(R.id.tv_for_TextWatcher);
    }

    private void convert(TextView tv) {
        String textForConvert = ed_inputText.getText().toString();
        String userIgnore = ed_ignoreText.getText().toString();
        tv.setText(rev.reverse(textForConvert, userIgnore));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ed_inputText.removeTextChangedListener(convertWatcher);
        ed_ignoreText.removeTextChangedListener(convertWatcher);
    }
}