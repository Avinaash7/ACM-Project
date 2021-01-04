package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    private RecyclerView tasks;
    private TaskAdapter adapter;

    //CheckBox checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<TaskData> array_of_tasks = initTasks();


        this.tasks = (RecyclerView) findViewById(R.id.TasksRec);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.tasks.setLayoutManager(mLayoutManager);

        adapter = new TaskAdapter(array_of_tasks);
        this.tasks.setAdapter(adapter);
        FloatingActionButton fabBtn = (FloatingActionButton) findViewById(R.id.fab);
        fabBtn.setOnClickListener((view) -> {

            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
        });





    }

    public void checkbox_clicked(View view)
    {

        boolean checked = ((CheckBox) view).isChecked();
        CheckBox checkbox = (CheckBox)findViewById(R.id.chkbox);

        switch(view.getId()) {
            case R.id.chkbox:
                if (checked) {
                    String s = checkbox.getText().toString();
                    adapter.DelTask(new TaskData(s));
                }


                    }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra("Task");
                adapter.addTask(new TaskData(returnString));
            }
        }
    }



    private ArrayList<TaskData> initTasks() {
        ArrayList<TaskData> list = new ArrayList<>();

        list.add(new TaskData("To Cycle"));
        list.add(new TaskData("To jog"));
        list.add(new TaskData("Study"));
        list.add(new TaskData("Make An App"));

        return list;
    }

}