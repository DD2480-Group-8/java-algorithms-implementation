package com.jwetherell.algorithms.data_structures.test;

import java.util.Collection;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.HeapTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

import static org.junit.Assert.*;

public class BinaryHeapTests {
    private static BinaryHeapTests testClass = null;

    @Before
    public void setUp() {
        if (testClass == null) {
            testClass = this;
            // perform all the setup code
            CoverageMeasurer.setup(17);
        }
    }

    @Test
    public void testMinHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMin = "Min-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMin = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> aCollectionMin = aHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, aHeapMin, Integer.class, aNameMin,  
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMin, Integer.class, aNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String tNameMin = "Min-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMin = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> tCollectionMin = tHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, tHeapMin, Integer.class, tNameMin,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMin, Integer.class, tNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here
//
//        // Added to count branch coverage manually
//        System.out.printf("%s%% (%s/%s) of branches are covered in minHeap.%n", CoverageMeasurer.getCoverage()* 100, CoverageMeasurer.getNumberOfVisitedBranches(), CoverageMeasurer.getNumberOfBranches());
//        CoverageMeasurer.printResults();
//        CoverageMeasurer.teardown();
    }

    @Test
    public void testMaxHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMax = "Max-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMax = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> aCollectionMax = aHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, aHeapMax, Integer.class, aNameMax,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMax, Integer.class, aNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String lNameMax = "Max-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMax = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> tCollectionMax = tHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, tHeapMax, Integer.class, lNameMax,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMax, Integer.class, lNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here
    }

    @Test
    public void testMinHeapRemoveWithDuplicates() {
        // Test to add duplicates and then remove the root. This will increase branch coverage for heapDown
        BinaryHeap.BinaryHeapArray<Integer> aHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        Integer[] input = new Integer[]{1,2,2,3,4,5,6};
        for (Integer i: input) {
            aHeap.add(i);
        }
        // Can be true that a parent have two children of the same value
        assertTrue(aHeap.validate());
        // Root removed
        aHeap.remove(1);
        // Should fail as a child can't have the same value as the parent
        assertFalse(aHeap.validate());
    }

    @Test
    public void testMaxHeapRemoveWithDuplicates() {
        // Test to add duplicates and then remove the root. This will increase branch coverage for heapDown
        BinaryHeap.BinaryHeapArray<Integer> aHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        Integer[] input = new Integer[]{6,5,5,4,3,2,1};
        for (Integer i: input) {
            aHeap.add(i);
        }
        // Can be true that a parent have two children of the same value
        assertTrue(aHeap.validate());
        // Root removed
        aHeap.remove(6);
        // Should fail as a child can't have the same value as the parent
        assertFalse(aHeap.validate());

    }

    @AfterClass
    public static void tearDown() {
        // perform all the teardown work
        System.out.printf("%.1f%% (%s/%s) of branches are covered in BinaryHeapArray:heapDown.%n", CoverageMeasurer.getCoverage()* 100, CoverageMeasurer.getNumberOfVisitedBranches(), CoverageMeasurer.getNumberOfBranches());
        CoverageMeasurer.printUnvisitedBranches();
        CoverageMeasurer.teardown();

        testClass = null;
    }
}
