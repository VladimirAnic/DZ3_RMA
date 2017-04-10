package com.example.vladimir.dz3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewCategory extends Activity {

    EditText etNewCategory;
    Button bAddNewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        setUpUI();
    }

    private void setUpUI() {
        this.etNewCategory = (EditText) findViewById(R.id.etNewCategory);
        this.bAddNewCategory = (Button) findViewById(R.id.bAddNewCategory);


    }
}
