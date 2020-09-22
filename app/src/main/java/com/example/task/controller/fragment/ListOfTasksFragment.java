package com.example.task.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.ExtractedTextRequest;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.task.R;
import com.example.task.controller.activity.ListOfTasksActivity;
import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class ListOfTasksFragment extends Fragment {
    public static final String ARGS_NUMBER_OF_TASK = "argsNumberOfTask";
    public static final String ARGS_NAME_OF_TASK = "argsNameOfTask";
    private RecyclerView mRecyclerView;

    private int mNumber;
    private String mName;
    private TaskRepository mTaskRepository;
    private List<Task> mTasks;

    public static ListOfTasksFragment newInstance(int number, String name) {
        Bundle args = new Bundle();
        args.putInt(ARGS_NUMBER_OF_TASK, number);
        args.putString(ARGS_NAME_OF_TASK, name);
        ListOfTasksFragment fragment = new ListOfTasksFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public ListOfTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumber = getArguments().getInt(ARGS_NUMBER_OF_TASK);
        mName = getArguments().getString(ARGS_NAME_OF_TASK);
        mTaskRepository = TaskRepository.getInstance(mNumber, mName);
        mTasks = mTaskRepository.getList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_tasks, container, false);
        findViews(view);
        initViews();
        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TaskAdapter adapter = new TaskAdapter(mTasks);
        mRecyclerView.setAdapter(adapter);
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView);
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTxtName;
        RelativeLayout mRelativeLayout;
        private TextView mTxtState;
        private Task mTask;


        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTxtName = itemView.findViewById(R.id.txt_name);
            mTxtState = itemView.findViewById(R.id.txt_state);
            mRelativeLayout=itemView.findViewById(R.id.relative_layout);

        }

        public void bindTask(Task task,int position) {
            if (position%2==0){
                mRelativeLayout.setBackgroundColor(Color.GREEN);
            }
            else mRelativeLayout.setBackgroundColor(Color.BLUE);
            mTxtName.setText(task.getName());
            mTxtState.setText(task.getStateString());
            mTask = task;

        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.task_row, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);

            holder.bindTask(task,position);

        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }

}