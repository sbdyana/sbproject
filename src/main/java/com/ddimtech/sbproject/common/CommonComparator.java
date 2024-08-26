package com.ddimtech.sbproject.common;

// 객체가 비어있는지 확인하는 기능을 제공
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// java의 정규 표현식을 다루는 데 클래스
import java.util.regex.Pattern;

// 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 어노테이션이다.
// Bean 어노테이션이랑은 용도가 다르다.
// Component는 개발자가 직접 작성한 class를 Bean으로 만드는 거고 Bean은 개발자가 작성한 method를 통해 반환되는 객체를 Bean으로 만드는 것이다.
// Component 어노테이션을 사용하여 CommonComparator 클래스는 Spring의 Bean으로 등록한다.
// Spring IoC 컨테이너는 이 클래스를 스캔하여 애플리케이션의 다른 부분에서 주입(DI)할 수 있도록 관리한다.
@Component
public class CommonComparator {
    // Pattern 객체와 allowedPattern 변수
    // pattern 클래스는 java의 정규 표현식을 다루기 위한 클래스이다.
    // allowedPattern은 static으로 선언되어 있으며 이는 이 변수가 클래스 수준에서 하나만 존재함을 의미한다. 모든 인스턴스가 이 변수를 공유한다.
    // 이 변수는 SQL 인젝션과 같은 보안상의 이유로 특정 문자열 패턴을 검사하는 데 사용될 것으로 보임.
    // static : 클래스 수준에서 관리되며 이는 클래스의 모든 인스턴스가 이 필드를 공유한다는 것을 의미 따라서 클래스가 여러 번 인스턴스화되더라도 allowedPattern 필드는 하나만 존재한다.
    private static Pattern allowedPattern; // 정규 표현식 패턴을 저장하는 용도

    // spring이 이 클래스를 인스턴스화할 때 호출된다.
    public CommonComparator() {}

    //properties에 보관되어 있는 값을 가져오는 역할 (application.yml 참고하면 이해가 쉽다)
    // 이 값은 setPattern메서드의 pattern매개변수로 전달된다.
    @Value("${app.sql-injection.allowed-pattern}")
    private void setPattern(String pattern) {
        // Pattern.compile(pattern, 2);에서 compile 메서드는 정규 표현식 pattern을 pattern 객체로 컴파일한다.
        // 두 번째 인수 2는 정규 표현식의 플래그(정규표현식을 처리하는 방법을 제어)를 나타내며 이 경우 대소문자를 구분하지 않도록 하는 pattern.CASE_INSENSITIVE 플래그이다.
        // 문자열 형태의 정규 표현식을 객체로 변환
        // 2는 대소문자를 구분하지 않도록 정규 표현식을 컴파일(CASE_INSENSITIVE)
        allowedPattern = Pattern.compile(pattern, 2);
    }

    // 객체가 비어 있는지 확인
    // OjectUtils.isEmpty(object)를 호출하여 객체가 null이면 true를 반환한다.
    // 비어있냐?
    public static boolean isEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }

    // 객체가 비어 있지 않은지 확인
    // OjectUtils.isNotEmpty(object)를 호출하여 객체가 null이 아니고 비어 있지 않으면 true를 반환한다.
    // 차있냐?
    public static boolean isNotEmpty(Object object) {
        return ObjectUtils.isNotEmpty(object);
    }

    // 가변 인수(Object ...args)로 전달된 모든 객체가 비어 있지 않은지 확인한다.
    // 하나라도 비어 있으면 false를 반환하고 모두 비어 있지 않으면 true를 반환한다.
    // 다 차있냐?
    public static boolean isNotEmpty(Object ...args) {
        // 이 부분이 없어도 되지 않나?
        // 명시적으로 args 배열이 비어 있을 때 false를 반환하도록 만들어진 것 > 성능 최적화와 코드 가독성 측면에서 이점
        // args 배열이 비어 있는 경우 바로 false를 반환 > 불필요한 'for' 루프 진입을 방지한다. 배열의 크기가 매우 클 때 성능적으로 이점으로 작용할 수 있다.
        if (args.length == 0) return false; // 배열 없으면 걍 false . 그냥 공백이라는 거니깐. Empty인거임. 그러니깐 false 반환.

        // args.length가 0이 아닐 때
        for (Object arg : args) {
            if(ObjectUtils.isEmpty(arg)) {
                // 비어 있으면 즉 공백이 있으면 false = 공백이라는 거니깐 = Empty = false
                return false;
            }
        }
        return true;
    }

    // 공백인지
    public static boolean isEmptyForDynamicSql(Object object) {
        // 공백이면 returnVal = true 반환, 비어 있지 않으면 false
        boolean returnVal = ObjectUtils.isEmpty(object);
        // object가 비어 있지 않고(false) object가 String의 인스턴스일 때 (string 타입인지 검사)
        if (!returnVal && object instanceof String) {
            // object를 String으로 변환
            String str = (String)object;

            // 이 패턴은 주어진 문자열이 SQL 인젝션을 방지하기 위해 허용된 패턴과 일치하는지를 검사하는 데 사용
            // allowedPattern의 패턴과 str이 일치하지 않으면 true를 반환
            // 일치하면 false 반환
            // 패턴에 맞지 않는 입력을 걸러내는 기능
            return !allowedPattern.matcher(str).matches();
        } else {
            // object가 비어 있거나 문자열이 아닌 경우 초기값인 returnVal 반환
            return returnVal;
        }
    }

    public static boolean isNotEmptyForDynamicSql(Object object) {
        // 공백이 아니면 returnVal = true 반환, 비어 있으면 false
        boolean returnVal = ObjectUtils.isNotEmpty(object);

        // object가 비어있지 않고 object가 String의 인스턴스 일 때 (String 타입인지 검사)
        if (returnVal && object instanceof String) {
            // object를 String으로 변환
            String str = (String)object;

            // allowedPattern의 패턴과 str이 일치하지 않으면 true
            // 일치하면 false
            return !allowedPattern.matcher(str).matches();
        } else {
            // object가 비어 있거나 문자열이 아닌 경우 초기값인 returnVal 변환
            return returnVal;
        }
    }

    // 공백인지
    public static boolean isEmptyForDynamicSql(Object ...args) {
        if (args == null) return true;

        for (Object arg : args) {
            if (isEmptyForDynamicSql(arg)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmptyForDynamicSql(Object ...args) {
        if (args == null || args.length == 0) return false;

        // 이 부분 심화 이해를 돕기 위해서 | 만약 정규식 패턴에 맞지 않는 값이 입력될 시
        // isEmptyForDynamicSql에서 패턴 일치문에서 return값으면 true 값을 내뱉을 거임.
        // 원래 이상없으면 true 반전값으로 false를 반환하겠지만 이상이 있으면 false로 반전값인 true 값을 뱉을거기 때문에
        // 패턴 이상으로 true를 내뱉으면 아래 if문이 true로 활성화되어 refurn false로 현재 isNotEmptyForDynamicSql가 false로 <if> 태그 작동안할거임.
        // 내가 생각한 바로는 정규식 패턴 일치로 통과 true인 줄 알았는데 아닌걸 쳐내서 false로 내뱉는 방식.
        for (Object arg : args) {
            if (isEmptyForDynamicSql(arg)) {
                return false;
            }
        }
        return true;
    }

}
