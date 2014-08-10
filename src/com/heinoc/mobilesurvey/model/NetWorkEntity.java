package com.heinoc.mobilesurvey.model;

/**
 * Created by heinoc on 14-8-9.
 */
public class NetWorkEntity {

    private static NetWorkEntity netWorkEntity;

    /**
     * 返回码
     * -2：从服务器获取的数据在转换成实体时出错；
     * -1：Json解析出错；
     * 1：没有更多游戏了；
     */
    public int errcode;
    /**
     * 错误信息
     */
    public String errmsg;
    /**
     * 接口返回的实际有效信息
     */
    public String message;

    private NetWorkEntity(){

    }

    public static NetWorkEntity getInstance(){
        if (netWorkEntity == null)
            netWorkEntity = new NetWorkEntity();
        return netWorkEntity;
    }

    /**
     * 初始化netWrokEntity
     */
    public void initNetWorkEntity(){
        this.errcode = 0;
        this.errmsg = "";
        this.message = "";
    }

    /**
     * 初始化netWorkEntity
     * @param message 接口返回的Json串
     */
    public void initNetWorkEntityWithString(String message){
        this.errcode = 0;
        this.errmsg = "";
        this.message = message;
    }

    /**
     * 返回是否出错
     * @return
     */
    public boolean hasError(){
        return errcode != 0;
    }
}
