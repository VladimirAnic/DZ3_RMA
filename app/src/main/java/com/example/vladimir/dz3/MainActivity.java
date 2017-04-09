package com.example.vladimir.dz3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lvMain;
    Button bNewCategory, bNewTask;
    TaskAdapter mTaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        this.lvMain = (ListView) this.findViewById(R.id.lvMain);
        this.bNewCategory = (Button) this.findViewById(R.id.bNewCategory);
        this.bNewTask = (Button) this.findViewById(R.id.bNewTask);
        this.mTaskAdapter = new TaskAdapter(this.loadTasks());
        this.lvMain.setAdapter(this.mTaskAdapter);


        //TaskAdapter taskAdapter = new TaskAdapter(tasks);
        //this.lvMain.setAdapter(taskAdapter);

    }
    private ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("The Hobbit","J.R.R. Tolkien", "0"));
        tasks.add(new Task("The fellowship of the ring","J.R.R. Tolkien", ""));
        tasks.add(new Task("The two towers","J.R.R. Tolkien", ""));
        tasks.add(new Task("The return of the king","J.R.R. Tolkien", ""));
        tasks.add(new Task("A game of thrones","G.R.R. Martin", ""));
        tasks.add(new Task("A clash of kings","G.R.R. Martin", ""));
        tasks.add(new Task("A storm of swords","G.R.R. Martin", ""));
        tasks.add(new Task("A feast for crows","G.R.R. Martin", ""));
        tasks.add(new Task("A dance with dragons","G.R.R. Martin", ""));
        tasks.add(new Task("The winds of winter","G.R.R. Martin", ""));
        tasks.add(new Task("A dream of spring","G.R.R. Martin", ""));
        return tasks;
    }
}
