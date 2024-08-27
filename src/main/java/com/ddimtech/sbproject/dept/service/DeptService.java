package com.ddimtech.sbproject.dept.service;

import com.ddimtech.sbproject.common.CommonResult;
import com.ddimtech.sbproject.common.vo.PageVo;
import com.ddimtech.sbproject.exception.ResourceNotFoundException;
import com.ddimtech.sbproject.dept.dto.*;
import com.ddimtech.sbproject.dept.mapper.DeptMapper;
import com.ddimtech.sbproject.dept.vo.DeptVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptService {
    private final DeptMapper deptMapper;

    /**
     * 페이징 된 dept 리스트
     *
     * @param deptSearchReqDto 사용자 질의 dto
     * @return 페이지 정보와 페이징 된 리스트
     */
    public CommonResult list(DeptSearchReqDto deptSearchReqDto) {
        // 리스트 페이지
        // 1. 리스트 추출
        List<DeptVo> deptVos = deptMapper.selectDepts(deptSearchReqDto);
        // 2. 전체 페이지 개수 추출
        int total = deptMapper.countDept(deptSearchReqDto);
        // 3. 리턴 할 페이지 정보 생성
        PageVo pageVoInfo = new PageVo(deptSearchReqDto, total);
        // 4. 1, 3를 포함한 client에게 리턴할 데이터를 생성
        // 어디다가 담을거냐? DeptListResDto
        // 빌더 패턴을 사용한 객체 생성 방법
        // DeptListResDto에 pageVoInfo와 deptVos를 넣고 객체 생성
        DeptListResDto dto = DeptListResDto.builder()
                .pageVoInfo(pageVoInfo) // 필드명() 로 접근
                .deptVos(deptVos).build();

        // 쿼리 값 CommonResult에 담아서 보내기
        // data 안에 들어있는 값은 DeptListResDto(pageVoInfo(code, message, 페이지 정보 object)와 deptVos(dept 객체 리스트)
        // CommonResult의 data 메서드 호출시 파라미터 dto를 가지고 CommonResult 객체가 생성된다. (정적 팩토리 메서드)
        // 리턴될 때 new CommonResult(CommonResultCode.SUCCESS, data)
        // CommonResult 필드 값 : code, message, object(쿼리 결과값)
        return CommonResult.data(dto);
    }

    /**
     * dept 상세 정보
     *
     * @param deptno dept deptno
     * @return 요청한 아이디에 해당하는 dept 정보
     */
    // URL의 {id} > 넘겨받음 > deptno > mapper의 selectDept문으로. id 넣고 객체하나 받아온거 vo에 담음
    public CommonResult detail(Long deptno) {
        // {id}에 따른 객체 하나 반환
        DeptVo vo = deptMapper.selectDept(deptno);

        // vo가 null일 때 예외 발생
        if (vo == null) {
            // 이 예외는 일반적으로 클라이언트가 요청한 리소스가 서버에 존재하지 않을 때 발생
            throw new ResourceNotFoundException();
        }

        // DeptDatailRedDto 객체에 vo 넣어서 객체 생성하고 dto 내보냄.
        DeptDetailResDto dto = DeptDetailResDto.builder().dept(vo).build();

        return CommonResult.data(dto);
    }


    /**
     * dept 생성
     *
     * @param deptCreateReqDto 생성 DTO
     */
    public void create(DeptCreateReqDto deptCreateReqDto) {
        deptMapper.insertDept(deptCreateReqDto);
    }


    /**
     * dept 수정
     *
     * @param deptUpdateReqDto 수정 DTO
     */
    public void update(DeptUpdateReqDto deptUpdateReqDto) {
        if (deptMapper.updateDept(deptUpdateReqDto) == 0) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * dept 삭제
     *
     * @param deptno 고유 아이디
     * @param deletedBy 삭제 한 사람 아이디
     * @return 삭제 된 데이터 수
     */
    public int delete(Long deptno, Long deletedBy) {
        return deptMapper.deleteDept(deptno, deletedBy);
    }
}

