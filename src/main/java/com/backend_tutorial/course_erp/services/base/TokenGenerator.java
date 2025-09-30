package com.backend_tutorial.course_erp.services.base;

public interface TokenGenerator<T> {

    String generator(T obj);

}
