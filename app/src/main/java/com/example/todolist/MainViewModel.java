package com.example.todolist;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import database.AppDatabase;
import database.TaskEntry;

public class MainViewModel extends AndroidViewModel {

     private LiveData<List<TaskEntry>>tasks;
     public static final String  TAG =MainViewModel.class.getSimpleName();
    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "MainViewModel: Actively Receiving liveData model from database");
        tasks =database.taskDao().loadAllTasks();
    }
    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }
}
