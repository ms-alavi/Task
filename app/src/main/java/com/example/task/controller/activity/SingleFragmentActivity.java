package com.example.task.controller.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.task.R;
import com.example.task.controller.fragment.NumberOfTasksFragment;

public  abstract class SingleFragmentActivity extends AppCompatActivity {

public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_container_tasks);
        FragmentManager fragmentManager=getSupportFragmentManager();


        fragmentManager.beginTransaction()
                .add(R.id.Frm_container,createFragment())
                .commit();
    }
}
