package com.example.harika.assignment3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;


public class Fragment_List extends Fragment {

    TextView counter;
    Button increaseBtn;
    Button decreaseBtn;
    MovieBean movieBean;
    onButtonClickListener buttonClickListener;
    int position =0;
    int size;
    String counterText = "Counter : ";

    public Fragment_List() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieBean = new MovieBean();
        size = movieBean.getSize()-1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        buttonClickListener = (onButtonClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment__list, container, false);
        increaseBtn = (Button) rootView.findViewById(R.id.increaseButton);
        decreaseBtn = (Button) rootView.findViewById(R.id.decreaseButton);
        counter = (TextView) rootView.findViewById(R.id.counter);

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position<size) {
                    ++position;
                    counter.setText(counterText.concat(String.valueOf(position)));
                    buttonClickListener.onButtonClicked(position);
                }

            }
        });

        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position >0) {
                    --position;
                    counter.setText(counterText.concat(String.valueOf(position)));
                    buttonClickListener.onButtonClicked(position);
                }
            }
        });

        return rootView;
    }

    public interface onButtonClickListener
    {
        void  onButtonClicked(int position);
    }

    @Override
    public void onResume() {
        super.onResume();
        counter.setText(counterText.concat(String.valueOf(position)));
    }
}
