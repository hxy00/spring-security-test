/**
 * Project Name: data-platform
 * File Name: ResultCode
 * Package Name: com.sed.data.platform.gateway.constant
 * Date: 2021/6/25 4:25 下午
 * Copyright (c) 2021,All Rights Reserved.
 */
package com.hxy.security.test.enums;

/**
 * @Description: 枚举了一些常用API操作码
 * @Author: aymin
 * @Date: 2021/06/25
 * @Copyright (c) 2019-2023 深圳桑达商用机器有限公司,All Rights Reserved.
 * @Since: 1.0.0
 */
public enum ResultCode {
    SUCCESS(0, "操作成功"),
    FAILED(500, "系统异常"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    EXISTS(10000, "数据已存在"),
    NOT_EXISTS(10001, "数据不存在"),
    PARAM_IS_NULL(10002, "参数为空"),
    ILLEGAL_REQ(10003, "非法请求"),
    NEED_IDENTIFY(10004, "该次兑换需要人脸识别"),

    RED_PACKET_NOT_EXISTS(20001, "红包不存在"),
    RED_PACKET_IS_OWN(20002, "不能领取自己发送的红包"),
    RED_PACKET_ALREADY_RECEIVED(20003, "来晚啦，红包已被领取"),
    RED_PACKET_HAVE_EXPIRED(20004, "来晚啦，红包已过期"),
    RED_PACKET_MANUAL_REVOCATION(20005, "红包已手动撤回"),
    RED_PACKET_AUTO_REVOCATION(20006, "红包已自动撤回"),
    RED_PACKET_RECEIVER_CSI_PHONE_ISNULL(20007, "尚未绑定e豆账户"),
    RED_PACKET_RECEIVER_IS_GREY(20008, "不允许业务营销关联人领取e豆"),
    RED_PACKET_IS_NOT_OWN(20009, "不能撤回别人发送的红包"),

    GIVE_OUT_RECEIVE_SUCCESS(30001, "发放已成功领取"),
    ;

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
