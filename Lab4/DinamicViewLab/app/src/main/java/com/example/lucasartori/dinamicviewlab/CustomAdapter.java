package com.example.lucasartori.dinamicviewlab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luca.sartori on 23/02/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private int count;
    LayoutInflater minInflater;


    CustomAdapter(LayoutInflater inflater, int cant) {
        minInflater = inflater;
        count = cant;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return "This is item: " + position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = minInflater.inflate(R.layout.item, parent, false);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.lvIcon);
        image.setImageResource((position % 2 == 0) ? android.R.drawable.star_on : android.R.drawable.sym_action_chat);
        TextView text = (TextView) convertView.findViewById(R.id.lvText);
        text.setText(String.valueOf(position+1));
        return convertView;
    }
}
