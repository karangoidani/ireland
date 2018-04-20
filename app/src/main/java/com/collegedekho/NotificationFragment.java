package com.collegedekho;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.collegedekho.adapter.CollegeListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */


public class NotificationFragment extends Fragment {
    View view;
    ListView mListView;
    Context mContext;
    private CollegeListAdapter adapter;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = container.getContext();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        view = inflater.inflate(R.layout.fragment_notification, container, false);
        init();

        return view;
    }

    private void init() {

        mListView = view.findViewById(R.id.collegeList);
        adapter = new CollegeListAdapter(mContext);
        mListView.setAdapter(adapter);

    }

}

