package com.example.task.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task.R;
import com.example.task.controller.activity.ListOfTasksActivity;
import com.google.android.material.textfield.TextInputEditText;


public class NumberOfTasksFragment extends Fragment {
    public static final String NOTF = "notf";
    private TextInputEditText mName;
    private TextInputEditText mNumber;
    private Button mMade;
    public NumberOfTasksFragment() {
        // Required empty public constructor
    }

    public static NumberOfTasksFragment newInstance() {
        
        Bundle args = new Bundle();

        NumberOfTasksFragment fragment = new NumberOfTasksFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_number_of_tasks, container, false);
        findViews(view);
        mMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //don't forget start activity
                startActivity(ListOfTasksActivity.newIntent(getActivity(),
                        Integer.parseInt(mNumber.getText().toString()),
                        mName.getText().toString()));

                Log.d(NOTF, "mName  : "+  mName.getText().toString());
                Log.d(NOTF,"mNumber  :  "+Integer.parseInt(mNumber.getText().toString()));


            }
        });
        return view;
    }

    private void findViews(View view) {
        mMade=view.findViewById(R.id.btn_numberOfTasks_made);
        mName=view.findViewById(R.id.edt_numberOfTasks_name);
        mNumber=view.findViewById(R.id.edt_numberOfTasks_numberOfTasks);
    }
}