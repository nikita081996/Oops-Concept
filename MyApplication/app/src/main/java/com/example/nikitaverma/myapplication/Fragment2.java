package com.example.nikitaverma.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Fragment2 extends Fragment implements KeyConstants {
    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);
        mTextView = (TextView)view.findViewById(R.id.text);
        Bundle bundle = getArguments();
        String message = bundle.getString(KEY_MESSAGE);
        mTextView.setText(message);
        return view;
    }



}
