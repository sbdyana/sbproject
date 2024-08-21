package com.ddimtech.sbproject.common;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CommonComparator {
    private static Pattern allowedPattern;

    public CommonComparator() {}

    @Value("${app.sql-injection.allowed-pattern}")
    private void setPattern(String pattern) {
        allowedPattern = Pattern.compile(pattern, 2);
    }

    public static boolean isEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }

    public static boolean isNotEmpty(Object object) {
        return ObjectUtils.isNotEmpty(object);
    }

    public static boolean isNotEmpty(Object ...args) {
        if (args.length == 0) return false;

        for (Object arg : args) {
            if(ObjectUtils.isEmpty(arg)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyForDynamicSql(Object object) {
        boolean returnVal = ObjectUtils.isEmpty(object);
        if (!returnVal && object instanceof String) {
            String str = (String)object;
            return !allowedPattern.matcher(str).matches();
        } else {
            return returnVal;
        }
    }

    public static boolean isNotEmptyForDynamicSql(Object object) {
        boolean returnVal = ObjectUtils.isNotEmpty(object);
        if (returnVal && object instanceof String) {
            String str = (String)object;
            return !allowedPattern.matcher(str).matches();
        } else {
            return returnVal;
        }
    }

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

        for (Object arg : args) {
            if (isEmptyForDynamicSql(arg)) {
                return false;
            }
        }
        return true;
    }

}
