package com.heinoc.mobilesurvey.utils;

import com.heinoc.mobilesurvey.model.NetWorkEntity;
import com.heinoc.mobilesurvey.model.Survey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by heinoc on 14-8-10.
 */
public class JsonParser {

    private static JsonParser jsonParser = null;
    public NetWorkEntity netWorkEntity = null;

    private JsonParser() {
        netWorkEntity = NetWorkEntity.getInstance();
    }

    public static JsonParser getInstance() {
        if (jsonParser == null)
            jsonParser = new JsonParser();
        return jsonParser;
    }

    private JSONObject getJsonObjectFromResult() {
        JSONObject object = null;

        try {
            object = new JSONObject(netWorkEntity.message);

            netWorkEntity.errcode = object.getInt("error");
            netWorkEntity.errmsg = object.isNull("message") ? "" : object.getString("message");

            if (!netWorkEntity.hasError())
                return object;
        } catch (JSONException e) {
            //Json解析错误
            netWorkEntity.errcode = -1;
            netWorkEntity.errmsg = e.getMessage();

            e.printStackTrace();
        }

        return object;
    }

    public JSONArray getJsonArrayFromResult() {
        JSONArray array = null;
        JSONObject object = getJsonObjectFromResult();

        if (object != null)
            try {
                if (!object.isNull("list")) {
                    array = object.getJSONArray("list");
                    return array;
                } else {
                    netWorkEntity.errcode = 1;
                    netWorkEntity.errmsg = "已经没有更多游戏了";
                }
            } catch (JSONException e) {
                //Json解析错误
                netWorkEntity.errcode = -1;
                netWorkEntity.errmsg = e.getMessage();

                e.printStackTrace();
            }

        return array;
    }

    /**
     * 根据调用接口返回的Json串，获取结果信息
     *
     * @param message
     */
    public void getResult(String message) {
        netWorkEntity.initNetWorkEntityWithString(message);
        getJsonObjectFromResult();

    }

    /**
     * 根据调用接口返回的Json串，获取result的值
     *
     * @param message
     * @return
     */
    public String getResultWithResult(String message) {
        netWorkEntity.initNetWorkEntityWithString(message);
        String result = null;

        JSONObject object;
        try {
            object = new JSONObject(netWorkEntity.message);

            netWorkEntity.errcode = object.getInt("error");
            netWorkEntity.errmsg = object.isNull("message") ? "" : object.getString("message");
            result = object.isNull("result") ? null : object.getString("result");

        } catch (JSONException e) {
            //Json解析错误
            netWorkEntity.errcode = -1;
            netWorkEntity.errmsg = e.getMessage();

            e.printStackTrace();
        }
        return result;

    }

    /**
     * 根据调用接口返回的Json串，获取result的值
     *
     * @param message
     * @return
     */
    public String getResultWithId(String message) {
        netWorkEntity.initNetWorkEntityWithString(message);
        String id = null;

        JSONObject object;
        try {
            object = new JSONObject(netWorkEntity.message);

            netWorkEntity.errcode = object.getInt("error");
            netWorkEntity.errmsg = object.isNull("message") ? "" : object.getString("message");
            id = object.isNull("id") ? null : object.getString("id");

        } catch (JSONException e) {
            //Json解析错误
            netWorkEntity.errcode = -1;
            netWorkEntity.errmsg = e.getMessage();

            e.printStackTrace();
        }
        return id;

    }

    /**
     * 根据接口返回的json，解析查看任务列表
     *
     * @param message
     * @param surveys
     */
    public void getSurveyList(String message, List<Survey> surveys) {
        netWorkEntity.initNetWorkEntityWithString(message);

        JSONArray array = getJsonArrayFromResult();

        Survey survey;

        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                survey = new Survey();

                survey.task_id = object.getInt("task_id");
                survey.hash = object.getString("hash");
                survey.entrust = object.getString("entrust");
                survey.tel = object.getString("tel");
                survey.address = object.getString("address");
                survey.principal = object.getString("principal");
                survey.source = object.getString("source");
                survey.fSelect = object.getString("fSelect");
                survey.fftext = object.getString("fftext");
                survey.tSelect = object.getString("tSelect");
                survey.tftext = object.getString("tftext");
                survey.remark = object.getString("remark");
                survey.send_time = object.getString("send_time");
                survey.status = object.getString("status");

                surveys.add(survey);

            }
        } catch (JSONException e) {
            netWorkEntity.errcode = -2;
            netWorkEntity.errmsg = "从服务器获取的数据在转换成实体时出错；\n" + e.getMessage();

            e.printStackTrace();
        }

    }

}
