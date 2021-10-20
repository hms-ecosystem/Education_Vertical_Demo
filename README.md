# Education_Vertical_Demo
# Table of Contents
  1. Introduction
  2. Prereq
  3. Help information
  4. License
  5. Bug fixed
  6. Screenshots of demo
# Introduction
This demo provides an example of an education vertical solution with integrating Huawei Ads, Video, CloudDB, Analytics, Push, Account and Auth. All course content are in the Cloud Database. The demo page can show the detail information for each course. 

The demo project uses standard Android Studio v4.2.1 and was tested on Huawei Mate30 pro phone. 
# Prereq
1. Standard Android Studio installed. 
2. Huawei developer account is ready. Click Auth Service on the navigation bar (on AGC console board) and enable authentication using an anonymous account.
3. Create a new App in AppGallery Connect with your Huawei develper ID and change the package name. Help: https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#0
4. Generating a Signing Certificate and Add fingerprint certificate to AppGallery Connect. NOTES: the files {app/pushSundy01.jks and app/pushSundy01.txt} here are only for example and you cannot use them directly. You must generate your own files to use.    Help:https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#2 https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#4
5. Configure project signature. Help: https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#7
6. Replace lines 30 to 33 and lines of the file of /Education_Vertical_Demo/blob/main/app/build.gradle with your own signature. And put your own jks file in the folder Education_Vertical_Demo/app/  to replace pushSundy01.jks. 
7. Build up a new cloud database in Huawei AGC console with your own Huawei developer ID. Make sure to use the same name in the code for creating CloudDB in CloudDBConstants.java file. You can use the template "Education-learning_CloudDB_all_tables_19.json" file to import into the database and it will save you tons of time. 
But NOTES: you must change the number of {"schemaVersion":19} for the json file based on your CloudDB version. Make sure to use the same name in the code for creating CloudDB in CloudDBConstants.java file(which is in the database folder).
You will output/generate the related files: Education_Vertical_Demo/blob/main/app/src/main/java/com/sundydemo/learning1/java/database/ObjectTypeInfoHelper.java ,  All java files in the folder of Education_Vertical_Demo/tree/main/app/src/main/java/com/sundydemo/learning1/java/database/tables/
8. One Huawei phone with developer option enabled. (non-huawei phone such as Samsung Note8 cannot show Ads well)
9. For Huawei Kits integration, configration, test,etc, please refer to below Huawei official website in part of Help information. 
# Help information
1. Video kit develop: https://developer.huawei.com/consumer/en/doc/development/Media-Guides/introduction-0000001050439577
2. Account&Auth kit develop: https://developer.huawei.com/consumer/en/hms/huawei-accountkit/
3. Ads Kit develop: https://developer.huawei.com/consumer/en/hms/huawei-adskit
4. CloudDB develop: https://developer.huawei.com/consumer/en/agconnect/cloud-base/
5. Push kit develop: https://developer.huawei.com/consumer/en/hms/huawei-pushkit/
6. Analytics kit develop: https://developer.huawei.com/consumer/en/hms/huawei-analyticskit/
# License
The demo code is licensed under the Apache License, version 2.0.
This demo codes mostly refer to the open GitHub code: https://github.com/huaweicodelabs/HMS-Learning-Application
All copyright belong to Huawei Technologies Co., Ltd
# Bugs fixed
The original demo code(https://github.com/huaweicodelabs/HMS-Learning-Application) has some bugs as below. 
1. #Bug: Too old version of Huawei CloudDB v1.2.2.301 used. 

   #Root cause: The old demo codes use Huawei CloudDB v1.2.2.301(released in 2020-10-30). Current Huawei AGC console already uses the new version and not support the old version. Please refer to below table for the differences(Left column is old version and right column is new version). 
   
    ![image](https://user-images.githubusercontent.com/57116184/135347868-054b7f1f-7843-40bf-90b6-49bf9b5b994b.png)
   
   #Solution: use AGC console and generated all latest version DB files including all files in the database/tables folder and the file of "ObjectTypeINfoHelper.java" in database folder

2. #Bug: Video failed to play.  
   #Root cause: The Player process triggered by the system initialized the database again, and the abnormal initialization caused the Player process to be interrupted.   
   #Solution: The initialization of the database can be transferred to Activity to complete. During the verification process, transferred it to SplashScreenActivity and made relevant modifications to other activities. 
   
3. #Issue: Huawei CloudDB template is not provided.  

   #Root cause: The Cloud DB has 19 tables and each table has 10+ items, but NO corresponding DB json template file for user to import!  You will have to manually create the Cloud DB with 19 tables which is boring and will take you a lot of time. 
   
   #Solution: After manually created the Cloud DB, then exported all the DB info as one JSON template file from AGC console. So developers can easily import the template file to create the cloud database to save much time and avoid mistakes. The template is "Education-learning_CloudDB_all_tables_19.json" in the root folder.  


# Screenshots of demo

![image](https://user-images.githubusercontent.com/57116184/133140568-41fdefcf-560e-4fc5-9e63-1d133fcab111.png)
![image](https://user-images.githubusercontent.com/57116184/133140593-e1586ff7-b214-4c3d-887d-da1b7ef4a23a.png)
![image](https://user-images.githubusercontent.com/57116184/133140804-d430b5fe-2f82-4416-9f34-3a31c900e051.png)
![image](https://user-images.githubusercontent.com/57116184/133140900-c88e265d-3edd-4f3d-91de-85f2fcffc540.png)
![image](https://user-images.githubusercontent.com/57116184/133140989-8f609ec2-d156-4aea-8f50-fddf245e9a90.png)
![image](https://user-images.githubusercontent.com/57116184/133141117-f3163dc2-6b4d-4cd5-856f-53bdaa5ad5fb.png)


