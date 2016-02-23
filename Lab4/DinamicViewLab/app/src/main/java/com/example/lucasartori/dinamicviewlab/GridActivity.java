package com.example.lucasartori.dinamicviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView grid = (GridView) findViewById(R.id.gvMain);
        int bundleInt = getIntent().getExtras().getInt(Intent.EXTRA_UID);
        // Set cant columns
        switch (bundleInt) {
            case 0:
                grid.setNumColumns(1);
                break;
            case 1:
                grid.setNumColumns(2);
                break;
            default:
                grid.setNumColumns(3);
                break;
        }
        grid.setAdapter(new CustomAdapter(getLayoutInflater(), bundleInt+1));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "This is: " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
