package com.pc.ddd.application.execute.cmd;

import com.pc.ddd.api.dto.Result;
import com.pc.ddd.api.dto.cmd.ActivityCreateCmd;

import java.util.function.Supplier;

public class ActivityCreateCmdExecute extends AbstractCmdExe<ActivityCreateCmd, Result<Boolean>> {


    @Override
    public Result<Boolean> doExecute(ActivityCreateCmd cmd) {


        redisLockWrapper.tryLock("");


        //异步
        transactionWrapper.runRepeatableRead(new Runnable() {
            @Override
            public void run() {

            }
        });

        //同步
        return transactionWrapper.callRepeatableRead(new Supplier<Result<Boolean>>() {
            @Override
            public Result<Boolean> get() {
                return null;
            }
        });
    }


    @Override
    public boolean isDisabled() {
        return false;
    }
}
