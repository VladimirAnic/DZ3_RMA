package com.example.vladimir.dz3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
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

        this.bNewTask.setOnClickListener(this);
        this.bNewCategory.setOnClickListener(this);




    }
    private ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("The return of the king","J.R.R. Tolkien", "gfdsag", "Top"));
        tasks.add(new Task("A game of thrones","G.R.R. Martin", "fdgha", "Medium"));
        tasks.add(new Task("A clash of kings","G.R.R. Martin", "gfag", "Top"));
        tasks.add(new Task("A storm of swords","G.R.R. Martin", "gasdfgd", "Normal"));
        tasks.add(new Task("A feast for crows","G.R.R. Martin", "fgasdf", "Normal"));
        tasks.add(new Task("A dance with dragons","G.R.R. Martin", "gdsagds", "Top"));
        tasks.add(new Task("The winds of winter","G.R.R. Martin", "gdsagas", "Top"));
        tasks.add(new Task("A dream of spring","G.R.R. Martin", "gdsagdsa", "Medium"));
        return tasks;
    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = null;

        switch (v.getId()) {
            case (R.id.bNewTask):
                explicitIntent = new Intent(getApplicationContext(), NewTask.class);
                this.startActivity(explicitIntent);
                break;
            case (R.id.bNewCategory):
                explicitIntent = new Intent(getApplicationContext(), NewCategory.class);
                this.startActivity(explicitIntent);
                break;
        }
    }
}
