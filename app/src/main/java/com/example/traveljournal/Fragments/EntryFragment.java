package com.example.traveljournal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.traveljournal.R;

public class EntryFragment extends Fragment {
    private ImageView backButton;
//    private Fragment selectedFragment;
    public EntryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entry, container, false);
        backButton = view.findViewById(R.id.entry_back_button);


        //opening the home fragment
//        selectedFragment =  new HomeFragment();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });
        return view;
    }
}