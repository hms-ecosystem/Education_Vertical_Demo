/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sundydemo.learning1.java.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sundydemo.learning1.R;
import com.sundydemo.learning1.java.listeners.CourseTypeItemClick;
import com.sundydemo.learning1.java.models.CourseDetailsDataModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @since 2020
 * @author Huawei DTSE India
 */
public class CourseDetailsListAdapter extends RecyclerView.Adapter<CourseDetailsListAdapter.ViewHolder> {
    /**
     * The Course type item click.
     */
    CourseTypeItemClick courseTypeItemClick;
    /**
     * The Listdata.
     */
    ArrayList<CourseDetailsDataModel> listdata;

    /**
     * Instantiates a new Course details list adapter.
     *
     * @param listdata            the listdata
     * @param CourseTypeItemClick the course type item click
     */
    public CourseDetailsListAdapter(
            ArrayList<CourseDetailsDataModel> listdata, CourseTypeItemClick CourseTypeItemClick) {
        this.listdata = listdata;
        this.courseTypeItemClick = CourseTypeItemClick;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.courses_content_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.courseName.setText(listdata.get(position).getName());
        holder.cardView.setOnClickListener(start -> courseTypeItemClick.courseOnClick(listdata.get(position)));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Course name.
         */
        private TextView courseName;
        /**
         * The Card view.
         */
        private CardView cardView;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        public ViewHolder(View itemView) {
            super(itemView);
            this.courseName = itemView.findViewById(R.id.coursename);
            this.cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
