package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BTree;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.TreeTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class BTreeTests {

    @Test
    public void testBTree() {
        TestData data = Utils.generateTestData(1000);

        CoverageMeasurer.setup(17);
        String bstName = "B-Tree";
        BTree<Integer> bst = new BTree<Integer>(2);
        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName, data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, Integer.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
                                             
        System.out.printf("%s%% of branches are covered.%n", CoverageMeasurer.getCoverage()* 100);
        CoverageMeasurer.teardown();
    }
}
