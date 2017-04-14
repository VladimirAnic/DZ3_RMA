package com.example.vladimir.dz3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.example.vladimir.dz3.R.id.etNewCategory;
import static com.example.vladimir.dz3.R.id.lvMain;

public class NewTask extends Activity implements View.OnClickListener {

    Spinner spPriority, spCategory;
    EditText etNewTaskContent, etTitle;
    Button bAddNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setUpUI();
    }

    private void setUpUI() {
        this.spPriority = (Spinner) findViewById(R.id.spPriority);
        this.etTitle = (EditText) findViewById(R.id.etNewTask);
        this.etNewTaskContent = (EditText) findViewById(R.id.etNewTaskContent);
        this.bAddNewTask = (Button) findViewById(R.id.bAddNewTask);
        this.spCategory = (Spinner) findViewById(R.id.spCategory);
        loadSpinnerData();

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.priority,
                        android.R.layout.simple_spinner_item);

        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPriority.setAdapter(staticAdapter);




        this.bAddNewTask.setOnClickListener(this);
    }

    private void loadSpinnerData() {
        TaskDBHelper db = new TaskDBHelper(getApplicationContext());
        ArrayList<String> labels = db.getAllCategories();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spCategory.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = new Intent(getApplicationContext(), MainActivity.class);


        String Title = etTitle.getText().toString();
        String Content = etNewTaskContent.getText().toString();
        String Category = spCategory.getSelectedItem().toString();
        String Status = spPriority.getSelectedItem().toString();


        Task task = new Task(Title,Content,Category,Status);
        TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
        explicitIntent.setClass(getApplicationContext(), MainActivity.class);
        startActivity(explicitIntent);
    }
}
