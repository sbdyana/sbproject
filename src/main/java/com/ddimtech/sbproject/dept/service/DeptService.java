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
        DeptListResDto dto = DeptListResDto.builder()
                .pageVoInfo(pageVoInfo)
                .deptVos(deptVos).build();

        return CommonResult.data(dto);
    }

    /**
     * dept 상세 정보
     *
     * @param deptno dept deptno
     * @return 요청한 아이디에 해당하는 dept 정보
     */
    public CommonResult detail(Long deptno) {
        DeptVo vo = deptMapper.selectDept(deptno);

        if (vo == null) {
            throw new ResourceNotFoundException();
        }

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

