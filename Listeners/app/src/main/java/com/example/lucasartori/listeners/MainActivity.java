package com.example.lucasartori.listeners;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnClr) {
                toToastText.setText("");
            }
            else if (v.getId() == R.id.btnToast) {
                Toast.makeText(v.getContext(), toToastText.getText().toString(), Toast.LENGTH_SHORT);
            }
        }
    }

    private class ButtonHintOnClickListener implements  View.OnLongClickListener {
        // return true so that it will consume the event and the onClick will not recieve a callback afterwards
        @Override
        public boolean onLongClick(View v) {
            String hint = null;
            Context context = v.getContext();
            if (v.getId() == R.id.btnToast) {
                hint = context.getString(R.string.btnToastHint);
            }
            else if (v.getId() == R.id.btnClr) {
                hint = context.getString(R.string.btnClearHint);
            }
            Toast.makeText(context, hint, Toast.LENGTH_SHORT);
            return true;
        }
    }
}
