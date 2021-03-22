package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.todoapp.data.AppDatabase;
import com.example.todoapp.data.Repository;
import com.example.todoapp.data.Task;
import com.example.todoapp.data.TodoDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private Repository repository;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.task_list);

        repository = Repository.getRepository(this.getApplication());
        List<Task> tasks = repository.getALlTasks();
        adapter = new TaskAdapter(tasks);
        recyclerView.setAdapter(adapter);

        addButton = findViewById(R.id.add_btn);
        
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}