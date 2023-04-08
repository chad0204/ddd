package com.pc.ddd.infrastructure.tx;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

/**
 */
@Component
public class TransactionWrapper {

  @Transactional(rollbackFor = Throwable.class, isolation = Isolation.REPEATABLE_READ)
  public void runRepeatableRead(Runnable runnable) {
    runnable.run();
  }

  @Transactional(rollbackFor = Throwable.class, isolation = Isolation.REPEATABLE_READ)
  public <T> T callRepeatableRead(Supplier<T> callee) {
    return callee.get();
  }
}
