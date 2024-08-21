package com.ddimtech.sbproject.dept.mapper;

import com.ddimtech.sbproject.dept.dto.DeptCreateReqDto;
import com.ddimtech.sbproject.dept.dto.DeptSearchReqDto;
import com.ddimtech.sbproject.dept.dto.DeptUpdateReqDto;
import com.ddimtech.sbproject.dept.vo.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * myBatis에서 사용하는 interface로 쿼리가 저장된 xml 파일과 1:1 매핑 됨
 * 본 DeptMapper는 sample_dept.xml 과 매핑 됨
 */
@Mapper
public interface DeptMapper {

    List<DeptVo> selectDepts(DeptSearchReqDto pageRequest);

    DeptVo selectDept(@Param("deptno")Long deptno);

    int countDept(DeptSearchReqDto pageRequest);

    void insertDept(DeptCreateReqDto deptCreateReqDto);

    int updateDept(DeptUpdateReqDto deptUpdateReqDto);

    int deleteDept(@Param("deptno")Long deptno, @Param("deletedBy")Long deletedBy);
}

