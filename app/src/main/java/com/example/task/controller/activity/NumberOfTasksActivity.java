package com.example.task.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.task.R;
import com.example.task.controller.fragment.NumberOfTasksFragment;

public class NumberOfTasksActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return NumberOfTasksFragment.newInstance();
    }
    public static Intent newIntent(Context context){
        return  new Intent(context,NumberOfTasksFragment.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}