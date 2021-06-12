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
        String reversedString = new StringBuilder(textForConvert).reverse().toString();
        convertText.setText(reversedString);
    }

    private void init()
    {
        convertText = findViewById(R.id.tvConvertText);
        inputText= findViewById(R.id.etInputText);
    }
}