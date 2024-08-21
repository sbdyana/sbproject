package com.ddimtech.sbproject.dept.dto;

import com.ddimtech.sbproject.common.vo.PageVo;
import com.ddimtech.sbproject.dept.vo.DeptVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@Schema(description = "Person 리스트 결과 DTO")
public class DeptListResDto {
    private PageVo pageVoInfo;
    private List<DeptVo> deptVos;
}
