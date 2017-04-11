package com.example.vladimir.dz3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.vladimir.dz3.R.id.lvMain;

public class NewTask extends Activity {

    Spinner spPriority, spCategory;
    EditText etNewTask;
    Button bAddNewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setUpUI();
    }

    private void setUpUI() {
        this.spPriority = (Spinner) findViewById(R.id.spPriority);
        this.spCategory = (Spinner) findViewById(R.id.spCategory);
        this.etNewTask = (EditText) findViewById(R.id.etNewTask);
        this.bAddNewCategory = (Button) findViewById(R.id.bAddNewCategory);

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.priority,
                        android.R.layout.simple_spinner_item);

        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPriority.setAdapter(staticAdapter);


        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(staticAdapter);

        this.bAddNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(explicitIntent);
                Task task = new Task("My task","Content","Category","Status");
                TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
                TaskAdapter adapter = (TaskAdapter) lvMain.getAdapter();
                this.adapter.insertTask(task);
            }


        });
    }

}
