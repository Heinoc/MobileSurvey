package com.heinoc.mobilesurvey.network;


import com.heinoc.mobilesurvey.utils.Constants;

/**
 * Created by heinoc on 14-8-9.
 */
public class Domain {

    /**
     * 功能说明：
     * 获取当前用户的待查勘任务
     * @return
     */
    public static String getTaskListUrl(){
        return Constants.URL_ADDRESS + "/api/getTaskList";
    }

    /**
     * 功能说明：
     * 获取当前用户的已查勘任务列表
     * @return
     */
    public static String getCompleteTaskListUrl(){
        return Constants.URL_ADDRESS + "/api/getCompleteTaskList";
    }

}
