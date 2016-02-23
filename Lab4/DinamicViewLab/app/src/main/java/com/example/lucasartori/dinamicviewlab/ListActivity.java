package com.example.lucasartori.dinamicviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private static final int MAX_COUNT = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.lvList);
        list.setAdapter(new CustomAdapter(getLayoutInflater(), MAX_COUNT));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callOtherActivity(position);
            }
        });
    }

    private void callOtherActivity(int position) {
        Intent secondIntent = new Intent(this, GridActivity.class);
        secondIntent.putExtra(Intent.EXTRA_UID, position);
        startActivity(secondIntent);
    }
}