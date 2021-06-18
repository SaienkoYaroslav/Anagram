package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView convertText;
    private EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickConvert(View view)
    {
        String textForConvert = inputText.getText().toString();
       // String reversedString = new StringBuilder(textForConvert).reverse().toString();
        //convertText.setText(reversedString);
        char[] charArray = textForConvert.toCharArray();
        reverse(charArray);
        String revStr = new String(charArray);
        convertText.setText(revStr);

    }

    private void init()
    {
        convertText = findViewById(R.id.tvConvertText);
        inputText= findViewById(R.id.etInputText);
    }

    private void reverse(char str[])
    {
        int r = str.length - 1, l = 0;
        while (l < r)
        {
            if (!Character.isAlphabetic(str[l]))
                l++;
            else if(!Character.isAlphabetic(str[r]))
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