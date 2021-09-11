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

package com.sundydemo.learning1.java.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundydemo.learning1.java.activities.DocumentViewActivity;
import com.sundydemo.learning1.java.adapters.CourseContentDetailsListAdapter;
import com.sundydemo.learning1.databinding.FragmentCourseContentListBinding;
import com.sundydemo.learning1.java.listeners.CourseContentItemClick;
import com.sundydemo.learning1.java.models.CourseContentDataModel;
import com.sundydemo.learning1.java.utils.video.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @since 2020
 * @author Huawei DTSE USA
 */
public class CourseContentListFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    /**
     * The Binding.
     */
    FragmentCourseContentListBinding binding;
    /**
     * The Course content data model list data.
     */
    ArrayList<CourseContentDataModel> CourseContentDataModelListData;
    /**
     * The Recycler view.
     */
    private RecyclerView recyclerView;

    /**
     * Instantiates a new Course content list fragment.
     */
    public CourseContentListFragment() {
    }

    /**
     * New instance course content list fragment.
     *
     * @param myListData the my list data
     * @return the course content list fragment
     */
    public static CourseContentListFragment newInstance(
            ArrayList<CourseContentDataModel> myListData) {
        CourseContentListFragment fragment = new CourseContentListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, myListData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            CourseContentDataModelListData = getArguments().getParcelableArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCourseContentListBinding.inflate(inflater, container, false);
        recyclerView = binding.recyclerviewContentlist;
        binding.recyclerviewContentlist.setHasFixedSize(true);
        binding.recyclerviewContentlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseContentDetailsListAdapter adapter = new CourseContentDetailsListAdapter(
                CourseContentDataModelListData, courseItemClick);
        recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    /**
     * The Course item click.
     */
    CourseContentItemClick courseItemClick =
            model -> {
                Intent intent = new Intent(getActivity(), DocumentViewActivity.class);
                intent.putExtra(Constants.COURSE_DOCUMENTURL, "" + model.getCourseUrl());
                intent.putExtra(Constants.COURSE_NAME, "" + model.getCourseName());
                startActivity(intent);
            };
}
