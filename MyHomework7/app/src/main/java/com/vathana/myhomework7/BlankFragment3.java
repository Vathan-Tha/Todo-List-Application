package com.vathana.myhomework7;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class BlankFragment3 extends DialogFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public BlankFragment3() {
        // Required empty public constructor
    }

    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment = new BlankFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar cd = Calendar.getInstance();
        int hour = cd.get(Calendar.HOUR_OF_DAY);
        int mid = cd.get(Calendar.MINUTE);
        TimePickerDialog.OnTimeSetListener timeSetListener = (TimePickerDialog.OnTimeSetListener) getActivity();
        return new TimePickerDialog(getActivity(), timeSetListener, hour, mid, DateFormat.is24HourFormat((getActivity())
        ));
    }
}