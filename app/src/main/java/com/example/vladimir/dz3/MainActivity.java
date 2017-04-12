package com.example.vladimir.dz3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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


        this.lvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Task task= (Task) parent.getAdapter().getItem(position);
                TaskDBHelper.getInstance(getApplicationContext()).deleteTasks(task);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Are you sure you want to delete a task?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mTaskAdapter.delete(position);
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

                return true;
            }
        });

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
