package com.example.vladimir.dz3;

/**
 * Created by Vladimir on 9.4.2017..
 */

public class Task {
    private String mTitle, mContent, mCategory;

    public Task(String title, String content, String category) {
        mTitle = title;
        mContent = content;
        mCategory = category;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getContent() {
        return mContent;
    }

}
