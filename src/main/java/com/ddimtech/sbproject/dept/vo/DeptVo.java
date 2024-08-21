package com.ddimtech.sbproject.dept.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "Dept")
public class DeptVo {
    @Schema(description = "부서 아이디")
    private Long deptno;
    @Schema(description = "부서명")
    private String dname;
    @Schema(description = "위치")
    private String loc;
    @Schema(description = "생성자 아이디")
    private Long createdBy;
    @Schema(description = "생성일")
    private LocalDateTime createdAt;
    @Schema(description = "수정자 아이디")
    private Long updatedBy;
    @Schema(description = "수정일")
    private LocalDateTime updatedAt;
}
