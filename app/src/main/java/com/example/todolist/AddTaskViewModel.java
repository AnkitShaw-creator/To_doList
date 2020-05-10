package com.example.todolist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import database.AppDatabase;
import database.TaskEntry;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry>task;

    public AddTaskViewModel(AppDatabase mDb, int taskId) {
        task =mDb.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask(){
        return task;
    }
}
