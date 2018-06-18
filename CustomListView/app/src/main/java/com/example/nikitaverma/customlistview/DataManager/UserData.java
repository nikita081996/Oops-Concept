package com.example.nikitaverma.customlistview.DataManager;

import android.content.Intent;
import android.widget.ListView;

import com.example.nikitaverma.customlistview.Constants.Constants;
import com.example.nikitaverma.customlistview.ItemListView;
import com.example.nikitaverma.customlistview.Model.Item;
import com.example.nikitaverma.customlistview.R;

import java.util.ArrayList;

import static com.example.nikitaverma.customlistview.Constants.Constants.MOBILE;

public class UserData implements Constants{

    public static UserData mUserData;
    public ArrayList<Item> arrayList = new ArrayList<>();

    private UserData() {
    }

    public static UserData getInstance() {
        if (mUserData == null) {
            mUserData = new UserData();
        }
        return mUserData;
    }

    public void addItem(Item item){

        //   Item item2 = new Item("Nikita", "MZP", Long.parseLong("2345"));
        //     Item item3 = new Item("Nikita", "MZP", Long.parseLong("9835567239"));



    }
}
