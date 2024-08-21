package com.ddimtech.sbproject.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {
    @Schema(description = "page number", defaultValue = "1")
    private int page=1;
    @Schema(description = "rows per page", defaultValue = "10")
    private int pageSize =10;
    @Schema(description = "정렬 property", defaultValue = " ")
    private String sort;
    @Schema(description = "정렬 방향 ASC or DESC", defaultValue = " ")
    private String orderBy;

    @Schema(hidden = true)
    public int getOffset() {
        return (page-1) * pageSize;
    }

}
