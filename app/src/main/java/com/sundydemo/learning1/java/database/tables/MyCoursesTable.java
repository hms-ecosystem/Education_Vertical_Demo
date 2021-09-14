/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 *     Licensed under the Apache License, Version 2.0 (the "License");
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
 * Generated by the CloudDB ObjectType compiler.  DO NOT EDIT!
 */
package com.sundydemo.learning1.java.database.tables;

import com.huawei.agconnect.cloud.database.CloudDBZoneObject;
import com.huawei.agconnect.cloud.database.annotations.PrimaryKeys;

/**
 * Definition of ObjectType MyCoursesTable.
 *
 * @since 2021-06-16
 */
@PrimaryKeys({"myCourseId"})
public final class MyCoursesTable extends CloudDBZoneObject {
    private Integer myCourseId;

    private String userId;

    private Integer courseId;

    private String courseName;

    public MyCoursesTable() {
        super(MyCoursesTable.class);
    }

    public void setMyCourseId(Integer myCourseId) {
        this.myCourseId = myCourseId;
    }

    public Integer getMyCourseId() {
        return myCourseId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

}
