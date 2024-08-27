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

    // 제네릭 > 리스트의 타입 안정성 보장.
    // List<DeptVo> 리스트 타입에 DeptVo 타입의 객체만 담을 수 있음을 명시.
    // 컴파일 시점에 타입 체크가 이루어져서 잘못된 타입의 객체를 추가하려고 하면 컴파일 오류가 발생한다.
    // 즉 다른 타입의 객체를 넣으려는 시도가 있다면 컴파일러가 이를 막아준다.
    // 제네릭을 명시하지 않았다면(List) 어떤 잘못된 타입의 객체를 넣더라도 컴파일러가 이를 감지하지 못한다. > ClassCastException
    // 리스트에서 요소를 꺼낼 때 별도의 형변환이 필요하지 않다. 제네릭으로 타입이 명시되어 있어 자동으로 인식된다.
    List<DeptVo> selectDepts(DeptSearchReqDto pageRequest);

    // @Param 어노테이션
    // Mybatis와 같은 ORM 프레임워크에서 SQL 매핑 시 메소드 파라미터의 이름을 명시적으로 지정해주는 역할.
    // 이 어노테이션을 사용하는 이유는 메서드 파라미터와 SQL 쿼리에서 사용되는 파라미터 이름을 명확하게 매핑하기 위해서임. (#{deptno})
    // (@Param("deptno")를 써줌으로써 Mybatis는 deptno가 어떤 메소드 파라미터와 매핑되는지 명확하게 알 수 있다.
    DeptVo selectDept(@Param("deptno")Long deptno);

    int countDept(DeptSearchReqDto pageRequest);

    void insertDept(DeptCreateReqDto deptCreateReqDto);

    int updateDept(DeptUpdateReqDto deptUpdateReqDto);

    int deleteDept(@Param("deptno")Long deptno, @Param("deletedBy")Long deletedBy);
}

