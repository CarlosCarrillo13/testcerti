package com.certicamara.test.certicamarafibo.service;

import com.certicamara.test.certicamarafibo.domain.ResponseResult;
import com.certicamara.test.certicamarafibo.repository.ResponseResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDatabaseService implements DatabaseService {

    @Autowired
    ResponseResultRepository responseResultRepository;

    @Override
    public ResponseResult saveResult(ResponseResult responseResult) {
        return responseResultRepository.save(responseResult);
    }

    @Override
    public ResponseResult getResult(int number) {
        return responseResultRepository.findByNumber(number);
    }
}
