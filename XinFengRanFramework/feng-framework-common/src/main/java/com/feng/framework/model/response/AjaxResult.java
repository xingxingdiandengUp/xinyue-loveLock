package com.feng.framework.model.response ;


import com.feng.framework.exception.BusinessException;

import java.io.Serializable;

/**
 * @ClassName AjaxResult
 * @Author 小风谷
 * @Date 2021/3/1 21:24
 * @Version 1.0
 * @Description
 */
public class AjaxResult implements Serializable {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;

    //数据
    private Object data;
    public AjaxResult() {

    }
    //自定义返回结果的构造方法
    public AjaxResult(Boolean success,Integer code, String msg,Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //自定义异常返回的结果
    public static AjaxResult defineError(BusinessException de){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }

    //其他异常处理方法返回的结果
    public static AjaxResult otherError(ErrorEnum errorEnum){
        AjaxResult result = new AjaxResult();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
