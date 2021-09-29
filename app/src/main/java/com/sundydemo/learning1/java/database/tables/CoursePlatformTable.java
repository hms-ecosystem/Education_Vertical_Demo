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
 * Definition of ObjectType CoursePlatformTable.
 *
 * @since 2021-06-16
 */
@PrimaryKeys({"platformId"})
public final class CoursePlatformTable extends CloudDBZoneObject {
    private Integer platformId;

    private String platformName;

    private String platformDescription;

    public CoursePlatformTable() {
        super(CoursePlatformTable.class);
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformDescription(String platformDescription) {
        this.platformDescription = platformDescription;
    }

    public String getPlatformDescription() {
        return platformDescription;
    }

}