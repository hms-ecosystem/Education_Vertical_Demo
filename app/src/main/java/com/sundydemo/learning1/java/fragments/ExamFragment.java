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

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sundydemo.learning1.java.activities.BaseActivity;
import com.sundydemo.learning1.java.activities.ExamActivity;
import com.sundydemo.learning1.databinding.FragmentExamBinding;
import com.sundydemo.learning1.java.models.ExamModel;
import com.sundydemo.learning1.java.models.UserObj;
import com.sundydemo.learning1.java.utils.LearningApplication;
import com.sundydemo.learning1.java.utils.eventmanager.AppAnalytics;
import com.sundydemo.learning1.java.utils.video.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @since 2020
 * @author Huawei DTSE USA
 */
public class ExamFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    /**
     * The Binding.
     */
    FragmentExamBinding binding;
    /**
     * The Exam model.
     */
    ExamModel examModel = null;
    /**
     * The App analytics.
     */
    AppAnalytics appAnalytics = null;
    /**
     * The User obj.
     */
    UserObj userObj = null;

    /**
     * Instantiates a new Exam fragment.
     */
    public ExamFragment() {
    }

    /**
     * New instance exam fragment.
     *
     * @param examModel the exam model
     * @return the exam fragment
     */
    public static ExamFragment newInstance(ExamModel examModel) {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, examModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            examModel = getArguments().getParcelable(ARG_PARAM1);
        }
        appAnalytics = ((BaseActivity) Objects.requireNonNull(getActivity())).appAnalytics;
        userObj = ((LearningApplication) getActivity().getApplication()).getUserObj();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExamBinding.inflate(inflater, container, false);
        binding.examTitle.setText(examModel.getName());
        binding.examDesc.setText(examModel.getDesc());
        binding.examDurationMin.setText("" + examModel.getDuration());
        binding.examTotalQC.setText("" + examModel.getNoOfQuestions());

        binding.startexam.setOnClickListener(start -> {
                    if (!((BaseActivity) Objects.requireNonNull(getActivity())).showLoginDialog()) {
                        if (userObj == null)
                            userObj = ((LearningApplication) getActivity()
                                    .getApplication()).getUserObj();
                        if (userObj != null) {
                            navigatetoExam();
                        }
                    }
                }
        );
        return binding.getRoot();
    }

    // navigate to exam activity
    private void navigatetoExam() {
        appAnalytics.startExamClickEvent(examModel.getName());
        Intent intent = new Intent(getActivity(), ExamActivity.class);
        intent.putExtra(Constants.COURSE_NAME, examModel.getName());
        intent.putExtra(Constants.COURSE_ID, "" + examModel.getCId());
        startActivity(intent);
    }
}
