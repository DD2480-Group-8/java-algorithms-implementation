package com.jwetherell.algorithms.data_structures.test;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.Test;
import java.io.*;
import java.util.Arrays;


public class RBT_balanceAfterDeleteTest {

    @Test
    public void balanceAfterDeleteTest() {
        CoverageMeasurer.setup(13);
        RedBlackTreeTests test = new RedBlackTreeTests();
        test.testRedBlackTree();

        System.out.printf("%s%% of branches are covered.%n", CoverageMeasurer.getCoverage()* 100);
        System.out.println(Arrays.toString(CoverageMeasurer.getArray()));
        CoverageMeasurer.teardown();
    }
}