package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{
    private ArrayList<TaskData> array_of_tasks;

    public TaskAdapter(ArrayList<TaskData> Tasks) {
        this.array_of_tasks = Tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskData task = array_of_tasks.get(position);

        holder.value_of_task.setText(task.getName());
    }


    @Override
    public int getItemCount() {
        if (array_of_tasks != null) {
            return array_of_tasks.size();
        } else {
            return 0;
        }
    }

    public void addTask(TaskData task)
    {
        array_of_tasks.add(task);
        notifyDataSetChanged();
    }
    public void DelTask(TaskData task)
    {
        array_of_tasks.remove(task);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView value_of_task;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            value_of_task = view.findViewById(R.id.chkbox);
        }
    }
}
