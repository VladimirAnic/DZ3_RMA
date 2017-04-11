package com.example.vladimir.dz3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Locale;

import javax.xml.validation.Schema;

/**
 * Created by Vladimir on 11.4.2017..
 */

public class TaskDBHelper extends SQLiteOpenHelper {

    private static TaskDBHelper mTaskDBHelper = null;
    private TaskDBHelper (Context context){
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MY_TASKS);
        this.onCreate(db);
    }

    //SQL statements
    static final String CREATE_TABLE_MY_TASKS = "CREATE TABLE " + Schema.TABLE_MY_TASKS +
            " (" + Schema.TITLE + " TEXT," + Schema.CONTENT + " TEXT"+ Schema.CATEGORY  + "TEXT)";
    static final String DROP_TABLE_MY_TASKS = "DROP TABLE IF EXISTS " + Schema.TABLE_MY_TASKS;
    static final String SELECT_ALL_TASKS = "SELECT " + Schema.TITLE + " FROM " + Schema.TABLE_MY_TASKS;

    // CRUD should be performed on another thread
    public void insertTask(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.TITLE, task.getTitle());
        contentValues.put(Schema.CONTENT, task.getContent());
        contentValues.put(Schema.CATEGORY, task.getCategory());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_MY_TASKS, Schema.TITLE,contentValues);
        writeableDatabase.close();
    }

    public ArrayList<Task> getAllTasks(){
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writeableDatabase.rawQuery(SELECT_ALL_TASKS,null);
        ArrayList<Task> books = new ArrayList<>();
        if(taskCursor.moveToFirst()){
            do{
                String Title = taskCursor.getString(0);
                String Content = taskCursor.getString(1);
                String Category = taskCursor.getString(2);
                String Status = taskCursor.getString(3);
                books.add(new Task(Title, Content, Category, Status));
            }while(taskCursor.moveToNext());
        }
        taskCursor.close();
        writeableDatabase.close();
        return books;
    }

    public static class Schema {
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "tasks.db";
        //A table to store owned books:
        static final String TABLE_MY_TASKS = "my_tasks";
        static final String CATEGORY = "category";
        static final String TITLE = "title";
        static final String CONTENT = "content";
    }
}

