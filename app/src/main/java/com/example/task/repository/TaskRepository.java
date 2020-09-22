package com.example.task.repository;

import android.content.Intent;

import com.example.task.controller.activity.ListOfTasksActivity;
import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {


    private List<Task> mList;
    private static TaskRepository sInstance;


    public static TaskRepository getInstance(int number,String name){
        if (sInstance==null)
            sInstance= new TaskRepository(number,name);
        return sInstance;
    }


    private TaskRepository(int number,String name) {
        mList=new ArrayList<>();
        for (int i = 0; i <number ; i++) {
            Task task=new Task(name);
            mList.add(task);
        }

    }
    public List<Task> getList(){
        return mList;
    }

    public void setList(List<Task> list) {
        mList = list;
    }
    public void setTask(Task task){
        mList.add(task);
    }
}
