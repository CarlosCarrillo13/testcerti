package com.certicamara.test.certicamarafibo.service;

import com.certicamara.test.certicamarafibo.domain.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IFibonnaciService implements FibonacciService {

    @Override
    public ResponseResult solveFibonnaci(int number) {

        List<Integer> numberResponse = solveRecursive(number, new ArrayList<>());

        return mapSolution(number, numberResponse);
    }

    private ResponseResult mapSolution(int number, List<Integer> numberResponse) {

        return ResponseResult.builder()
                .number(number)
                .result(transformToString(numberResponse))
                .build();
    }

    private String transformToString(List<Integer> numberResponse) {
        StringBuffer buffer = new StringBuffer("");
        for (int i : numberResponse) {
            buffer.append(i + " ");
        }
        return buffer.toString();
    }

    private List<Integer> solveRecursive(int number, ArrayList<Integer> list) {

        int a = 0;
        int b = 1;
        int temp;
        list.add(b);

        while (a + b <= number) {
            temp = a;
            a = b;
            b = temp + a;
            list.add(b);
        }
        return list;
    }
}
