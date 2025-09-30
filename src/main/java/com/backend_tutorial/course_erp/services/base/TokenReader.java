package com.backend_tutorial.course_erp.services.base;

public interface TokenReader<T> {

      T read(String token);
}
