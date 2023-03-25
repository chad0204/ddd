package com.pc.ddd.application.execute.cmd;


import com.pc.ddd.api.dto.cmd.CMD;

/**
 * 这里可以使用ioc容器简化代码, 通过cmd请求名找到exe
 * @param <T>
 */
public abstract class AbstractCmdExe<T extends CMD> {

    public final void execute(T cmd) {
        //事务控制、持久化什么的

        doExecute(cmd);
    }

    public abstract Boolean doExecute(T cmd);
}
