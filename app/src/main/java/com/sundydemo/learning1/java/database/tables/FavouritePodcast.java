/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 * Generated by the CloudDB ObjectType compiler.  DO NOT EDIT!
 */
package com.sundydemo.learning1.java.database.tables;

import com.huawei.agconnect.cloud.database.CloudDBZoneObject;
import com.huawei.agconnect.cloud.database.Text;
import com.huawei.agconnect.cloud.database.annotations.DefaultValue;
import com.huawei.agconnect.cloud.database.annotations.EntireEncrypted;
import com.huawei.agconnect.cloud.database.annotations.NotNull;
import com.huawei.agconnect.cloud.database.annotations.Indexes;
import com.huawei.agconnect.cloud.database.annotations.PrimaryKeys;

import java.util.Date;

/**
 * Definition of ObjectType FavouritePodcast.
 *
 * @since 2021-06-16
 */
@PrimaryKeys({"podcast_id"})
public final class FavouritePodcast extends CloudDBZoneObject {
    private String podcast_id;

    private String url;

    private String user_id;

    private String user_name;

    private String duration;

    public FavouritePodcast() {
        super(FavouritePodcast.class);
    }

    public void setPodcast_id(String podcast_id) {
        this.podcast_id = podcast_id;
    }

    public String getPodcast_id() {
        return podcast_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

}
