package com.certicamara.test.certicamarafibo.controller;

import com.certicamara.test.certicamarafibo.domain.Request;
import com.certicamara.test.certicamarafibo.domain.ResponseResult;
import com.certicamara.test.certicamarafibo.service.DatabaseService;
import com.certicamara.test.certicamarafibo.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("/api")
public class FibonnaciController {

    @Autowired
    DatabaseService databaseService;

    @Autowired
    FibonacciService fibonnaciService;

    @PostMapping("/result")
    public ResponseEntity<?> solveFibonnaci(@RequestBody Request number){
        if (number.getNumber()>100 || number.getNumber()<0){
            return new ResponseEntity<>("el valor debe ser menor de 100 y mayor que 0", HttpStatus.BAD_REQUEST);
        }
        ResponseResult responseResult = databaseService.getResult(number.getNumber());
        if (responseResult!=null){
            return new ResponseEntity<>(responseResult.getResult(), HttpStatus.OK);
        }
        else {
            responseResult = fibonnaciService.solveFibonnaci(number.getNumber());
            responseResult = databaseService.saveResult(responseResult);
            return new ResponseEntity<>(responseResult.getResult(), HttpStatus.CREATED);
        }

    }

}
