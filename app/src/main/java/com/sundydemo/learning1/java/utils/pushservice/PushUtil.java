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

package com.sundydemo.learning1.java.utils.pushservice;

import android.content.Context;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.sundydemo.learning1.java.utils.video.Constants;

/**
 * @since 2020
 * @author Huawei DTSE India
 */
public class PushUtil {
    /**
     * Gets token.
     *
     * @param context the context
     */

    public static void getToken(Context context) {
        new Thread() {
            @Override
            public void run() {
                String appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                try {
                    Constants.PUSH_TOKEN = HmsInstanceId.getInstance(context).getToken(appId, "HCM");
                } catch (ApiException exp) {
                }
            }
        }.start();
    }
}
