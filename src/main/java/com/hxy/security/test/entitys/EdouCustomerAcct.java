package com.hxy.security.test.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("EDOU_CUSTOMER_ACCT")
public class EdouCustomerAcct {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("ACCT_CODE")
    private String acctCode;

    @TableField("PHONE")
    private String phone;

    @TableField("NAME")
    private String name;

    @TableField("PHOTO")
    private String photo;

    @TableField("OPEN_ID")
    private String openId;

    @TableField("EDOU_NUM")
    private Integer edouNum;

    @TableField("STATUS")
    private Integer status;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("UPDATE_TIME")
    private Date updateTime;

    @TableField("PHONE_UPDATE_TIME")
    private Date phoneUpdateTime;

}
