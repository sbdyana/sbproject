package com.ddimtech.sbproject.common.vo;

import com.ddimtech.sbproject.common.dto.PageRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class PageVo {
    @Schema(description = "page number")
    private int page;
    @Schema(description = "rows per page")
    private int pageSize;
    @Schema(description = "total count")
    private int total;
    @Schema(description = "total page count")
    private int totalPages;

    public PageVo(int page, int pageSize, int total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPages = (int) Math.ceil((double) total / (double) pageSize);
    }

    public PageVo(PageRequestDto pageRequestDto, int total) {
        this.page = pageRequestDto.getPage();
        this.pageSize = pageRequestDto.getPageSize();
        this.total = total;
        this.totalPages = total == 0 ? 0 : (int) Math.ceil((double) total / (double) pageSize);
    }
}
