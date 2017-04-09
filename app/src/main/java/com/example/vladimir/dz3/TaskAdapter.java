package com.example.vladimir.dz3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vladimir on 9.4.2017..
 */

public class TaskAdapter extends BaseAdapter {
    private ArrayList<Task> mTasks;

    public TaskAdapter(ArrayList<Task> tasks) {mTasks=tasks;}

    @Override
    public int getCount() { return this.mTasks.size(); }
    @Override
    public Object getItem(int position) { return this.mTasks.get(position); }
    @Override
    public long getItemId(int position) { return position; }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder taskViewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_book, parent, false);
            taskViewHolder = new ViewHolder(convertView);
            convertView.setTag(taskViewHolder);
        }
        else{
            taskViewHolder = (ViewHolder) convertView.getTag();
        }
        Task task = this.mTasks.get(position);
        taskViewHolder.tvTaskTitle.setText(task.getTitle());
        taskViewHolder.tvTaskContent.setText(task.getContent());
        taskViewHolder.tvTaskCategory.setText(task.getCategory());
        return convertView;
    }
    public static class ViewHolder {
        public TextView tvTaskTitle, tvTaskCategory, tvTaskContent;
        public ViewHolder(View bookView) {
            tvTaskTitle = (TextView) bookView.findViewById(R.id.tvTaskTitle);
            tvTaskContent = (TextView) bookView.findViewById(R.id.tvTaskContent);
            tvTaskCategory = (TextView) bookView.findViewById(R.id.tvTaskCategory);
        }
    }
}

