package com.ddimtech.sbproject.dept.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Schema(description = "Person 업데이트 요청 DTO")
public class DeptUpdateReqDto {
    @Schema(description = "아이디")
    @NotNull
    private Long deptno;

    @Schema(description = "부서명")
    @Length(min = 1, max = 20, message = "최소 길이 1, 최대 길이 20")
    private String dname;

    @Schema(description = "위치")
    @Length(min = 1, max = 20, message = "최소 길이 1, 최대 길이 20")
    private String loc;

    @JsonIgnore
    @AssertTrue(message = "최소 하나 이상의 property가 필요합니다")
    public boolean isValidImage() {
        return !StringUtils.isBlank(this.dname) && this.loc != null;
    }

    @JsonIgnore
    private Long updatedBy;

}

