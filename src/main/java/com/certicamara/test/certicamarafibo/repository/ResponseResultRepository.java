package com.certicamara.test.certicamarafibo.repository;

import com.certicamara.test.certicamarafibo.domain.ResponseResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseResultRepository extends JpaRepository<ResponseResult, Long> {

    ResponseResult findByNumber(int number);
}
