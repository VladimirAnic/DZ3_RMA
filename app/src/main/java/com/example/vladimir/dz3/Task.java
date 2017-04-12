package com.example.vladimir.dz3;

/**
 * Created by Vladimir on 9.4.2017..
 */

public class Task {
    private String mTitle, mContent, mCategory, mStatus;

    public Task(String title, String content, String category, String status) {
        mTitle = title;
        mContent = content;
        mCategory = category;
        mStatus = status;
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

    public String getStatus() {
        return mStatus;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
