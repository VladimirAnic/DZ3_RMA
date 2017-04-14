package com.example.vladimir.dz3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Vladimir on 11.4.2017..
 */

public class TaskDBHelper extends SQLiteOpenHelper {

    private static TaskDBHelper mTaskDBHelper = null;
    public TaskDBHelper(Context context){
        super(context.getApplicationContext(), Schema.DATABASE_NAME,null,Schema.SCHEMA_VERSION);
    }

    public static synchronized TaskDBHelper getInstance(Context context){
        if(mTaskDBHelper == null){
            mTaskDBHelper= new TaskDBHelper(context);
        }
        return mTaskDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_MY_TASKS);
        db.execSQL(CREATE_TABLE_MY_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MY_TASKS);
        db.execSQL(DROP_TABLE_MY_CATEGORY);
        this.onCreate(db);
    }

    //SQL statements
    static final String CREATE_TABLE_MY_TASKS="CREATE TABLE "+Schema.TABLE_MY_TASKS+"("+Schema.TITLE+" TEXT, "+Schema.CONTENT+" TEXT, "+Schema.CATEGORY+ " TEXT, "+Schema.STATUS+" TEXT);";
    static final String CREATE_TABLE_MY_CATEGORY = "CREATE TABLE " + SchemaC.TABLE_MY_CATEGORY + "(" + SchemaC.CATEROGRY_ROW + " TEXT);";
    static final String DROP_TABLE_MY_CATEGORY = "DROP TABLE IF EXISTS " + SchemaC.TABLE_MY_CATEGORY;
    static final String DROP_TABLE_MY_TASKS = "DROP TABLE IF EXISTS " + Schema.TABLE_MY_TASKS;
    static final String SELECT_ALL_TASKS="SELECT * FROM "+Schema.TABLE_MY_TASKS;
    static final String SELECT_ALL_CATEGORY="SELECT * FROM "+SchemaC.TABLE_MY_CATEGORY;

    // CRUD should be performed on another thread
    public void insertTask(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.TITLE, task.getTitle());
        contentValues.put(Schema.CONTENT, task.getContent());
        contentValues.put(Schema.CATEGORY, task.getCategory());
        contentValues.put(Schema.STATUS, task.getStatus());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_MY_TASKS, Schema.TITLE,contentValues);
        writeableDatabase.close();
    }

    public void insertCategory(String Category){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemaC.CATEROGRY_ROW, Category);
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.insert(SchemaC.TABLE_MY_CATEGORY, SchemaC.CATEROGRY_ROW, contentValues);
        writableDatabase.close();
    }

    public void deleteTasks(Task task) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.delete(Schema.TABLE_MY_TASKS, Schema.TITLE + " = ?", new String[]{task.getTitle()});
        writableDatabase.close();
    }

    public void deleteCategory(String Category) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.delete(SchemaC.TABLE_MY_CATEGORY, SchemaC.CATEROGRY_ROW + " = ?", new String[]{Category});
        writableDatabase.close();
    }

    public ArrayList<Task> getAllTasks() {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writeableDatabase.rawQuery(SELECT_ALL_TASKS, null);
        ArrayList<Task> tasks = new ArrayList<>();
        if (taskCursor.moveToFirst()) {
            do {
                String title = taskCursor.getString(0);
                String content = taskCursor.getString(1);
                String category = taskCursor.getString(2);
                String status = taskCursor.getString(3);
                tasks.add(new Task(title, content, category, status));
            } while (taskCursor.moveToNext());
        }
        taskCursor.close();
        writeableDatabase.close();
        return tasks;
    }

    public ArrayList<String> getAllCategories() {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor categoryCursor = writeableDatabase.rawQuery(SELECT_ALL_CATEGORY, null);
        ArrayList<String> category = new ArrayList<>();
        if (categoryCursor.moveToFirst()) {
            do {
               category.add(categoryCursor.getString(0));
            } while (categoryCursor.moveToNext());
        }
        categoryCursor.close();
        writeableDatabase.close();
        return category;
    }

    public static class Schema {
        private static final int SCHEMA_VERSION = 2;
        private static final String DATABASE_NAME = "tasks.db";
        static final String TABLE_MY_TASKS = "my_tasks";
        static final String CATEGORY = "category";
        static final String TITLE = "title";
        static final String CONTENT = "content";
        static final String STATUS="status";
    }
    public static class SchemaC{
        static final String TABLE_MY_CATEGORY = "my_category";
        static final String CATEROGRY_ROW = "category_name";
    }
}

