package com.example.task.model;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class Task {
    private enum State{Todo,Doing,Done}
    private String mName;
    private State mState;
    private String mStateString;
    private SecureRandom mRandom=new SecureRandom();
    private UUID mId;

    public UUID getId() {
        return mId;
    }

    public Task(String name) {
        mId=UUID.randomUUID();
        int random= mRandom.nextInt(3);
        if (random==0){
            mState=State.Todo;
            mStateString="ToDo";
        }
       else if (random==1){
           mState=State.Doing;
           mStateString="Doing";
        }
        else{
            mState=State.Done;
            mStateString="Done";
        }
        mName=name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public State getState() {
        return mState;
    }
    public  String getStateString(){
        return mStateString;
    }


}
