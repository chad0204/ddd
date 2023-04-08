package com.pc.ddd.application.execute.cmd;


import com.pc.ddd.api.dto.Result;
import com.pc.ddd.api.dto.qry.QRY;

import com.pc.ddd.common.util.IExecutor;
import lombok.extern.slf4j.Slf4j;


/**
 *
 * @param <REQ>
 * @param <RSP>
 */
@Slf4j
public abstract class AbstractQryExe<REQ extends QRY, RSP> implements IExecutor<REQ, Result<RSP>> {

    public final Result<RSP> execute(REQ req) {
        RSP rsp = doExecute(req);
        log.info("{}", rsp);
        return Result.of(rsp);
    }

    public abstract RSP doExecute(REQ req);
}
