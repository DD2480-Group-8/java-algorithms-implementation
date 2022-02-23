package com.jwetherell.algorithms.data_structures.test;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.Test;


public class BST_replaceNodeWithNodeTest {

    @Test
    public void replaceNodeWithNodeTest() {
        CoverageMeasurer.setup(14);
        BinarySearchTreeTests test = new BinarySearchTreeTests();
        test.testBST();
//        test.testBSF();
//        test.testLevelOrder();
//        test.testLargeBFS();
//        test.testPreOrderDFS();
//        test.testLargePreOrderDFS();
//        test.testInOrderDFS();
//        test.testLargeInOrderDFS();
//        test.testPostOrderDFS();
//        test.testLargePostOrderDFS();

        System.out.printf("%s%% of branches are covered.%n", CoverageMeasurer.getCoverage()* 100);
        CoverageMeasurer.teardown();
    }
}