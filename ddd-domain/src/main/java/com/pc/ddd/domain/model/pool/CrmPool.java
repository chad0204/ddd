package com.pc.ddd.domain.model.pool;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
    * 公海成员表
    */
@Data
public class CrmPool implements Serializable {
    /**
    * 主键
    */
    private String id;

    /**
    * 公海id
    */
    private String poolId;

    /**
    * 0: 成员, 1: 管理员 
    */
    private String ruleType;

    /**
    * 员工id
    */
    private String employeeId;

    /**
    * 0 正常 1 删除
    */
    private Integer isDeleted;

    /**
    * 创建人id
    */
    private String creatorId;

    /**
    * 修改人id
    */
    private String modifierId;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}