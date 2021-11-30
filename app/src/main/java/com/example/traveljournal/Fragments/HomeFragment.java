package com.example.traveljournal.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.traveljournal.Adapter.JournalEntryRecViewAdapter;
import com.example.traveljournal.EntryRecyclerViewInterface;
import com.example.traveljournal.MainActivity;
import com.example.traveljournal.Model.JournalEntry;
import com.example.traveljournal.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements EntryRecyclerViewInterface {
    private RecyclerView entryRecyclerView;
    private Fragment selectedFragment;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        ArrayList<JournalEntry> entries = new ArrayList<>();

        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));
        entries.add(new JournalEntry("TestTitle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do. ", "27/11/2021"));


        JournalEntryRecViewAdapter adapter = new JournalEntryRecViewAdapter(this);
        adapter.setEntries(entries);

        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        entryRecyclerView = view.findViewById(R.id.entry_recyclerview);
        entryRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        entryRecyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
       return view;


    }
    //overriding interface method to open the entry details in the EntryFragment
    @Override
    public void onEntryClick(int position) {
        selectedFragment =  new EntryFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }
}