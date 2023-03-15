package com.pc.ddd.api.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 通用的dto
 * @param <T>
 */
@Data
@Builder
public class PageDTO<T> {

    private long pageSize;
    private long pageNumber;
    private long itemsTotal;
    private List<T> items;

    public <DTO> PageDTO<DTO> toDTO(Function<T, DTO> function) {
        List<DTO> list = this.getItems().stream().map(function).collect(Collectors.toList());
        return PageDTO.<DTO>builder()
                .pageSize(this.getPageSize())
                .pageNumber(this.getPageNumber())
                .itemsTotal(this.getItemsTotal())
                .items(list)
                .build();
    }
}
