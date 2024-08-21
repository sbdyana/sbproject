package com.ddimtech.sbproject.dept.dto;

import com.ddimtech.sbproject.common.dto.PageRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Dept 리스트 요청 DTO")
public class DeptSearchReqDto extends PageRequestDto {
    @Schema(description = "filter 조건 name", defaultValue = " ")
    private String dname;
    @Schema(description = "filter 조건 loc", defaultValue = " ")
    private String loc;
}
