package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_convertText;
    private EditText ed_inputText;
    private EditText ed_ignoreText;
    private TextView tv_convertTextWatcher;

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

    String reverse(String userInput, String userIgnore) {
        char str[] = userInput.toCharArray();
        int r = str.length - 1, l = 0;
        while (l < r) {
            if (userIgnore.indexOf(str[l]) != -1)
                l++;
            else if (userIgnore.indexOf(str[r]) != -1)
                r--;
            else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
        String revStr = new String(str);
        return revStr;
    }

    private void convert(TextView tv) {
        String textForConvert = ed_inputText.getText().toString();
        String userIgnore = ed_ignoreText.getText().toString();
        tv.setText(reverse(textForConvert, userIgnore));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ed_inputText.removeTextChangedListener(convertWatcher);
        ed_ignoreText.removeTextChangedListener(convertWatcher);
    }
}