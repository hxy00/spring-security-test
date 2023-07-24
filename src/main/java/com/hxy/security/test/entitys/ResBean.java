/**
 * 文件名：ResBean.java
 * 创建日期： 2013-3-15
 * 作者：     Administrator
 * Copyright (c) 2009-2011 邮箱产品开发室
 * All rights reserved.
 * <p>
 * 修改记录：
 * 1.修改时间：2013-3-15
 * 修改人：chenjl
 * 修改内容：
 */
package com.hxy.security.test.entitys;

import java.io.Serializable;

/**
 * 功能描述：服务返回对象基类
 */
public class ResBean<T> extends BeanObject implements Serializable
{
    private static final long serialVersionUID = 257617561564691621L;
    /**
     * 成功的默认编码
     */
    public static final String OK = "OK";

    /**
     * 返回码,默认成功OK
     */
    private String code = OK;

    /**
     * 返回码描述
     */
    private String summary = "Success";

    /** 具体的返回数据，若无数据，此处填写空 */
    private T result;

    /**
     * 是否成功,默认成功
     */
    private boolean success = true;

    /**
     * 设置错误码,并标记是否成功
     *
     * @param code
     */
    public void setCode(String code)
    {
        if (OK.equals(code))
        {
            success = true;
        }
        else
        {
            success = false;
        }

        this.code = code;
    }

    public ResBean()
    {
    }

    public ResBean(String code)
    {
        this.code = code;
    }

    public ResBean(String code, String summary)
    {
        this.code = code;
        this.summary = summary;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getCode()
    {
        return code;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public String toString() {
        StringBuilder log = new StringBuilder("");
        log.append("code=").append(this.code);
        log.append("|");
        log.append("summary=").append(this.summary);
        return log.toString();
    }
}