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
        return TaskDBHelper.getInstance(this).getAllTasks();
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
