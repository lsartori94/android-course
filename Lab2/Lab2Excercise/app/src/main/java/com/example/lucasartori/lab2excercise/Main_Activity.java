package com.example.lucasartori.lab2excercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Activity extends AppCompatActivity {

    private Button btnRight, btnLeft;
    private ButtonOnClickListener btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_part_1);
        setContentView(R.layout.layout_part_2);
//        setContentView(R.layout.layout_part_3);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnClick = new ButtonOnClickListener();
        btnRight.setOnClickListener(btnClick);
        btnLeft.setOnClickListener(btnClick);
    }

    private class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnLeft) {
                btnRight.setText(btnLeft.getText().toString());
                btnLeft.setText("");
            }
            else if (v.getId() == R.id.btnRight) {
                btnLeft.setText(btnRight.getText().toString());
                btnRight.setText("");
            }
        }
    }
}
