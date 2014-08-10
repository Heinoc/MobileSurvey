package com.heinoc.mobilesurvey.model;

/**
 * 查勘实体
 *
 * Created by heinoc on 14-8-10.
 */
public class Survey {

    public int id;

    /**
     * 任务id
     */
    public int task_id;
    /**
     * 任务hash
     */
    public String hash;
    /**
     * 委托方
     */
    public String entrust;
    /**
     * 委托方电话
     */
    public String tel;
    /**
     * 委托方地址
     */
    public String address;
    /**
     * 项目负责人
     */
    public String principal;
    /**
     * 信息来源
     */
    public String source;
    /**
     * 房产主查勘人
     */
    public String fSelect;
    /**
     * 房产副查勘人
     */
    public String fftext;
    /**
     * 土地主查勘人
     */
    public String tSelect;
    /**
     * 土地副查勘人
     */
    public String tftext;
    /**
     * 备注
     */
    public String remark;
    /**
     * 派单时间
     */
    public String send_time;
    /**
     * 任务状态
     */
    public String status;

    public Survey() {
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getEntrust() {
        return entrust;
    }

    public void setEntrust(String entrust) {
        this.entrust = entrust;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getfSelect() {
        return fSelect;
    }

    public void setfSelect(String fSelect) {
        this.fSelect = fSelect;
    }

    public String getFftext() {
        return fftext;
    }

    public void setFftext(String fftext) {
        this.fftext = fftext;
    }

    public String gettSelect() {
        return tSelect;
    }

    public void settSelect(String tSelect) {
        this.tSelect = tSelect;
    }

    public String getTftext() {
        return tftext;
    }

    public void setTftext(String tftext) {
        this.tftext = tftext;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
