package com.pc.ddd.infrastructure.reposiroty;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pc.ddd.api.dto.response.PageDTO;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MyBatisRepo<ID, BO, DO> {

    protected BaseMapper<DO> mapper;

    public MyBatisRepo(BaseMapper<DO> mapper) {
        this.mapper = mapper;
    }

    final List<BO> toBOList(List<DO> records) {
        return records.stream().map(this::toBO).collect(Collectors.toList());
    }

    abstract BO toBO(DO record);

    abstract DO toDO(BO bo);

    public PageDTO<BO> selectPage(Integer pageNumber, Integer pageSize, QueryWrapper<DO> queryWrapper) {
        Page<DO> page = new Page<>(pageNumber, pageSize);
        Page<DO> result = mapper.selectPage(page, queryWrapper);

         return PageDTO.<BO>builder()
                .pageNumber(result.getCurrent())
                .pageSize(result.getSize())
                .itemsTotal(result.getTotal())
                .items(toBOList(result.getRecords()))
                .build();
    }

    public void in(QueryWrapper<DO> wrapper, String column, Collection<?> columnValues) {
        if(CollectionUtils.isEmpty(columnValues)) {
            wrapper.eq("id", -1); // 模拟为假的情况, id 一直大于0
        } else {
            wrapper.in(column, columnValues);
        }
    }
}
