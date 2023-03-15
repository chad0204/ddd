package com.pc.ddd.domain.common;

import java.util.List;
import java.util.Optional;

/**
 * 仓储接口
 * @param <I>
 * @param <E>
 */
public interface Repo<I, E> {

    Optional<E> fetchOptional(I id);

    void add(E e);

    void save(E e);

    void delete(I id);

    List<E> getAll();
}
