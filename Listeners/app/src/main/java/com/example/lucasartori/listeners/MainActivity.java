package com.example.lucasartori.listeners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText toToastText;
    private Button clearButton;
    private Button toastButton;
    private ButtonOnClickListener buttonListen;
    private ButtonHintOnClickListener buttonHintListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toToastText = (EditText) findViewById(R.id.etToToast);
        toToastText.setOnClickListener(new TextOnClickListener());
        clearButton = (Button) findViewById(R.id.btnClr);
        toastButton = (Button) findViewById(R.id.btnToast);
    }

    private class TextOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            buttonListen = new ButtonOnClickListener();
            buttonHintListener = new ButtonHintOnClickListener();
            // Set Listeners
            clearButton.setOnClickListener(buttonListen);
            toastButton.setOnClickListener(buttonListen);

            // Set Hints
            clearButton.setOnLongClickListener(buttonHintListener);
            toastButton.setOnLongClickListener(buttonHintListener);

            
        }
    }
}
