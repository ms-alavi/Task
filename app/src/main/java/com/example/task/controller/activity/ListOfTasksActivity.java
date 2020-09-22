package com.example.task.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.task.controller.fragment.ListOfTasksFragment;

public class ListOfTasksActivity extends SingleFragmentActivity {

    public static final String EXTRA_NUMBER_OF_TASKS = "com.example.task.controller.activity.ExtraNumberOfTasks";
    public static final String EXTRA_NAME_OF_USER = "com.example.task.controller.activity.nameOfUser";

    @Override
    public Fragment createFragment() {
        return ListOfTasksFragment.newInstance(
                getIntent().getIntExtra(EXTRA_NUMBER_OF_TASKS,0),
                getIntent().getStringExtra(EXTRA_NAME_OF_USER)
        );
    }
    public static Intent newIntent(Context context,int numberOfTasks,String name){
        Intent intent=new Intent(context,ListOfTasksActivity.class);
        intent.putExtra(EXTRA_NUMBER_OF_TASKS,numberOfTasks);
        intent.putExtra(EXTRA_NAME_OF_USER,name);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}