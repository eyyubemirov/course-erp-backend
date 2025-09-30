package com.backend_tutorial.course_erp.utils;


import com.backend_tutorial.course_erp.exception.BaseException;

public class CommonUtils {

    @FunctionalInterface
    public interface Checker {
        boolean check();
    }

    public static void throwIf(Checker checker, BaseException ex) {
        if (checker.check()) {
            throw ex;
        }
    }

}
