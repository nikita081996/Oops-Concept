package com.example.nikitaverma.fragment_to_activity_communication;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Message_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Message_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Message_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    EditText mEditText;
    Button mButton;
    OnMessageReadListener onMessageReadListener;
        public interface  OnMessageReadListener{
            public void onMessageReadListener(String message);
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_fragment, container, false);
        mEditText = view.findViewById(R.id.edittext);
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = mEditText.getText().toString();
                onMessageReadListener.onMessageReadListener(message);
            }
        });

        return  view;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            onMessageReadListener = (OnMessageReadListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must override on Message Read");
        }
    }

}
