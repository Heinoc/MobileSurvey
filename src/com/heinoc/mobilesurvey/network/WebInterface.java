package com.heinoc.mobilesurvey.network;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * 网络接口类
 * <p/>
 * Created by heinoc on 14-8-9.
 */
public class WebInterface {
    private static WebInterface instance = null;
    private FinalHttp finalHttp = null;

    private WebInterface() {
        finalHttp = new FinalHttp();
    }

    public static WebInterface getInstance() {
        if (WebInterface.instance == null) {
            WebInterface.instance = new WebInterface();
        }

        return WebInterface.instance;
    }

    /**
     * 功能说明：
     * 获取当前用户的待查勘任务
     *
     * @param token        用户识别码
     * @param task_ids     任务id，多个用","分隔
     * @param ajaxCallBack
     */
    public void getTaskList(String token, String task_ids, AjaxCallBack<String> ajaxCallBack) {
        AjaxParams params = new AjaxParams();
        params.put("token", token);
        params.put("task_ids", task_ids);

        finalHttp.post(Domain.getTaskListUrl(), params, ajaxCallBack);

    }

    /**
     * 功能说明：
     * 获取当前用户的已查勘任务列表
     *
     * @param token        用户识别码
     * @param task_ids     任务id，多个用","分隔
     * @param ajaxCallBack
     */
    public void getCompleteTaskList(String token, String task_ids, AjaxCallBack<String> ajaxCallBack) {
        AjaxParams params = new AjaxParams();
        params.put("token", token);
        params.put("task_ids", task_ids);

        finalHttp.post(Domain.getCompleteTaskListUrl(), params, ajaxCallBack);

    }


}
