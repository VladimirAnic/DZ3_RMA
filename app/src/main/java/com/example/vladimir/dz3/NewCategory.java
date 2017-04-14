package com.example.vladimir.dz3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class NewCategory extends Activity implements View.OnClickListener {

    EditText etNewCategory;
    Button bAddNewCategory;
    ListView lvCategories;
    CategoryAdapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        setUpUI();
    }

    private void setUpUI() {
        this.etNewCategory = (EditText) findViewById(R.id.etNewCategory);
        this.bAddNewCategory = (Button) findViewById(R.id.bAddNewCategory);
        this.lvCategories = (ListView) findViewById(R.id.lvCategories);

        this.mCategoryAdapter = new CategoryAdapter(this.loadCategories());
        this.lvCategories.setAdapter(this.mCategoryAdapter);

        this.bAddNewCategory.setOnClickListener(this);

        this.lvCategories.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                String category= (String) parent.getAdapter().getItem(position);
                TaskDBHelper.getInstance(getApplicationContext()).deleteCategory(category);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(NewCategory.this);
                builder1.setMessage("Are you sure you want to delete a category?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                mCategoryAdapter.deleteC(position);

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;
            }
        });

    }

    private ArrayList<String> loadCategories() {
        return TaskDBHelper.getInstance(this).getAllCategories();

    }

    @Override
    public void onClick(View v) {

        Intent explicitIntent = new Intent();

        String Category = etNewCategory.getText().toString();
        TaskDBHelper.getInstance(getApplicationContext()).insertCategory(Category);
        explicitIntent.setClass(getApplicationContext(), MainActivity.class);
        startActivity(explicitIntent);

    }
}
