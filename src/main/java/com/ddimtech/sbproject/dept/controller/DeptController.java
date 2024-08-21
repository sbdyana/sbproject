package com.ddimtech.sbproject.dept.controller;

import com.ddimtech.sbproject.common.CommonResult;
import com.ddimtech.sbproject.exception.ApiBindException;
import com.ddimtech.sbproject.exception.ResourceNotFoundException;
import com.ddimtech.sbproject.dept.dto.DeptCreateReqDto;
import com.ddimtech.sbproject.dept.dto.DeptSearchReqDto;
import com.ddimtech.sbproject.dept.dto.DeptUpdateReqDto;
import com.ddimtech.sbproject.dept.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// rest용 controller로 설정
@RestController
// 이 클래스의 공통 prefix uri 설정
@RequestMapping("sample/dept")
// swagger 에 표시 될 설명
@Tag(name = "Dept", description = "Dept API")
// private final 로 선언된 object를 autowire 함
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @GetMapping
    @Operation(summary = "dept 리스트")
    public CommonResult list(DeptSearchReqDto deptSearchReqDto) {
        return deptService.list(deptSearchReqDto);
    }

    @GetMapping("{id}")
    @Operation(summary = "dept 개별")
    public CommonResult detail(@PathVariable("id") Long id) {
        return deptService.detail(id);
    }

    @PostMapping("create")
    @Operation(summary = "dept 생성")
    public CommonResult create(@RequestBody @Valid DeptCreateReqDto deptCreateReqDto,
                               BindingResult bindingResult) throws ApiBindException {

        if (bindingResult.hasErrors()) {
            throw new ApiBindException(bindingResult);
        }
        deptService.create(deptCreateReqDto);
        return CommonResult.ok();
    }

    @PostMapping("update")
    @Operation(summary = "dept 수정")
    public CommonResult update(@RequestBody @Valid DeptUpdateReqDto deptUpdateReqDto,
                               BindingResult bindingResult) throws ApiBindException  {
        if (bindingResult.hasErrors()) {
            throw new ApiBindException(bindingResult);
        }

        deptService.update(deptUpdateReqDto);
        return CommonResult.ok();
    }

    @PostMapping("delete")
    @Operation(summary = "dept 삭제")
    public CommonResult delete(@RequestParam("id") Long id) {

        if (deptService.delete(id, 1L) == 0) {
            throw new ResourceNotFoundException();
        }
        return CommonResult.ok();
    }


}

