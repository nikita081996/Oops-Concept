package com.example.nikitaverma.customlistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.nikitaverma.customlistview.Model.Item;
import com.example.nikitaverma.customlistview.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Item> {
    private Context mContext;
    private  int mResource;

    /**
     *
     * @param context
     * @param resource
     * @param itemObject
     */
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Item> itemObject) {
        super(context, resource,itemObject);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getmName();
        String address = getItem(position).getmAddress();
        Long mobile = getItem(position).getmMobile();

        Item item = new Item(name, address, mobile);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tName = (TextView) convertView.findViewById(R.id.name);
        TextView tAddress = (TextView) convertView.findViewById(R.id.address);
        TextView tMobile = (TextView) convertView.findViewById(R.id.mobile);

        tName.setText(name);
        tAddress.setText(address);
        tMobile.setText(mobile.toString());

        return convertView;

    }
}
