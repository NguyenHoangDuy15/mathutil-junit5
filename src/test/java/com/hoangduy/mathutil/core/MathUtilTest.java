/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.hoangduy.mathutil.core;

import static com.hoangduy.mathutil.core.MathUtil.getFactorial;
//import static la danh cho static
//goi ham ma bo qua ten class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author DELL
 */
public class MathUtilTest {
    
    // chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào ctrong lệnh kiểm thử
    public static Object[][] initData() {
        return new Integer[][]{
                            {1, 1},
                            {2, 2},
                            {3, 6},
                            {4, 24},
                            {5, 120}
                        };
    }
    
    
    @ParameterizedTest
    @MethodSource(value = "initData")// tên hàm cung cấp data
                                   // các phần tử cửa mảng map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    // bắt ngoại lệ khi đưa data sai

    @Test
    public void testGetFactorialGivenWrongArgReturnsWell() {
        // xài biểu thức lambda
        // hàm nhận tham số t2 là 1 cái object có code implement cái
        //functional interface tên là Excutable - có 1 hàm duy nhất không code
        //tên là excute()
        //chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
        //Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
