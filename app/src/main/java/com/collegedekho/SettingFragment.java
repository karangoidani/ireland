package com.collegedekho;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    View view;
    Button mBtnApply;

    public SettingFragment() {
        // Required empty public constructor
    }

    public void onApplyClicked() {
        ((MainActivity) getActivity()).onHandleClick("HowToApply");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_setting, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        mBtnApply = view.findViewById(R.id.button_Apply);
        mBtnApply.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Apply:
                onApplyClicked();
                break;
        }
    }
}
