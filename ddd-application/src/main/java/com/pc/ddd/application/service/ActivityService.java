package com.pc.ddd.application.service;

import com.pc.ddd.api.dto.Result;
import com.pc.ddd.api.dto.cmd.ActivityCreateCmd;
import com.pc.ddd.api.dto.qry.ActivityPageQry;
import com.pc.ddd.common.util.IExecutorClient;
import com.pc.ddd.domain.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityService {

    private final IExecutorClient executorClient;

    @Autowired
    public ActivityService(IExecutorClient tptClient) {
        this.executorClient = tptClient;
    }

    public Result<Boolean> createActivity(ActivityCreateCmd cmd) {
        return executorClient.execute(cmd);
    }

    public Result<Boolean> updateActivity(ActivityCreateCmd cmd) {
        return executorClient.execute(cmd);
    }

    public Result<OrderItem> page(ActivityPageQry qry) {
        return executorClient.execute(qry);
    }


}
