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
// 특정 uri로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지를 정의한다.
// ResponseBody를 포함한다.
@RestController

// 이 클래스의 공통 prefix uri 설정
@RequestMapping("sample/dept")

// swagger 에 표시 될 설명
// 어노테이션은 API 엔드포인트에 태그를 할당하여 관련된 엔드포인트를 그룹화하고 문서에서 카테고리를 형성하는 데 사용된다. 따라서 주로 @RestController가 붙어있는 클래스에 사용된다.
@Tag(name = "Dept", description = "Dept API")

// private final 로 선언된 object를 autowire 함
// 새로운 필드를 추가할 때 다시 생성자를 만들어서 관리해야하는 번거로움을 없애준다. (@Autowired를 사용하지 않고 의존성 주입)
@RequiredArgsConstructor
public class DeptController {

    // service에서 비즈니스 로직 처리
    // Controller는 Service에 의존한다. service는 생성자를 통해 주입 된다.
    // Controller는 HTTP 요청 처리와 응답 생성에 집중하고 실제 사용자 조회 로직은 Service에 위임한다.
    private final DeptService deptService;

    @GetMapping
    // API 엔드포인트의 작업에 대한 설명을 추가하고 세부 정보를 제공하는 데 사용된다. 주로 @RestController 클래스 내부의 메서드에 사용된다.
    // summary를 통해 작업의 요약, description을 통해 작업의 구체적인 설명을 작성할 수 있다. 작업에 대한 정보를 명시적으로 제공함으로 API 문서의 가독성과 이해도를 향상할 수 있다.
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

