package com.example.nikitaverma.customlistview.Model;

public class Item {

    private String mName;
    private String mAddress;
    private long mMobile;

    public Item(String mName, String mAddress, long mMobile) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mMobile = mMobile;
    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public long getmMobile() {
        return mMobile;
    }
}
