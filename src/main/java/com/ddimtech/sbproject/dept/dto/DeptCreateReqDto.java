package com.ddimtech.sbproject.dept.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Schema(description = "Dept 생성 요청 DTO")
public class DeptCreateReqDto {
    @NotBlank
    @Length(min = 1, max = 20, message = "최소 길이 1, 최대 길이 20")
    @Schema(description = "부서명", defaultValue = " ")
    private String dname;

    @NotBlank
    @Length(min = 1, max = 20, message = "최소 길이 1, 최대 길이 20")
    @Schema(description = "위치")
    private String loc;
}
