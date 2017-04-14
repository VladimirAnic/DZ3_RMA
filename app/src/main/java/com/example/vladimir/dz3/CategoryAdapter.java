package com.example.vladimir.dz3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vladimir on 14.4.2017..
 */

public class CategoryAdapter extends BaseAdapter {

    ArrayList<String> mCategories;

    public CategoryAdapter(ArrayList<String> Categories) {
        this.mCategories = Categories;
    }

    @Override
    public int getCount() {
        return this.mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryAdapter.ViewHolder categoryViewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_category, parent, false);
            categoryViewHolder = new CategoryAdapter.ViewHolder(convertView);
            convertView.setTag(categoryViewHolder);
        } else {
            categoryViewHolder = (CategoryAdapter.ViewHolder) convertView.getTag();
        }
        String category = this.mCategories.get(position);
        categoryViewHolder.tvCategory.setText(category);
        return convertView;
    }

    public void deleteC(int position) {
        this.mCategories.remove(position);
        this.notifyDataSetChanged();
    }

    public class ViewHolder {
        public TextView tvCategory;
        public ViewHolder(View taskView) {
            tvCategory = (TextView) taskView.findViewById(R.id.tvCategory);
        }
    }
}
