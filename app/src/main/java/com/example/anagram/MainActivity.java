package com.example.anagram;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvConvertText;
    private EditText edInputText;
    private EditText edIgnoreText;
    private TextView tvConvertTextWatcher;
    private Reverser reverseString = new Reverser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        edInputText.addTextChangedListener(convertWatcher);
        edIgnoreText.addTextChangedListener(convertWatcher);
    }

    public void onClickConvert(View view) {
        convert(tvConvertText);
    }

    private final TextWatcher convertWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            convert(tvConvertTextWatcher);
        }
    };

    private void init() {
        tvConvertText = findViewById(R.id.tvConvertText);
        edInputText = findViewById(R.id.etInputText);
        edIgnoreText = findViewById(R.id.etIgnoreText);
        tvConvertTextWatcher = findViewById(R.id.tvForTextWatcher);
    }

    private void convert(TextView tv) {
        String textForConvert = edInputText.getText().toString();
        String userIgnore = edIgnoreText.getText().toString();
        tv.setText(reverseString.reverse(textForConvert, userIgnore));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        edInputText.removeTextChangedListener(convertWatcher);
        edIgnoreText.removeTextChangedListener(convertWatcher);
    }
}