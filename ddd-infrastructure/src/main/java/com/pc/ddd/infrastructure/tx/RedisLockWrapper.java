package com.pc.ddd.infrastructure.tx;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

/**
 */
@Component
public class RedisLockWrapper {


  public Boolean isLock(String key) {
    return Boolean.TRUE;
  }

  public Boolean tryLock(String key) {
    return Boolean.TRUE;
  }

  public Boolean release(String key) {
    return Boolean.TRUE;
  }

}
