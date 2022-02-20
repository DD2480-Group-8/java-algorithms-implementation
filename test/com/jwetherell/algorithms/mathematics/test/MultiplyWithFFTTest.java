package com.jwetherell.algorithms.mathematics.test;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.Test;


public class MultiplyWithFFTTest {

    @Test
    public void testMultiplyWithFFT() {
        CoverageMeasurer.setup(17);

        MathematicsTest test = new MathematicsTest();
        test.multiplication();
        //System.out.println(CoverageMeasurer.getNumBranches());

        System.out.printf("%s%% of branches are covered.%n", CoverageMeasurer.getCoverage()* 100);

        CoverageMeasurer.teardown();
    }
}
