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

    // Service List에서 호출
    public PageVo(PageRequestDto pageRequestDto, int total) {
        // 요청값 page
        this.page = pageRequestDto.getPage();
        // 요청값 pageSize
        this.pageSize = pageRequestDto.getPageSize();
        // list 전체값
        this.total = total;
        //total 0이면 > 0 / 0이 아니면 있다는 거니깐 전체를 / 페이지 퍼로 나누기
        this.totalPages = total == 0 ? 0 : (int) Math.ceil((double) total / (double) pageSize);
    }
}
