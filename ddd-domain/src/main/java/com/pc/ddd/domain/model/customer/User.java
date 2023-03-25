package com.pc.ddd.domain.model.customer;

import com.pc.ddd.domain.model.business.Business;
import lombok.Data;

import java.util.Map;

/**
 *
 * @author pengchao
 * @since 2023/3/20 17:56
 */
@Data
public class User {

    private Long id;

    private Long ssoId;

    private String empId;

    private Business business;

    //转移操作, 当前商机置为无效 并创建新商机
    public void transfer(String sourceEmpId, String targetEmpId) {
        empId = targetEmpId;

        business.setBusinessStatus("1");
        business.setEndReason("");

        //商机置为无效
        //异步创建新商机
        //记录操作日志

    }




    public void pickup(String empId) {

    }


}
