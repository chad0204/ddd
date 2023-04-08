package com.pc.ddd.application.execute.cmd;


import com.pc.ddd.api.dto.Result;
import com.pc.ddd.api.dto.cmd.CMD;
import com.pc.ddd.common.util.IExecutor;
import com.pc.ddd.infrastructure.tx.RedisLockWrapper;
import com.pc.ddd.infrastructure.tx.TransactionWrapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 这里可以使用ioc容器简化代码, 通过cmd请求名找到exe
 * @param <REQ>
 */
public abstract class AbstractCmdExe<REQ extends CMD, RSP> implements IExecutor<REQ, Result<RSP>> {

    @Autowired
    protected TransactionWrapper transactionWrapper;
    @Autowired
    protected RedisLockWrapper redisLockWrapper;


    public final Result<RSP> execute(REQ cmd) {
        //事务控制、持久化什么的
        RSP rsp = doExecute(cmd);
        return Result.of(rsp);
    }

    public abstract RSP doExecute(REQ cmd);



}
