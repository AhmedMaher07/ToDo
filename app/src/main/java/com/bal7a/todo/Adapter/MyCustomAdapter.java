package com.bal7a.todo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bal7a.todo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bal7a on 3/22/2017.
 */
public class MyCustomAdapter extends BaseAdapter {

    Context context;
    int layout_id;
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<String> arrayList1 = new ArrayList();


    public MyCustomAdapter(Context context, int layout_id, ArrayList<String> arrayList, ArrayList<String> arrayList1) {
        this.context = context;
        this.layout_id = layout_id;
        this.arrayList = arrayList;
        this.arrayList1 = arrayList1;

    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout_id, parent, false);
        }


        TextView textViewTitle = (TextView) convertView.findViewById(R.id.item_list);
        textViewTitle.setText((arrayList.get(position)));

        TextView textViewDate = (TextView) convertView.findViewById(R.id.item_date);
        textViewDate.setText((arrayList1.get(position)));

        return convertView;
    }
}
