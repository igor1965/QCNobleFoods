package com.igor.qcnoblefoods.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.igor.qcnoblefoods.R;

import java.util.Calendar;
import java.util.TimeZone;


public class ViewFragment extends Fragment {
    private static final String TAG = "ViewFragment";

    private ImageView ivBack;
    private ImageView ivCalendar;
    private EditText etDate;
    private Button btnView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_view,container,false);
        ivBack = view.findViewById(R.id.arrowBack);
        ivCalendar = view.findViewById(R.id.ivCalendar);
        etDate = view.findViewById(R.id.etDate);
        btnView = view.findViewById(R.id.btnView);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDayPickerDialog();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemsListFragment itemListFragment = new ItemsListFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,itemListFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return view;
    }
    private void showDayPickerDialog(){
      //  Calendar cal = Calendar.getInstance(TimeZone.getDefault()); // Get current date
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),R.style.Theme_AppCompat,datePickerListener,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.MONTH)
        );
        datePickerDialog.show();
    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String year1 = String.valueOf(i);
            String month1 = String.valueOf(i1 + 1);
            String day1 = String.valueOf(i2);
            etDate.setText(day1 + "/" + month1 + "/" + year1);

        }
    };
}
