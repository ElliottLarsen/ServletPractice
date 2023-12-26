package org.zerock.w1.calc.service;

import org.zerock.w1.calc.dto.CalcDTO;
public enum CalcService {

    INSTANCE;

    public CalcDTO calculate(CalcDTO calcDTO) {

        int num1 = calcDTO.getNum1();
        int num2 = calcDTO.getNum2();
        int result = num1 + num2;
        calcDTO.setResult(result);

        return calcDTO;
    }

}
