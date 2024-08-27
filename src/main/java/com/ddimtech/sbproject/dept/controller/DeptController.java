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
    // @PathVariable은 1개의 데이터만 받아올 수 있다.
    // URL 경로의 일부를 메소드 파라미터에 매핑할 때 사용된다.
    // URL에서 {id} 값 가져와서 detail 메소드로
    public CommonResult detail(@PathVariable("id") Long id) {
        return deptService.detail(id);
    }

    @PostMapping("create")
    @Operation(summary = "dept 생성")
    // @RequestBody 어노테이션은 HTTP 요청의 본문(body)을 Java 객체로 변환하는 데 사용된다. body에서 내용 받아서 create 해야함
    // @Valid 데이터의 유효성을 검사하는 데 도움을 주는 어노테이션으로 @RequestBody와 함께 쓰일 때 클라이언트로부터 전달받은 JSON 데이터가 특정 조건을 만족시키는지 확인하는 데 사용된다.
    public CommonResult create(@RequestBody @Valid DeptCreateReqDto deptCreateReqDto,
                               BindingResult bindingResult) throws ApiBindException { // bindingResult객체는 @Valid 어노테이션에 의해 수행된 유효성 검사 결과를 담고 있다.

        if (bindingResult.hasErrors()) { // 유효성 검사결과가 true 면 에러 처리
            throw new ApiBindException(bindingResult);
        }
        // 유효성 검사 통과 후 Service의 create 로
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
    // @RequestParam은 여러개의 데이터를 받아올 수 있다.
    // @RequestParam은 Get/Post 방식으로 uri를 이용하거나, ajax 요청을 통해 body에 담아온 데이터를 여러 타입으로 받을 수 있다.
    // 보안이 필요한 회원가입등의 작업을 할 때도 RequestParam 방식이 필요하다.
    public CommonResult delete(@RequestParam("id") Long id) {

        if (deptService.delete(id, 1L) == 0) {
            throw new ResourceNotFoundException();
        }
        return CommonResult.ok();
    }


}

