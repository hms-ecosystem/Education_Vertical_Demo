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

package com.sundydemo.learning1.java.database;

import android.content.Context;
import android.util.Log;

import com.huawei.agconnect.cloud.database.AGConnectCloudDB;
import com.huawei.agconnect.cloud.database.CloudDBZone;
import com.huawei.agconnect.cloud.database.CloudDBZoneConfig;
import com.huawei.agconnect.cloud.database.exceptions.AGConnectCloudDBException;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;

/**
 * @author Huawei DTSE India
 * @since 2020
 *
 * @author Futurewei DTSE USA
 * Bug fix:  Changed line# 40, 73 to fix video player issue 
 * @since 2021
 */
public class CloudDbHelper {
    private static volatile CloudDbHelper cloudDbHelper = null;
private static boolean initFlag = false; //HQ changed to fix bug
    /**
     * Gets instance.
     *
     * @param context the context
     * @return the instance
     */
    public static CloudDbHelper getInstance(Context context) {
        if (cloudDbHelper == null) {
            synchronized (CloudDbHelper.class) {
                if (cloudDbHelper == null) cloudDbHelper = new CloudDbHelper(context);
            }
        }
        return cloudDbHelper;
    }

    private AGConnectCloudDB mCloudDB;
    private CloudDBZone mCloudDBZone;
    private CloudDBZoneConfig mConfig;

    private CloudDbQueyCalls cloudDbQueyCalls;

    /**
     * The Cloud db ui callback listener.
     */
    CloudDbUiCallbackListener cloudDbUiCallbackListener;

    /**
     * Instantiates a new Cloud db helper.
     *
     * @param context the context
     */
    public CloudDbHelper(Context context) {
//        initAGConnectCloudDB(context); //commented by HQ team to fix bug
        Log.d("Fatal Test", "CloudDbHelper: ");
        mCloudDB = AGConnectCloudDB.getInstance();
        cloudDbQueyCalls = new CloudDbQueyCalls();
    }

    /**
     * Init AGConnectCloudDB in Application
     *
     * @param context application context
     */
/*    public void initAGConnectCloudDB(Context context) {
        AGConnectCloudDB.initialize(context);
    }*/

    public static void initAGConnectCloudDB(Context context) {
        Log.d("Fatal Test", "Enter initAGConnectCloudDB: ");
        if(initFlag == false) {
            Log.d("Fatal Test", "initAGConnectCloudDB: ");
            initFlag = true;
            AGConnectCloudDB.initialize(context);
        }
    }

    /**
     * Call AGConnectCloudDB.createObjectType to init schema
     */
    public void createObjectType() {

        try {
            mCloudDB.createObjectType(ObjectTypeInfoHelper.getObjectTypeInfo());
        } catch (AGConnectCloudDBException exp) {
            System.out.println("##sundy " + exp.toString());
        }

    }

    /**
     * Open cloud db zone v 2.
     *
     * @param cloudDbAction the cloud db action
     */
    public void openCloudDBZoneV2(CloudDbAction cloudDbAction) {
        mConfig =
                new CloudDBZoneConfig(
                        CloudDbConstants.CLOUD_DB,
                        CloudDBZoneConfig.CloudDBZoneSyncProperty.CLOUDDBZONE_CLOUD_CACHE,
                        CloudDBZoneConfig.CloudDBZoneAccessProperty.CLOUDDBZONE_PUBLIC);
        mConfig.setPersistenceEnabled(true);
        Task<CloudDBZone> openDBZoneTask = mCloudDB.openCloudDBZone2(mConfig, true);
        System.out.println("#sundy: " + openDBZoneTask);
        openDBZoneTask
                .addOnSuccessListener(
                        new OnSuccessListener<CloudDBZone>() {
                            @Override
                            public void onSuccess(CloudDBZone cloudDBZone) {
                                mCloudDBZone = cloudDBZone;
                                cloudDbQueyCalls.setmCloudDBZone(mCloudDBZone);
                                cloudDbUiCallbackListener.onSuccessDbQueryMessage(
                                        cloudDbAction, "open clouddbzone success");
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(Exception exp) {
                                System.out.println("#sundy: " + exp.toString());
                                cloudDbUiCallbackListener.onFailureDbQueryMessage(
                                        cloudDbAction, "");
                            }
                        });
    }


    /**
     * Add call back listener.
     *
     * @param cloudDbUiCallbackListener the cloud db ui callback listener
     */
    public void addCallBackListener(CloudDbUiCallbackListener cloudDbUiCallbackListener) {
        this.cloudDbUiCallbackListener = cloudDbUiCallbackListener;
    }

    /**
     * Returning the cloud db query instance
     *
     * @return cloud db quey calls
     */
    public CloudDbQueyCalls getCloudDbQueyCalls() {
        if (cloudDbQueyCalls != null) {
            cloudDbQueyCalls.setCloudDbUiCallbackListener(cloudDbUiCallbackListener);
        }
        return cloudDbQueyCalls;
    }
}
