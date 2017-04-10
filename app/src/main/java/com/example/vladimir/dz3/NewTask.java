package com.example.vladimir.dz3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class NewTask extends Activity {

    Spinner spPriority, spCategory;
    EditText etNewTask;

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

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.priority,
                        android.R.layout.simple_spinner_item);

        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPriority.setAdapter(staticAdapter);


        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(staticAdapter);
    }
}
