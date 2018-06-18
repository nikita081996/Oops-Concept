package com.example.nikitaverma.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.nikitaverma.customlistview.Constants.Constants;
import com.example.nikitaverma.customlistview.DataManager.UserData;
import com.example.nikitaverma.customlistview.Model.Item;
import com.example.nikitaverma.customlistview.adapter.CustomAdapter;

import java.util.ArrayList;

public class ItemListView extends AppCompatActivity implements Constants{
    ListView listView;
    EditText mSearch;
    public CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlistview);

        listView = (ListView) findViewById(R.id.listview);
        mSearch = (EditText) findViewById(R.id.search);

        customAdapter = new CustomAdapter(ItemListView.this, R.layout.custom_listview, UserData.getInstance().arrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                //  Item selectedItem = (Item)(parent.getItemAtPosition(position));
                Item lv = UserData.getInstance().arrayList.get(position);
                UserData.getInstance().arrayList.remove(lv);
                customAdapter.notifyDataSetChanged();
                return true;
            }
        });

        mSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                //ItemListView.this.customAdapter.getFeilter().filter(cs.toString());
                /*ItemListView.this.customAdapter.getFilter().filter(cs);
                customAdapter.notifyDataSetChanged();*/
                filter(cs.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


    public void filter(String charText) {
        charText = charText.toLowerCase();
        ArrayList<Item> arrayList = new ArrayList<>();

            if (charText.length() == 0)
            {
             customAdapter = new CustomAdapter(ItemListView.this, R.layout.custom_listview, UserData.getInstance().arrayList);
             listView.setAdapter(customAdapter);
             }

             else
                 {
                for (Item item : UserData.getInstance().arrayList)
                {
                    if (item.getmName().toLowerCase().contains(charText))
                    {
                     arrayList.add(item);
                     }
                }

             customAdapter = new CustomAdapter(ItemListView.this, R.layout.custom_listview, arrayList);
             listView.setAdapter(customAdapter);
             }

        }

}
