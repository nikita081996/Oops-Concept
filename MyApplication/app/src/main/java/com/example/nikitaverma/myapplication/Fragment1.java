package com.example.nikitaverma.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Fragment1 extends Fragment {
    EditText mEditText;
    Button mButton;
    OnMessageReadListener mOnMessageReadListener;

    /*

     */
    public interface  OnMessageReadListener{
        /**
         *
         * @param message
         */
        public void onMessageReadListener(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        mEditText = (EditText)view.findViewById(R.id.edittext);
        mButton = (Button)view.findViewById(R.id.button);
        
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = mEditText.getEditableText().toString();
                Toast.makeText(getActivity(),message+"",Toast.LENGTH_LONG).show();
                Log.d("Message",message);
                mOnMessageReadListener.onMessageReadListener(message);
            }
        });

        return  view;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        Activity activity = (Activity) context;

        try{
            mOnMessageReadListener = (OnMessageReadListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must override on Message Read");
        }
    }


}
