package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView convertText;
    private EditText inputText;
    private EditText ignoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickConvert(View view)
    {
        String textForConvert = inputText.getText().toString();
        char[] charArray = textForConvert.toCharArray();
        reverse(charArray);
        String revStr = new String(charArray);
        convertText.setText(revStr);

    }

    private void init()
    {
        convertText = findViewById(R.id.tvConvertText);
        inputText= findViewById(R.id.etInputText);
        ignoreText = findViewById(R.id.etIgnore);
    }

    private void reverse(char str[])
    {
        String userIgnore = ignoreText.getText().toString();
        int r = str.length - 1, l = 0;
        while (l < r)
        {
            if (userIgnore.indexOf(str[l]) != -1)
                l++;
            else if(userIgnore.indexOf(str[r]) != -1)
                r--;
            else
            {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
    }

}