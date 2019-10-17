package com.certicamara.test.certicamarafibo.service;

import com.certicamara.test.certicamarafibo.domain.ResponseResult;

public interface DatabaseService {

    ResponseResult saveResult(ResponseResult responseResult);

    ResponseResult getResult(int number);
}
