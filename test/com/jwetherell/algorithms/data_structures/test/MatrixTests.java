package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import com.jwetherell.algorithms.CoverageMeasurer;
import com.jwetherell.algorithms.data_structures.Matrix;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;


public class MatrixTests {

    @Test
    public void testMatrix() {
        CoverageMeasurer.setup(10);
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(3, 2);
        matrix2.set(0, 0, 12);
        matrix2.set(0, 1, 25);
        matrix2.set(1, 0, 9);
        matrix2.set(1, 1, 10);
        matrix2.set(2, 0, 8);
        matrix2.set(2, 1, 5);

        // Result of multiplication
        Integer[][] array1 = new Integer[][]{{273,455},
                                             {243,235},
                                             {244,205},
                                             {102,160}};
        Matrix<Integer> result1 = new Matrix<Integer>(4,2,array1);

        Matrix<Integer> matrix3 = matrix1.multiply(matrix2);
        assertTrue("Matrix multiplication error. matrix3="+matrix3+" result1"+result1, matrix3.equals(result1));

        int rows = 2;
        int cols = 2;
        int counter = 0;
        Matrix<Integer> matrix4 = new Matrix<Integer>(rows, cols);
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix4.set(r, c, counter++);

        // Result of subtraction
        Integer[][] array2 = new Integer[][]{{0,0},
                                             {0,0}};
        Matrix<Integer> result2 = new Matrix<Integer>(2,2,array2);

        Matrix<Integer> matrix5 = matrix4.subtract(matrix4);
        assertTrue("Matrix subtraction error. matrix5="+matrix5+" result2"+result2, matrix5.equals(result2));

        // Result of addition
        Integer[][] array3 = new Integer[][]{{0,2},
                                             {4,6}};
        Matrix<Integer> result3 = new Matrix<Integer>(2,2,array3);

        Matrix<Integer> matrix6 = matrix4.add(matrix4);
        assertTrue("Matrix addition error. matrix6="+matrix6+" result3"+result3, matrix6.equals(result3));

        Matrix<Integer> matrix7 = new Matrix<Integer>(2, 2);
        matrix7.set(0, 0, 1);
        matrix7.set(0, 1, 2);
        matrix7.set(1, 0, 3);
        matrix7.set(1, 1, 4);

        Matrix<Integer> matrix8 = new Matrix<Integer>(2, 2);
        matrix8.set(0, 0, 1);
        matrix8.set(0, 1, 2);
        matrix8.set(1, 0, 3);
        matrix8.set(1, 1, 4);

        // Result of multiplication
        Integer[][] array4 = new Integer[][]{{7,10},
                                             {15,22}};
        Matrix<Integer> result4 = new Matrix<Integer>(2,2,array4);

        Matrix<Integer> matrix9 = matrix7.multiply(matrix8);
        assertTrue("Matrix multiplication error. matrix9="+matrix9+" result4"+result4, matrix9.equals(result4));


        System.out.printf("%s%% of branches are covered - original matrix:add.%n", CoverageMeasurer.getCoverage()* 100);

        CoverageMeasurer.teardown();

    }
//
//    @Test
//    public void testMatrixAddition() {
//        CoverageMeasurer.setup(10);
//
//        int rows = 2;
//        int cols = 2;
//
//        // Creating BIGDECIMAL test
//        BigDecimal[][] arrayBDinit = new BigDecimal[][]{{BigDecimal.valueOf(0),BigDecimal.valueOf(1)},
//                {BigDecimal.valueOf(2),BigDecimal.valueOf(3)}};
//        Matrix<BigDecimal> matrixBD = new Matrix<BigDecimal>(2,2,arrayBDinit);
//        Matrix<BigDecimal> matrixBD2 = new Matrix<BigDecimal>(2,2,arrayBDinit);
//
//        // Result of addition BIGDECIMAL
//        BigDecimal[][] arrayBD = new BigDecimal[][]{{BigDecimal.valueOf(0),BigDecimal.valueOf(2)},
//                {BigDecimal.valueOf(4),BigDecimal.valueOf(6)}};
//        Matrix<BigDecimal> resultBD = new Matrix<BigDecimal>(2,2,arrayBD);
//        Matrix<BigDecimal> matrixBDResult = matrixBD.add(matrixBD2);
//        assertTrue("Matrix addition error. matrixBDResult="+matrixBDResult+" resultBD"+resultBD, matrixBDResult.equals(resultBD));
//
//        // Creating BIGINTEGER test
//        BigInteger[][] arrayBIinit = new BigInteger[][]{{BigInteger.valueOf(0),BigInteger.valueOf(1)},
//                {BigInteger.valueOf(2),BigInteger.valueOf(3)}};
//        Matrix<BigInteger> matrixBI = new Matrix<BigInteger>(2,2,arrayBIinit);
//        Matrix<BigInteger> matrixBI2 = new Matrix<BigInteger>(2,2,arrayBIinit);
//
//        // Result of addition BIGINTEGER
//        BigInteger[][] arrayBI = new BigInteger[][]{{BigInteger.valueOf(0),BigInteger.valueOf(2)},
//                {BigInteger.valueOf(4),BigInteger.valueOf(6)}};
//        Matrix<BigInteger> resultBI = new Matrix<BigInteger>(2,2,arrayBI);
//        Matrix<BigInteger> matrixBIResult = matrixBI.add(matrixBI2);
//        assertTrue("Matrix addition error. matrixBIResult="+matrixBIResult+" resultBI"+resultBI, matrixBIResult.equals(resultBI));
//
//        // Creating LONG test
//        long counterLong = 0L;
//        Matrix<Long> matrixLong = new Matrix<Long>(rows, cols);
//        for (int r = 0; r < rows; r++)
//            for (int c = 0; c < cols; c++)
//                matrixLong.set(r, c, counterLong++);
//
//        // Result of addition LONG
//        Long[][] arrayLong = new Long[][]{{0L,2L},
//                {4L,6L}};
//        Matrix<Long> resultLong = new Matrix<Long>(2,2,arrayLong);
//
//        Matrix<Long> matrixLongResult = matrixLong.add(matrixLong);
//        assertTrue("Matrix addition error. matrixLongResult="+matrixLongResult+" resultLong"+resultLong, matrixLongResult.equals(resultLong));
//
//        // Creating DOUBLE test
//        double counterDouble = 0;
//        Matrix<Double> matrixDouble = new Matrix<Double>(rows, cols);
//        for (int r = 0; r < rows; r++)
//            for (int c = 0; c < cols; c++)
//                matrixDouble.set(r, c, counterDouble++);
//
//        // Result of addition DOUBLE
//        Double[][] arrayDouble = new Double[][]{{(double) 0, 2.0},
//                {4.0, 6.0}};
//        Matrix<Double> resultDouble = new Matrix<Double>(2,2,arrayDouble);
//
//        Matrix<Double> matrixDoubleResult = matrixDouble.add(matrixDouble);
//        assertTrue("Matrix addition error. matrixDoubleResult="+matrixDoubleResult+" resultDouble"+resultDouble, matrixDoubleResult.equals(resultDouble));
//
//        // Creating FLOAT test
//        float counterFloat = 0;
//        Matrix<Float> matrixFloat = new Matrix<Float>(rows, cols);
//        for (int r = 0; r < rows; r++)
//            for (int c = 0; c < cols; c++)
//                matrixFloat.set(r, c, counterFloat++);
//
//        // Result of addition FLOAT
//        Float[][] arrayFloat = new Float[][]{{(float) 0, 2F},
//                {4F, 6F}};
//        Matrix<Float> resultFloat = new Matrix<Float>(2,2,arrayFloat);
//
//        Matrix<Float> matrixFloatResult = matrixFloat.add(matrixFloat);
//        assertTrue("Matrix addition error. matrixFloatResult="+matrixFloatResult+" resultFloat"+resultFloat, matrixFloatResult.equals(resultFloat));
//
//        // Creating INTEGER test
//        int counterInt = 0;
//        Matrix<Integer> matrixInteger = new Matrix<Integer>(rows, cols);
//        for (int r = 0; r < rows; r++)
//            for (int c = 0; c < cols; c++)
//                matrixInteger.set(r, c, counterInt++);
//
//        // result of addition INTEGER
//        Integer[][] arrayInteger = new Integer[][]{{0,2},
//                {4,6}};
//        Matrix<Integer> resultInteger = new Matrix<Integer>(2,2,arrayInteger);
//
//        Matrix<Integer> matrixIntegerResult = matrixInteger.add(matrixInteger);
//        assertTrue("Matrix addition error. matrixIntegerResult="+matrixIntegerResult+" resultInteger"+resultInteger, matrixIntegerResult.equals(resultInteger));
//
//        // Creating wrong size matrices test
//        Integer[][] arrayMismatchinit = new Integer[][]{{0, 1},
//                {2, 3}};
//        Integer[][] arrayMismatchinit2 = new Integer[][]{{0, 1, 2},
//                {2, 3, 4}};
//        Matrix<Integer> matrixMismatch = new Matrix<Integer>(2,2,arrayMismatchinit);
//        Matrix<Integer> matrixMismatch2 = new Matrix<Integer>(2,3,arrayMismatchinit2);
//
//        // Result of addition
//        Integer[][] arrayMismatch = new Integer[][]{{0,2},
//                {4,6}};
//        Matrix<Integer> resultMismatch = new Matrix<Integer>(2,2,arrayMismatch);
//
//        Matrix<Integer> matrixMismatchResult = matrixMismatch.add(matrixMismatch2);
////        assertTrue("Matrix addition error. matrixMismatchResult="+matrixMismatchResult+" resultMismatch"+resultMismatch, matrixMismatchResult.equals(resultMismatch));
//        System.out.printf("%s%% of branches are covered - with new tests for matrix:add.%n", CoverageMeasurer.getCoverage()* 100);
//
//        CoverageMeasurer.teardown();
//
//    }
    
    @Test
    public void testIdentityMethod1() {
        Matrix<Integer> matrix = new Matrix<Integer>(2, 2);
        matrix.set(0, 0, 0);
        matrix.set(0, 1, 0);
        matrix.set(1, 0, 0);
        matrix.set(1, 1, 0);
        
        Matrix<Integer> expectedResult = new Matrix<Integer>(2, 2);
        expectedResult.set(0, 0, 1);
        expectedResult.set(0, 1, 0);
        expectedResult.set(1, 0, 0);
        expectedResult.set(1, 1, 1);
        
        try{
        	matrix = matrix.identity();
        } catch(Exception ex){
        	fail();
        }
        
        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
}
